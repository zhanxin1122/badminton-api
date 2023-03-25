package com.badminton.manage.integration.dao;

import com.badminton.manage.bean.place.Place;
import com.badminton.manage.dto.place.RequestQueryPlaceDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaceDao {
    public List<Place> queryPlace(RequestQueryPlaceDTO requestQueryPlaceDTO);
    public int countPlace(RequestQueryPlaceDTO requestQueryPlaceDTO);
    public void addPlace(Place place);
    public void deletePlace(Place place);
    public void updatePlace(Place place);
}