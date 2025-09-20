package com.example.demo.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Client {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        HttpClient client = HttpClient.newHttpClient();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<Void> task = () -> {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/stock/MSFT?interval=1min"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response: " + response.body());
            return null;
        };

        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tasks.add(task);
        }

        executorService.invokeAll(tasks);
        executorService.shutdown();
    }
}
