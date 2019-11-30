package ru.eltex.app.old_classes;

import java.util.Scanner;

public class TVSet extends Device {

    // в см
    private int diagonal;

    public TVSet(int diagonal, int price, String name,
                        String brand, String model) {
        this.diagonal = diagonal;
        this.price = price;
        this.name = name;
        this.brand = brand;
        this.model = model;

        super.create();
    }

    @Override
    public void read() {
        super.read();
        System.out.println("diagonal= " + diagonal);
    }

    @Override
    public void update() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input TVSet: name brand model price diagonal");
        name = in.next();
        brand = in.next();
        model = in.next();
        price = in.nextInt();
        diagonal = in.nextInt();
    }

    @Override
    public void delete() {
        diagonal = 0;
        super.delete();
    }
}
