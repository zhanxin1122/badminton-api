package com.badminton.manage.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.badminton.manage.bean.config.Config;
import com.badminton.manage.bean.wx.ResponseToken;
import com.badminton.manage.common.HttpURLConnectionUtil;
import com.badminton.manage.common.RandomUtil;
import com.badminton.manage.common.SHA1;
import com.badminton.manage.common.Util;
import com.badminton.manage.dto.common.CommonResponseDTO;
import com.badminton.manage.dto.wx.RequestWxTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class WxService {

    @Autowired
    private ConfigService configService;
    public String verifyWxToken(RequestWxTokenDTO requestWxTokenDTO) {
        if (Util.checkSignature(requestWxTokenDTO)) {
            return requestWxTokenDTO.getEchostr();
        } else {
            return "token校验不通过";
        }
    }

    public CommonResponseDTO getWxUserInfo(String code) {
        // 获取用户信息
        Map authResMap = HttpURLConnectionUtil.doGet("https://api.weixin.qq.com/sns/oauth2/access_token?appid="+Util.APP_ID+"&secret="+Util.APP_SECRET+"&code="+code+"&grant_type=authorization_code");
        String openId = authResMap.get("openid").toString();
        System.out.println("openId=" + openId);
        String authAccessToken = authResMap.get("access_token").toString();
        Map userInfoMap = HttpURLConnectionUtil.doGet("https://api.weixin.qq.com/sns/userinfo?access_token="+authAccessToken+"&openid="+openId+"&lang=zh_CN");
        HashMap data = new HashMap<String, String>();
        data.put("nickname", userInfoMap.get("nickname"));
        data.put("sex", userInfoMap.get("sex"));
        data.put("headimgurl", userInfoMap.get("headimgurl"));
        return Util.getCommonResponseDTO(data);
    }

    public CommonResponseDTO getWxSignature(String url) {

        // 获取access_token
        String accessToken = configService.getValue("accessToken");
        if(accessToken == null || accessToken.equals("")) {
            System.out.println("accessToken不存在");
            Map accessTokenResMap = HttpURLConnectionUtil.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + Util.APP_ID + "&secret=" + Util.APP_SECRET);
            accessToken = accessTokenResMap.get("access_token").toString();
            configService.setValue(new Config("accessToken", accessToken));
        }
        System.out.println("accessToken=" + accessToken);

        // 获取jsapi_ticket
        String jsapiTicket = configService.getValue("jsapiTicket");
        if(jsapiTicket == null || jsapiTicket.equals("")) {
            System.out.println("jsapiTicket不存在");
            Map jsapiTicketResMap = HttpURLConnectionUtil.doGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken + "&type=jsapi");
            jsapiTicket = jsapiTicketResMap.get("ticket").toString();
            configService.setValue(new Config("jsapiTicket", jsapiTicket));
        }
        System.out.println("jsapiTicket=" + jsapiTicket);

        // 生成签名
        String nonceStr = RandomUtil.generateString(16);
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        String signature = SHA1.encode(
                "jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url
        );
        System.out.println("timestamp=" + timestamp );
        System.out.println("signature=" + signature);

        HashMap data = new HashMap<String, String>();
        data.put("appId", Util.APP_ID);
        data.put("timestamp", timestamp);
        data.put("nonceStr", nonceStr);
        data.put("signature", signature);
        return Util.getCommonResponseDTO(data);
    }
}
