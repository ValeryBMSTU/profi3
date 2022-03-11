package org.example.service;

import java.util.*;

/**
 * Различные вспомогательные функции
 */
public class Utils {
    /**
     * Хеш-таблица, хранящая email пользователя в качестве ключа и
     * объект с личными данными пользователя в качестве значения.
     */
    private static final Map<String, UserData> USERS = new HashMap<>();

    /**
     * Регистрирует пользователя в системе
     *
     * @param email электронная почта
     * @param password пароль
     * @param name имя
     * @param surname фамилия
     * @param mobile мобильный телефон
     * @return email, если пользователя успешно зарегистрирован или ошибку, если
     * пользователь уже есть в системе
     */
    public static String registerUser(String email,
                                      String password,
                                      String name,
                                      String surname,
                                      String mobile) {
        if (USERS.containsKey(email)) {
            return "Пользователь уже зарегистрирован!";
        } else {
            UserData userData = new UserData(email, password, name, surname, mobile);
            USERS.put(email, userData);
            return email;
        }
    }

    /**
     * Аутентификация пользователя по его электронной почте и личному паролю.
     *
     * @param email электронная почта
     * @param password пароль
     * @return OK, если пользователь идентифицирован или ошибку, если
     * пользователь не найден в системе или пароль не совпадает
     */
    public static String loginUser(String email, String password) {
        if (!USERS.containsKey(email)) {
            return "Пользователь не найден!";
        } else {
            UserData userData = USERS.get(email);
            if (!password.equals(userData.getPassword())) {
                return "Неверный пароль!";
            }
            return "OK";
        }
    }
}
