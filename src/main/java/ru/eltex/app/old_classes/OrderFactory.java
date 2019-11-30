package ru.eltex.app.old_classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.eltex.app.GlobalConsts;
import ru.eltex.app.Orders;

import java.util.Random;

/**
 * Класс в потоке через каждый установленный интервал времени
 * создает в коллекции Orders новый заказ
 */
@Component
public class OrderFactory {

    private Random random = new Random();
    private CredentialsFactory credentialsFactory;
    private DeviceFactory deviceFactory;

    @Autowired
    public OrderFactory(CredentialsFactory credentialsFactory, DeviceFactory deviceFactory) {
        this.credentialsFactory = credentialsFactory;
        this.deviceFactory = deviceFactory;
    }

    public Order getOrder() {
        ShoppingCart<Device> cart = new ShoppingCart<>();
        int count_device = random.nextInt(GlobalConsts.MAX_DEVICE_COUNT_IN_CARTS + 1);
        for (int i = 0; i < count_device; i++) {
            cart.add(deviceFactory.getDevice());
        }
        return new Order(cart, credentialsFactory.getCredentials());
    }

    // TODO Очень не нужный метод :) в архитектурном плане
    public Order getOrderById(Integer id) {
        ShoppingCart<Device> cart = new ShoppingCart<>();
        int count_device = random.nextInt(GlobalConsts.MAX_DEVICE_COUNT_IN_CARTS + 1);
        for (int i = 0; i < count_device; i++) {
            cart.add(deviceFactory.getDevice());
        }
        Order tmp = new Order(cart, credentialsFactory.getCredentials());
        tmp.setId(id);
        return tmp;
    }
}
