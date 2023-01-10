package org.ufv.dis.Front;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIMayor {
    private static final String fullUrl = "localhost:8080/covidmayor";
    public String getCovidMayor() throws URISyntaxException, IOException,
            InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(fullUrl))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }
    public String getPokemonPorTipo(String tipo) throws URISyntaxException, IOException,
            InterruptedException {       String fullUrl = String.format(urlPref
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(fullUrl))
                    .GET()               .build();
        HttpResponse<String> response = HttpClient
                .newBuilder()               .build()               .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();   }

}