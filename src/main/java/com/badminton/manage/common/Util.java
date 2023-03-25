package com.badminton.manage.common;

import com.badminton.manage.bean.common.PageInfoResponse;
import com.badminton.manage.bean.common.ResponseData;
import com.badminton.manage.dto.common.CommonQueryResponseDTO;
import com.badminton.manage.dto.common.CommonResponseDTO;
import com.badminton.manage.dto.wx.RequestWxTokenDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Util {
    public static final String WX_TOKEN = "kangweisports";
    public static final String APP_ID = "wx54ae6f53aeb83918";
    public static final String APP_SECRET = "6dcf47313cb187bcba5dfd2d226ec8cc";
    // 返回通用响应体
    public static CommonResponseDTO getCommonResponseDTO(HashMap data) {
        CommonResponseDTO commonResponseDTO = new CommonResponseDTO(GlobalStatic.RESPONSE_CODE_SUCCESS, GlobalStatic.RESPONSE_SUCCESS_MSG);
        commonResponseDTO.setData(data);
        return commonResponseDTO;
    }

    // 返回通用查询响应体
    public static CommonQueryResponseDTO getCommonQueryResponseDTO(List list, int totalCount, int totalPage) {
        CommonQueryResponseDTO commonQueryResponseDTO = new CommonQueryResponseDTO(GlobalStatic.RESPONSE_CODE_SUCCESS, GlobalStatic.RESPONSE_SUCCESS_MSG);
        PageInfoResponse pageInfoResponse = new PageInfoResponse();
        pageInfoResponse.setTotalCount(totalCount);
        pageInfoResponse.setTotalPage(totalPage);
        ResponseData responseData = new ResponseData();
        responseData.setPageInfo(pageInfoResponse);
        responseData.setList(list);
        commonQueryResponseDTO.setData(responseData);
        return commonQueryResponseDTO;
    }

    public static <T> List<T> jsonArrayToList(String json, Class<T> elementClass) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType =
                objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
        return objectMapper.readValue(json, listType);
    }

    public static boolean checkSignature(RequestWxTokenDTO requestWxTokenDTO) {
        String[] str = new String[]{WX_TOKEN, requestWxTokenDTO.getTimestamp(), requestWxTokenDTO.getNonce()};
        //排序
        Arrays.sort(str);
        //拼接字符串
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            buffer.append(str[i]);
        }
        //进行sha1加密
        String temp = SHA1.encode(buffer.toString());
        //与微信提供的signature进行匹对
        return requestWxTokenDTO.getSignature().equals(temp);
    }
}