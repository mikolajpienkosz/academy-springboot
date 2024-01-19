package com.accenture.academy.places;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlacesRepository extends JpaRepository<PlaceDao, Long> {
}
