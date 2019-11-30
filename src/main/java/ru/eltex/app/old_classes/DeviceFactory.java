package ru.eltex.app.old_classes;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Фабричный класс синглтон, возвращающий случайным образом
 * наследника класса товаров Device.
 *
 * Паттерн реализован ввиде Double Checked Locking and volatile Singleton.
 */
@Component
public class DeviceFactory {

    // TODO Если мы используем spring нужно ли писать ЭТО: ??
//    private static volatile DeviceFactory instance;
//    private DeviceFactory(){}
//
//    public static DeviceFactory getInstance() {
//        DeviceFactory localInstance = instance;
//        if (localInstance == null) {
//            synchronized (DeviceFactory.class) {
//                localInstance = instance;
//                if (localInstance == null) {
//                    instance = localInstance = new DeviceFactory();
//                }
//            }
//        }
//        return localInstance;
//    }

    private String[] arrayName = { "Hi", "Love", "Tree", "Stone" };
    private String[] arrayBrand = { "LG", "Samsung", "Sony", "Huawei", "Apple" };
    private String[] arrayModel = { "FIG-01", "Kl-1", "5", "One" };
    private Random random = new Random();

    private GameConsole getGameConsole() {
        return new GameConsole(
                 1024,
                 100,
                 arrayName[ random.nextInt(arrayName.length) ],
                 arrayBrand[ random.nextInt(arrayBrand.length) ],
                 arrayModel[ random.nextInt(arrayModel.length) ]
        );
    }
    private SetTopBox getSetTopBox() {
        return new SetTopBox(
                26,
                17,
                5,
                100,
                arrayName[ random.nextInt(arrayName.length) ],
                arrayBrand[ random.nextInt(arrayBrand.length) ],
                arrayModel[ random.nextInt(arrayModel.length) ]
        );
    }
    private TVSet getTVSet() {
        return new TVSet(
                103,
                100,
                arrayName[ random.nextInt(arrayName.length) ],
                arrayBrand[ random.nextInt(arrayBrand.length) ],
                arrayModel[ random.nextInt(arrayModel.length) ]
        );
    }

    public Device getDevice() {
        int tmp = random.nextInt(3);
        switch (tmp) {
            case  (0):
                return getGameConsole();
            case (1):
                return getSetTopBox();
            case (2):
                return getTVSet();
       }
       return getTVSet();
    }
}
