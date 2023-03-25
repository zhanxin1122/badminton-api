package com.badminton.manage.service;
import com.badminton.manage.bean.user.LoginUser;
import com.badminton.manage.bean.common.PageInfo;
import com.badminton.manage.bean.user.User;
import com.badminton.manage.common.GlobalStatic;
import com.badminton.manage.dto.common.CommonQueryResponseDTO;
import com.badminton.manage.dto.common.CommonResponseDTO;
import com.badminton.manage.dto.user.RequestQueryUserDTO;
import com.badminton.manage.dto.user.ValidateBalanceDTO;
import com.badminton.manage.integration.dao.UserDao;
import com.badminton.manage.common.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public CommonQueryResponseDTO queryUser(RequestQueryUserDTO requestQueryUserDTO) {
        PageInfo pageInfo = requestQueryUserDTO.getPageInfo();
        int pageNo = pageInfo.getPageNo();
        int pageSize = pageInfo.getPageSize();
        int firstIndex = (pageNo - 1) * pageSize;
        requestQueryUserDTO.setFirstIndex(firstIndex);
        requestQueryUserDTO.setPageSize(pageSize);
        List<User> placeList = userDao.queryUser(requestQueryUserDTO);
        int totalCount = userDao.countUser(requestQueryUserDTO);
        double totalPage = Math.ceil((double) totalCount / (double) pageSize);
        System.out.println("分页信息=====");
        System.out.println(totalCount);
        System.out.println(totalPage);
        CommonQueryResponseDTO commonQueryResponseDTO = Util.getCommonQueryResponseDTO(placeList, totalCount, (int)totalPage);
        return commonQueryResponseDTO;
    }
    public CommonResponseDTO addUser(User user) {
        userDao.addUser(user);
        return Util.getCommonResponseDTO(null);
    }

    public CommonResponseDTO deleteUser(User user) {
        userDao.deleteUser(user);
        return Util.getCommonResponseDTO(null);
    }

    public CommonResponseDTO updateUser(User user) {
        userDao.updateUser(user);
        return Util.getCommonResponseDTO(null);
    }

    public CommonResponseDTO login(LoginUser loginUser, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        HttpSession session = httpServletRequest.getSession();
        System.out.println(session.getId());
        Cookie cookie = new Cookie(GlobalStatic.TOKEN_COOKIE_KEY, session.getId());
        cookie.setMaxAge(30 * 60); // 设置过期时间
        cookie.setPath(httpServletRequest.getContextPath());
        httpServletResponse.addCookie(cookie);
        // 校验密码
        List<LoginUser> resultUser = userDao.queryPassword(loginUser);
        if(resultUser.size() == 0) {
            return new CommonResponseDTO(GlobalStatic.RESPONSE_CODE_FAIL, "不存在该用户");
        } else {
            if(!resultUser.get(0).getPassword().equals(loginUser.getPassword())) {
                return new CommonResponseDTO(GlobalStatic.RESPONSE_CODE_FAIL, "密码错误");
            }
        }
        return Util.getCommonResponseDTO(null);
    }

    public CommonResponseDTO exit(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
        HttpSession session = httpServletRequest.getSession();
        System.out.println(session.getId());
        Cookie cookie = new Cookie(GlobalStatic.TOKEN_COOKIE_KEY, session.getId());
        cookie.setMaxAge(0); // 设置过期时间
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
        return Util.getCommonResponseDTO(null);
    }

    public CommonResponseDTO updateBalance(ValidateBalanceDTO validateBalanceDTO) {
        RequestQueryUserDTO requestQueryUserDTO = new RequestQueryUserDTO(99999, 0, validateBalanceDTO.getUserId(), "");
        List<User> userList = userDao.queryUser(requestQueryUserDTO);
        User user = userList.get(0);
        double inputBalance = validateBalanceDTO.getBalance();
        if(inputBalance > user.getBalance()) {
            return new CommonResponseDTO(GlobalStatic.RESPONSE_CODE_FAIL, "余额不足");
        }else {
            user.setBalance(user.getBalance() - inputBalance);
            userDao.updateUser(user);
            return Util.getCommonResponseDTO(null);
        }
    }
}