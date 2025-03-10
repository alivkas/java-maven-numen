package org.example.httpTask.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Структура ответа сервера
 */
public class ServerResponse {

    @JsonProperty("args")
    private Map<String, String> args;
    @JsonProperty("headers")
    private Headers headers;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("url")
    private String url;

    /**
     * Получить аргументы
     * @return словарь с аргументами
     */
    public Map<String, String> getArgs() {
        return args;
    }

    /**
     * Установить аргументы
     * @param args словарь с аргументами
     */
    public void setArgs(Map<String, String> args) {
        this.args = args;
    }

    /**
     * Получить заголовки
     * @return заголовки
     */
    public Headers getHeaders() {
        return headers;
    }

    /**
     * Установить заголовки
     * @param headers заголовки
     */
    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    /**
     * Получить источник
     * @return источник
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Установить источник
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Получить URL
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Установить URL
     * @param url URL
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
