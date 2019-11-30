package ru.eltex.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.eltex.app.exception.OrderNotFoundException;
import ru.eltex.app.old_classes.Order;
import ru.eltex.app.old_classes.OrderFactory;

import java.util.HashMap;
import java.util.Map;

@Component
public class Orders {
    private Map<Integer, Order> orders;
    private OrderFactory orderFactory;

    @Autowired
    public Orders(OrderFactory orderFactory) {
        orders = new HashMap<>();
        this.orderFactory = orderFactory;
    }

    // TODO Делают ли так?
    public final Map<Integer, Order> getAll() {
        return orders;
    }

    public void addById(Integer id) {
        orders.put(id, orderFactory.getOrderById(id));
    }

    public Order getById(int order_id) {
        return orders.get(order_id);
    }

    @Override
    public String toString() {
        return orders.toString();
    }

    public boolean isContainsKey(Integer id) {
        return orders.containsKey(id);
    }

    public void delById(Integer id) throws OrderNotFoundException {
        if ( orders.remove(id) == null )
            throw new OrderNotFoundException();
    }
}
