package com.accenture.academy.places;

public class PlacesMapper {
    PlaceDao mapDtoToDao(PlaceDto placeDto){
        PlaceDao placeDao = new PlaceDao();
        placeDao.setName(placeDto.getName());
        placeDao.setCountry(placeDto.getCountry());
        placeDao.setCity(placeDto.getCity());
        return placeDao;
    }
}
