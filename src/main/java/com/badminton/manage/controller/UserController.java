package com.badminton.manage.controller;

import com.alibaba.fastjson.JSON;
import com.badminton.manage.bean.user.LoginUser;
import com.badminton.manage.bean.user.User;
import com.badminton.manage.dto.common.CommonQueryResponseDTO;
import com.badminton.manage.dto.common.CommonResponseDTO;
import com.badminton.manage.dto.user.RequestQueryUserDTO;
import com.badminton.manage.dto.user.ValidateBalanceDTO;
import com.badminton.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    public CommonQueryResponseDTO list(@RequestBody RequestQueryUserDTO requestQueryUserDTO) {
        System.out.println("queryUserDTO=====" + JSON.toJSONString(requestQueryUserDTO));
        return userService.queryUser(requestQueryUserDTO);
    }

    @PostMapping("/add")
    public CommonResponseDTO add(@RequestBody User user) {
        System.out.println("addUserDTO=====" + JSON.toJSONString(user));
        return userService.addUser(user);
    }

    @PostMapping("/delete")
    public CommonResponseDTO delete(@RequestBody User user) {
        System.out.println("deleteUserDTO=====" + JSON.toJSONString(user));
        return userService.deleteUser(user);
    }

    @PostMapping("/update")
    public CommonResponseDTO update(@RequestBody User user) {
        System.out.println("updateUserDTO=====" + JSON.toJSONString(user));
        return userService.updateUser(user);
    }

    @PostMapping("/login")
    public CommonResponseDTO login(@RequestBody LoginUser loginUser, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return userService.login(loginUser, httpServletRequest, httpServletResponse);
    }

    @PostMapping("/exit")
    public CommonResponseDTO exit(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return userService.exit(httpServletRequest, httpServletResponse);
    }

    @PostMapping("/update/balance")
    public CommonResponseDTO updateBalance(@RequestBody ValidateBalanceDTO validateBalanceDTO) {
        return userService.updateBalance(validateBalanceDTO);
    }

}