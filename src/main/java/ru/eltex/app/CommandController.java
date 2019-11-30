package ru.eltex.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.eltex.app.exception.BadCommandException;
import ru.eltex.app.exception.OrderNotFoundException;
import ru.eltex.app.old_classes.Device;
import ru.eltex.app.old_classes.DeviceFactory;
import ru.eltex.app.old_classes.Order;

@RestController
public class CommandController {
    private Orders orders;
    private DeviceFactory deviceFactory;

    final static Logger logger = LogManager.getLogger(CommandController.class);

    @Autowired
    public CommandController(Orders orders, DeviceFactory deviceFactory) {
        this.orders = orders;
        this.deviceFactory = deviceFactory;
    }

    @RequestMapping("/")
    public String Command(@RequestParam(value="command") String command,
                          @RequestParam(value="order_id", required=false, defaultValue="-1") int order_id,
                          @RequestParam(value="card_id", required=false, defaultValue="-1") int card_id) {

        try {
            if (command.equals("readall")) {
                logger.info("Command: readall");

                return "{" +
                        "orders=" + orders.toString() +
                        "}";
            }

            if (command.equals("readById")) {
                if ( order_id == -1 )
                    throw new BadCommandException();
                logger.info("Command: readById; card_id: " + order_id);
                return orders.getById(order_id).toString();
            }

            if (command.equals("addToCard")) {
                if ( card_id == -1 )
                    throw new BadCommandException();
                logger.info("Command: addToCard; card_id: " + card_id);
                Order tmp = orders.getById(card_id);
                if (tmp == null) {
                    orders.addById(card_id);
                    tmp = orders.getById(card_id);
                }
                Device dev = deviceFactory.getDevice();
                tmp.getCart().add(dev);
                return "{ device_id: " + dev.getId().toString() + "}";
            }

            if (command.equals("delById")) {
                logger.info("Command: delById; order_id: " + order_id);
                orders.delById(order_id);
                return "0";
            }

            throw new BadCommandException();
        }
        catch (BadCommandException e) {
            logger.error(e.getMessage());
            return e.toString();
        }
        catch (OrderNotFoundException e) {
            logger.error(e.getMessage());
            return e.toString();
        }

    }
}