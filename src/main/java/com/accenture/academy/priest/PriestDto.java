package com.accenture.academy.priest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class PriestDto {
    @NotNull
    @Pattern(regexp = "/^(?:[[:alpha:]]|[ \\-\\'])+$/gmui", message = "name must be real")
    private String name;
    @Min(value = 150, message = "must not be a dwarf")
    private Long height;
    @Min(value = 18, message = "must be an adult")
    private Long age;
}
