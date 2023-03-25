package com.badminton.manage.service;
import com.badminton.manage.bean.common.PageInfo;
import com.badminton.manage.dto.common.CommonQueryResponseDTO;
import com.badminton.manage.dto.place.RequestQueryPlaceDTO;
import com.badminton.manage.bean.place.Place;
import com.badminton.manage.dto.common.CommonResponseDTO;
import com.badminton.manage.integration.dao.PlaceDao;
import com.badminton.manage.common.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceDao placeDao;

    public CommonQueryResponseDTO queryPlace(RequestQueryPlaceDTO requestQueryPlaceDTO) {
        PageInfo pageInfo = requestQueryPlaceDTO.getPageInfo();
        int pageNo = pageInfo.getPageNo();
        int pageSize = pageInfo.getPageSize();
        int firstIndex = (pageNo - 1) * pageSize;
        requestQueryPlaceDTO.setFirstIndex(firstIndex);
        requestQueryPlaceDTO.setPageSize(pageSize);
        List<Place> placeList = placeDao.queryPlace(requestQueryPlaceDTO);
        int totalCount = placeDao.countPlace(requestQueryPlaceDTO);
        double totalPage = Math.ceil((double) totalCount / (double) pageSize);
        System.out.println("分页信息=====");
        System.out.println(totalCount);
        System.out.println(totalPage);
        CommonQueryResponseDTO commonQueryResponseDTO = Util.getCommonQueryResponseDTO(placeList, totalCount, (int)totalPage);
        return commonQueryResponseDTO;
    }
    public CommonResponseDTO addPlace(Place place) {
        placeDao.addPlace(place);
        return Util.getCommonResponseDTO(null);
    }

    public CommonResponseDTO deletePlace(Place place) {
        placeDao.deletePlace(place);
        return Util.getCommonResponseDTO(null);
    }

    public CommonResponseDTO updatePlace(Place place) {
        placeDao.updatePlace(place);
        return Util.getCommonResponseDTO(null);
    }
}