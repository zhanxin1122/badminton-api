package com.badminton.manage.controller;

import com.badminton.manage.bean.wx.ResponseToken;
import com.badminton.manage.dto.common.CommonResponseDTO;
import com.badminton.manage.dto.wx.RequestWxTokenDTO;
import com.badminton.manage.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WxController {
    @Autowired
    private WxService wxService;

    @GetMapping("/verify_wx_token")
    public String verifyWxToken(RequestWxTokenDTO requestWxTokenDTO) {
        return wxService.verifyWxToken(requestWxTokenDTO);
    }

    @GetMapping("/getWxUserInfo")
    public CommonResponseDTO getWxUserInfo(String code) {
        return wxService.getWxUserInfo(code);
    }

    @GetMapping("/getWxSignature")
    public CommonResponseDTO getWxSignature(String url) {
        return wxService.getWxSignature(url);
    }
}
