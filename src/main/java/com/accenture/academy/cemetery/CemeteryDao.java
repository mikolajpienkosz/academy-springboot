package com.accenture.academy.cemetery;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "CEMETERY")
public class CemeteryDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
