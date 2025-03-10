package org.example.httpTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.httpTask.response.ServerResponse;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.http.HttpResponse;

/**
 * Преобразование json в объект
 */
public class JsonObjectMapper {

    private final SyncHttpClient syncHttpClient = new SyncHttpClient();

    /**
     * Получить объект JSON
     * @return объект
     */
    protected ServerResponse getObject() throws IOException, InterruptedException {
        HttpResponse<String> response = syncHttpClient.getResponse();
        if (response.statusCode() != 200) {
            throw new InterruptedIOException("Ошибка ответа");
        }

        String jsonResponse = response.body();
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonResponse,
                ServerResponse.class);
    }
}
