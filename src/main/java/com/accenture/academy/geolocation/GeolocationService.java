package com.accenture.academy.geolocation;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class GeolocationService {
    //    private final GeolocationConfig config;
    private final HttpClient httpClient;

    @Value("${accenture.academy.places.apikey}")
    private String apikey;

    //@PostConstruct
    void getGeoLocation() throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.geoapify.com/v1/ipinfo?&apiKey=" + apikey))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        log.info(httpResponse.body().toString());
    }
}
