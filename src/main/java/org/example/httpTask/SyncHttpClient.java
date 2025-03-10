package org.example.httpTask;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Синхронные http запросы
 */
public class SyncHttpClient {

    private final static String URL = "https://httpbin.org/get";

    /**
     * Получить ответ от сервера
     * @return ответ сервера
     */
    protected HttpResponse<String> getResponse() throws IOException, InterruptedException {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request  = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .GET()
                    .build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        }
    }
}
