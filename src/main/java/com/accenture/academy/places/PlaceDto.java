package com.accenture.academy.places;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlaceDto {
    String name;
    String country;
    String city;

    public PlaceDto(@JsonProperty("name") String name,
                    @JsonProperty("country") String country,
                    @JsonProperty("city") String city){
        this.name =  name;
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "\nPlaceDto{" +
                "\nname='" + name + '\'' +
                ", \ncountry='" + country + '\'' +
                ", \ncity='" + city + '\'' +
                '}';
    }
}
