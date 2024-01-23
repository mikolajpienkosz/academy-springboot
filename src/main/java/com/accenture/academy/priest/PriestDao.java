package com.accenture.academy.priest;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRIEST")
public class PriestDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long height;
    @Transient
    private Long age;

    Location location;

    public PriestDao(String name, Long height, Long age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }
}
