package ru.eltex.app.old_classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import ru.eltex.app.CommandController;

import java.util.Random;

/**
 * Фабричный класс синглтон, возвращающий класса Credentials.
 *
 * Паттерн реализован ввиде Double Checked Locking and volatile Singleton.
 */
@Component
public class CredentialsFactory {

    final static Logger logger = LogManager.getLogger(CredentialsFactory.class);

    private static int id;

    private String[] arrayName = { "Николай", "Иван", "Петр", "Антон" };
    private String[] arraySurname = { "Иванов", "Сидоров", "Петров", "Николаев", "Груодис" };
    private String[] arrayPatronymic = { "Петрович", "Иванович", "Сидорович", "Сергеевич" };
    private String[] arrayEmail = { "FIG-01@mail.com", "Kl-1@gmail.com", "5@one.ua", "One@yandex.ru" };
    private Random random = new Random();

    public Credentials getCredentials() {
        Credentials tmp = new Credentials(
                                            id,
                                            arrayName[ random.nextInt(arrayName.length) ],
                                            arraySurname[ random.nextInt(arraySurname.length) ],
                                            arrayPatronymic[ random.nextInt(arrayPatronymic.length) ],
                                            arrayEmail[ random.nextInt(arrayEmail.length) ]
                                         );
        logger.info("New credentials: id="+tmp.getId()+", name="+tmp.getName()+", email="+tmp.getEmail());
        return tmp;
    }
}
