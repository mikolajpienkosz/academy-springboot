package com.accenture.academy.church;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ChurchDto {
    @NotNull(message = "name must not be null")
    private String name;
    @NotBlank(message = "city must not be blank")
    @Pattern(regexp = "^([a-zA-Z\\u0080-\\u024F]+(?:. |-| |'))*[a-zA-Z\\u0080-\\u024F]*$", message = "city name must be real")
    private String nameOfCity;
    @Min(value = 10, message = "number of seats cannot be lesser than 10")
    private Integer numberOfSeats;
    @NotNull
    private Integer numberOfMembers;
    @Min(1000)
    private Double budget;
}
