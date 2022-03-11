package org.example.service;

import org.example.service.webserver.FormData;
import org.example.service.webserver.Handler;
import org.example.service.webserver.Response;

import java.util.Map;

/**
 * Обработчик запросов из веб-интерфейса
 */
public class WebInterface implements Handler {

    /**
     * Конструктор веб-интерфейса
     */
    WebInterface() {
    }

    /**
     * Обрабатывает запрос, содержащий параметры, например, http://localhost:8000?param_1=xxx&param_2=yyy
     * @param request Распарсенные параметры запроса
     * @return Ответ веб-интерфейсу
     */
    @Override
    public Response handle(Map<String, FormData> request) {
        if (request.containsKey("action")) {
            String action = request.get("action").getValue();
            switch (action) {
                case "register": {
                    String email = request.get("email").getValue();
                    String password = request.get("password").getValue();
                    String name = request.get("name").getValue();
                    String surname = request.get("surname").getValue();
                    String mobile = request.get("mobile").getValue();
                    String result = Utils.registerUser(email, password,
                            name, surname,
                            mobile);
                    return new TextResponse(result);
                }
                case "login": {
                    String email = request.get("email").getValue();
                    String password = request.get("password").getValue();
                    return new TextResponse(Utils.loginUser(email, password));
                }
            }
        }
        return new Response() {
            @Override
            public String getContentType() {
                return "application/json";
            }

            @Override
            public byte[] getData() {
                return "{ }".getBytes();
            }
        };
    }

    /**
     * Обрабатывает запрос, не содержащий параметров.
     * В данной реализации мы пока не обрабатываем такие запросы
     * @param address Адрес
     * @return всегда null, но в будущем все может поменяться
     */
    @Override
    public Response handle(String address) {
        return null;
    }

    /**
     * Имплементация интерфейса Response, возвращающая целое число
     */
    static private class IntResponse implements Response {
        int value;

        IntResponse(int value) {
            this.value = value;
        }

        @Override
        public String getContentType() {
            return "application/json";
        }

        @Override
        public byte[] getData() {
            String data = "{\"value\":" + value + '}';
            return data.getBytes();
        }
    }

    /**
     * Имплементация интерфейса Response, возвращающая текст
     */
    static private class TextResponse implements Response {
        String value;

        TextResponse(String value) {
            this.value = value;
        }

        @Override
        public String getContentType() {
            return "plain/text";
        }

        @Override
        public byte[] getData() {
            return value.getBytes();
        }
    }

    /**
     * Имплементация интерфейса Response, возвращающая булевое значение
     */
    static private class BooleanResponse implements Response {
        boolean value;

        BooleanResponse(boolean value) {
            this.value = value;
        }

        @Override
        public String getContentType() {
            return "application/json";
        }

        @Override
        public byte[] getData() {
            String data = "{\"value\":" + value + '}';
            return data.getBytes();
        }
    }
}
