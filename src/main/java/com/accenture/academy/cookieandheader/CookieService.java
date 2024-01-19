package com.accenture.academy.cookieandheader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class CookieService {
    private final HttpClient httpClient;
    void consumeWithCookie(String ipAddress) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .header("AddressWhereIp", ipAddress)
                .uri(URI.create("https://catfact.ninja/fact"))
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        log.info(httpResponse.body());
    }
}
