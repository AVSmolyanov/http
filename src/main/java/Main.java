import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
        try (
                CloseableHttpResponse response = httpClient.execute(request)) {

//            Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
            String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
//            System.out.println(body);

            ObjectMapper objectMapper = new ObjectMapper();

            List<Cat> cats = objectMapper.readValue(body, new TypeReference<List<Cat>>() {
            });
            cats.stream().filter(value -> value.getUpvotes() != null && Integer.parseInt(value.getUpvotes()) > 0).forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
