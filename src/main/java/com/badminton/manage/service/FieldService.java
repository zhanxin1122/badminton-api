package com.badminton.manage.service;

import com.alibaba.fastjson.JSON;
import com.badminton.manage.bean.field.Field;
import com.badminton.manage.bean.common.PageInfo;
import com.badminton.manage.common.GlobalStatic;
import com.badminton.manage.dto.common.CommonDataListResponseDTO;
import com.badminton.manage.dto.common.CommonQueryResponseDTO;
import com.badminton.manage.dto.field.PayDetailDTO;
import com.badminton.manage.dto.field.RequestQueryFieldDTO;
import com.badminton.manage.dto.common.CommonResponseDTO;
import com.badminton.manage.dto.field.RequestQueryFieldTimeDTO;
import com.badminton.manage.dto.field.RequestQueryFieldTimeItemDTO;
import com.badminton.manage.integration.dao.FieldDao;
import com.badminton.manage.common.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FieldService {
    @Autowired
    private FieldDao fieldDao;

    public CommonQueryResponseDTO queryField(RequestQueryFieldDTO requestQueryFieldDTO) {
        if (requestQueryFieldDTO.getName() == null) {
            requestQueryFieldDTO.setName("");
        }
        PageInfo pageInfo = requestQueryFieldDTO.getPageInfo();
        int pageNo = pageInfo.getPageNo();
        int pageSize = pageInfo.getPageSize();
        int firstIndex = (pageNo - 1) * pageSize;
        requestQueryFieldDTO.setFirstIndex(firstIndex);
        requestQueryFieldDTO.setPageSize(pageSize);
        System.out.println(firstIndex);
        System.out.println(pageSize);
        List<Field> fieldList = fieldDao.queryField(requestQueryFieldDTO);
        int totalCount = fieldDao.countField(requestQueryFieldDTO);
        double totalPage = Math.ceil((double) totalCount / (double) pageSize);
        System.out.println("分页信息=====");

        System.out.println(requestQueryFieldDTO.getName());
        System.out.println(totalCount);
        System.out.println(totalPage);
        CommonQueryResponseDTO commonQueryResponseDTO = Util.getCommonQueryResponseDTO(fieldList, totalCount,
                (int) totalPage);
        return commonQueryResponseDTO;
    }

    public CommonDataListResponseDTO getFieldTime(RequestQueryFieldTimeDTO requestQueryFieldTimeDTO) {
        List<Integer> fieldList = requestQueryFieldTimeDTO.getFieldIdList();
        String startDate = requestQueryFieldTimeDTO.getStartDate();
        String endDate = requestQueryFieldTimeDTO.getEndDate();
        List<String> responseList = new ArrayList<String>();
        for (Integer fieldId : fieldList) {
            RequestQueryFieldTimeItemDTO requestQueryFieldTimeItemDTO = new RequestQueryFieldTimeItemDTO(startDate,
                    endDate, fieldId);
            System.out.println("strList======" + startDate);
            System.out.println("strList======" + endDate);
            System.out.println(fieldId);
            List<String> strList = fieldDao.getFieldTime(requestQueryFieldTimeItemDTO);
            String tmp = "";
            for (String s : strList) {
                tmp += (tmp == "" ? s : "," + s);
            }
            responseList.add(tmp);

        }
        CommonDataListResponseDTO commonDataListResponseDTO = new CommonDataListResponseDTO(
                GlobalStatic.RESPONSE_CODE_SUCCESS, GlobalStatic.RESPONSE_SUCCESS_MSG);
        commonDataListResponseDTO.setData(responseList);
        System.out.println("strList======" + JSON.toJSONString(responseList));
        return commonDataListResponseDTO;
    }

    public CommonResponseDTO addField(Field field) {
        fieldDao.addField(field);
        return Util.getCommonResponseDTO(null);
    }

    public CommonResponseDTO deleteField(Field field) {
        fieldDao.deleteField(field);
        return Util.getCommonResponseDTO(null);
    }

    public CommonResponseDTO updateField(Field field) {
        fieldDao.updateField(field);
        return Util.getCommonResponseDTO(null);
    }

    public CommonDataListResponseDTO payList() {
        List<PayDetailDTO> list = fieldDao.payList();
        CommonDataListResponseDTO commonDataListResponseDTO = new CommonDataListResponseDTO(
                GlobalStatic.RESPONSE_CODE_SUCCESS, GlobalStatic.RESPONSE_SUCCESS_MSG);
        commonDataListResponseDTO.setData(list);
        return commonDataListResponseDTO;
    }

    public CommonResponseDTO payUpdate(List<PayDetailDTO> list) {
        for (PayDetailDTO payDetailDTO : list) {
            fieldDao.payUpdate(payDetailDTO);
        }
        return Util.getCommonResponseDTO(null);
    }
}