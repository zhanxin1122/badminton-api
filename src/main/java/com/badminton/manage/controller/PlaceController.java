package com.badminton.manage.controller;

import com.alibaba.fastjson.JSON;
import com.badminton.manage.bean.place.Place;
import com.badminton.manage.dto.common.CommonQueryResponseDTO;
import com.badminton.manage.dto.common.CommonResponseDTO;
import com.badminton.manage.dto.place.RequestQueryPlaceDTO;
import com.badminton.manage.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping("/list")
    public CommonQueryResponseDTO list(@RequestBody RequestQueryPlaceDTO requestQueryPlaceDTO) {
        System.out.println("queryPlaceDTO=====" + JSON.toJSONString(requestQueryPlaceDTO));
        return placeService.queryPlace(requestQueryPlaceDTO);
    }

    @PostMapping("/add")
    public CommonResponseDTO add(@RequestBody Place place) {
        System.out.println("addPlaceDTO=====" + JSON.toJSONString(place));
        return placeService.addPlace(place);
    }

    @PostMapping("/delete")
    public CommonResponseDTO delete(@RequestBody Place place) {
        System.out.println("deletePlaceDTO=====" + JSON.toJSONString(place));
        return placeService.deletePlace(place);
    }

    @PostMapping("/update")
    public CommonResponseDTO update(@RequestBody Place place) {
        System.out.println("updatePlaceDTO=====" + JSON.toJSONString(place));
        return placeService.updatePlace(place);
    }
}