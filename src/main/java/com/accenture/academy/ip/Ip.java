package com.accenture.academy.ip;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Ip {
    String ip;

    @JsonCreator
    public Ip(@JsonProperty("ip") String ipAddress) {
        this.ip = ipAddress;
    }

}
