package com.accenture.academy.ipinfoservice;

import com.accenture.academy.event.Event;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
@RequiredArgsConstructor
class IpInfoService {
    private final IpInfoRepository ipInfoRepositoryImpl;
    private final IpInfoMapper ipInfoMapper = new IpInfoMapper();
    private final HttpClient httpClient;

    @EventListener
    public void handleValueReturnedEvent(Event event) throws IOException, InterruptedException {
        String value = event.getIpAddress();
        addIpInfo(value);
    }

    void addIpInfo(String ipAddress) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create("https://ipinfo.io/"+ipAddress+"/geo"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = httpResponse.body().toString();

        ObjectMapper objectMapper = new ObjectMapper();
        IpInfoDto ipInfoDto = objectMapper.readValue(response, IpInfoDto.class);

        log.info("City:");
        log.info(ipInfoDto.getCity());

        IpInfoDao ipInfoDao = ipInfoMapper.mapDtoToDao(ipInfoDto);
        ipInfoRepositoryImpl.save(ipInfoDao);
    }
}
