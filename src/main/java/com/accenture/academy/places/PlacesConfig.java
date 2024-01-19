package com.accenture.academy.places;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "accenture.academy.places")
@Data
class PlacesConfig {
    String apikey;
}
