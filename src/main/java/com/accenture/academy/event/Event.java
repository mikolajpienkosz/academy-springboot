package com.accenture.academy.event;

import com.accenture.academy.ip.Ip;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class Event extends ApplicationEvent {
    String ipAddress;
    public Event(Object source, Ip ipAddress) {
        super(source);
        this.ipAddress = ipAddress.getIp();
    }

    public String getIpAddress(){
        return this.ipAddress;
    }
}
