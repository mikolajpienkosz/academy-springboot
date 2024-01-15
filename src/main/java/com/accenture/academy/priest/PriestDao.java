package com.accenture.academy.priest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
class PriestDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long height;
    private Long age;

    PriestDao(String name, Long height, Long age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }
}
