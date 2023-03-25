package com.badminton.manage.controller;

import com.alibaba.fastjson.JSON;
import com.badminton.manage.bean.field.Field;
import com.badminton.manage.dto.common.CommonDataListResponseDTO;
import com.badminton.manage.dto.common.CommonQueryResponseDTO;
import com.badminton.manage.dto.common.CommonResponseDTO;
import com.badminton.manage.dto.field.PayUpdateRequestDTO;
import com.badminton.manage.dto.field.RequestQueryFieldDTO;
import com.badminton.manage.dto.field.RequestQueryFieldTimeDTO;
import com.badminton.manage.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/field")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @PostMapping("/list")
    public CommonQueryResponseDTO list(@RequestBody RequestQueryFieldDTO requestQueryFieldDTO) {
        System.out.println("queryFieldDTO=====" + JSON.toJSONString(requestQueryFieldDTO));
        return fieldService.queryField(requestQueryFieldDTO);
    }

    @PostMapping("/add")
    public CommonResponseDTO add(@RequestBody Field field) {
        System.out.println("addFieldDTO=====" + JSON.toJSONString(field));
        return fieldService.addField(field);
    }

    @PostMapping("/delete")
    public CommonResponseDTO delete(@RequestBody Field field) {
        System.out.println("deleteFieldDTO=====" + JSON.toJSONString(field));
        return fieldService.deleteField(field);
    }

    @PostMapping("/update")
    public CommonResponseDTO update(@RequestBody Field field) {
        System.out.println("updateFieldDTO=====" + JSON.toJSONString(field));
        return fieldService.updateField(field);
    }

    @PostMapping("/pay/list")
    public CommonDataListResponseDTO payList() {
        System.out.println("payList=====");
        return fieldService.payList();
    }

    @PostMapping("/pay/update")
    public CommonResponseDTO payUpdate(@RequestBody PayUpdateRequestDTO payUpdateRequestDTO) {
        System.out.println("/pay/update=====" + JSON.toJSONString(payUpdateRequestDTO));
        return fieldService.payUpdate(payUpdateRequestDTO.getList());
    }

    @PostMapping("/time")
    public CommonDataListResponseDTO getFieldTime(@RequestBody RequestQueryFieldTimeDTO requestQueryFieldTimeDTO) {
        System.out.println("/field/time=====" + JSON.toJSONString(requestQueryFieldTimeDTO));
        return fieldService.getFieldTime(requestQueryFieldTimeDTO);
    }
}