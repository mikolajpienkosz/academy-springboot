package com.accenture.academy.ipinfoservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpInfoDto {
    String ip;
    String city;
    String region;
    String country;
    String loc;
    String org;
    String postal;
    String timezone;
    String readme;
}
