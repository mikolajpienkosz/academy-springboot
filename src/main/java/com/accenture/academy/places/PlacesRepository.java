package com.accenture.academy.places;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PlacesRepository {
    private final IPlacesRepository iPlacesRepository;

    void save(PlaceDao placeDao){
        iPlacesRepository.save(placeDao);
    }
}
