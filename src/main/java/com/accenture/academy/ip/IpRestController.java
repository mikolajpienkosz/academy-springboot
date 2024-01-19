package com.accenture.academy.ip;

import com.accenture.academy.event.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/apiconsuming")
@RequiredArgsConstructor
class IpRestController {
    private final IpService ipService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @GetMapping
    Ip getIpAddress() throws IOException, InterruptedException {
        Ip result = ipService.getIpAddress();
        applicationEventPublisher.publishEvent(new Event(this, result));
        return result;
    }
}
