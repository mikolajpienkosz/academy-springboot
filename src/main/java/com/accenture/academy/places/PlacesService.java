package com.accenture.academy.places;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlacesService {
    private final PlacesConfig config;
    private final PlacesRepository placesRepository;
    private final PlacesMapper placesMapper = new PlacesMapper();
    private final HttpClient httpClient;

    //@PostConstruct
    void saveGeoLocation() throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.geoapify.com/v2/places?categories=commercial.supermarket&filter=rect%3A10.716463143326969%2C48.755151258420966%2C10.835314015356737%2C48.680903341613316&limit=20&apiKey="+config.getApikey()))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = (String) httpResponse.body();

        JsonNode rootNode = mapper.readTree(jsonString);
        JsonNode featuresArrayNode = rootNode.path("features");

        List<PlaceDto> placeDtoList = new ArrayList<>();

        for (JsonNode featureNode : featuresArrayNode) {
            JsonNode propertiesNode = featureNode.path("properties");
            String name = propertiesNode.path("name").asText();
            String country = propertiesNode.path("country").asText();
            String city = propertiesNode.path("city").asText();
            placeDtoList.add(new PlaceDto(name, country, city));
        }
        for (PlaceDto p : placeDtoList){
            placesRepository.save(placesMapper.mapDtoToDao(p));
            log.info(p.toString());
        }
    }
}
