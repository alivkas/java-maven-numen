package org.example.httpTask;

import org.example.interfaces.Output;

import java.io.IOException;

/**
 * Вывести только значение хоста сервера (поле “Host”) из
 * заголовков (запрос выполняется по адресу “https://httpbin.org/get”).
 */
public class HttpTask implements Output {

    private final JsonObjectMapper mapper = new JsonObjectMapper();

    @Override
    public void print() {
        try {
            System.out.println("Host: " + getHost());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Получить хост из заголовка
     * @return хост в виде строки
     */
    private String getHost() throws IOException, InterruptedException {
        return mapper.getObject()
                .getHeaders()
                .getHost();
    }
}
