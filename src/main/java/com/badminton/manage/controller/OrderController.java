package com.badminton.manage.controller;

import com.alibaba.fastjson.JSON;
import com.badminton.manage.bean.order.InvestRecord;
import com.badminton.manage.dto.common.CommonQueryResponseDTO;
import com.badminton.manage.dto.common.CommonResponseDTO;
import com.badminton.manage.dto.order.RequestAddOrderDTO;
import com.badminton.manage.dto.order.RequestQueryOrderDTO;
import com.badminton.manage.dto.order.RequestQueryRecordDTO;
import com.badminton.manage.dto.order.ResponseStatisticsInvestRecordDTO;
import com.badminton.manage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/list")
    public CommonQueryResponseDTO list(@RequestBody RequestQueryOrderDTO requestQueryOrderDTO) {
        System.out.println("queryOrderDTO=====" + JSON.toJSONString(requestQueryOrderDTO));
        return orderService.queryOrder(requestQueryOrderDTO);
    }

    @PostMapping("/add")
    public CommonResponseDTO add(@RequestBody RequestAddOrderDTO requestAddOrderDTO) {
        System.out.println("addOrderDTO=====" + JSON.toJSONString(requestAddOrderDTO));
        return orderService.addOrder(requestAddOrderDTO);
    }

    @PostMapping("/investRecord/statistics")
    public ResponseStatisticsInvestRecordDTO statisticsInvestRecord() {
        return orderService.statisticsInvestRecord();
    }

    @PostMapping("/investRecord/list")
    public CommonQueryResponseDTO queryInvestRecord(@RequestBody RequestQueryRecordDTO requestQueryRecordDTO) {
        System.out.println("queryInvestRecord=====" + JSON.toJSONString(requestQueryRecordDTO));
        return orderService.queryInvestRecord(requestQueryRecordDTO);
    }

    @PostMapping("/investRecord/add")
    public CommonResponseDTO addInvestRecord(@RequestBody InvestRecord investRecord) {
        System.out.println("addInvestRecordDTO=====" + JSON.toJSONString(investRecord));
        return orderService.addInvestRecord(investRecord);
    }

//    @PostMapping("/delete")
//    public CommonResponseDTO delete(@RequestBody User user) {
//        System.out.println("deleteUserDTO=====" + JSON.toJSONString(user));
//        return userService.deleteUser(user);
//    }
//
//    @PostMapping("/update")
//    public CommonResponseDTO update(@RequestBody User user) {
//        System.out.println("updateUserDTO=====" + JSON.toJSONString(user));
//        return userService.updateUser(user);
//    }
}