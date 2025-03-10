package org.example.httpTask.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Структура заголовков
 */
public class Headers {

    @JsonProperty("Host")
    private String host;
    @JsonProperty("User-Agent")
    private String userAgent;
    @JsonProperty("X-Amzn-Trace-Id")
    private String xAmznTraceId;

    /**
     * Получить хост
     * @return хост
     */
    public String getHost() {
        return host;
    }

    /**
     * Установить хост
     * @param host хост
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Получить юзер агент
     * @return юзер агент
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Установить юзер агент
     * @param userAgent юзер агент
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * Получить id
     * @return id
     */
    public String getxAmznTraceId() {
        return xAmznTraceId;
    }

    /**
     * Установить id
     * @param xAmznTraceId id
     */
    public void setxAmznTraceId(String xAmznTraceId) {
        this.xAmznTraceId = xAmznTraceId;
    }
}
