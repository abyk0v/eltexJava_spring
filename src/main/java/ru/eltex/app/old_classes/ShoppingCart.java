package ru.eltex.app.old_classes;

import java.io.Serializable;
import java.util.*;

public class ShoppingCart<T extends Device> implements Serializable {

    private Map<Integer, T> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }

    @Override
    public String toString() {
        return cart.toString();
    }

    public void add(T dev) {
        cart.put(dev.getId(), dev);
    }

    public void delete(T dev) {
        cart.remove(dev.getId());
    }

    public void printAll() {
        for ( T dev: cart.values()) {
            System.out.println("---------");
            dev.read();
        }
        System.out.println("cart.size()= " + cart.size());
    }

    public int getCountItem() {
        return cart.size();
    }

    public T getDeviceOnID(int id) {
        for (Map.Entry entry: cart.entrySet()) {
            if ( entry.getKey().equals(id) )
                return (T) entry.getValue();
        }
        return null;
    }

    public boolean isHaveDevice(int id) {
        return cart.containsKey(id);
    }
}
