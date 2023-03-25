package com.badminton.manage.integration.dao;

import com.badminton.manage.bean.user.LoginUser;
import com.badminton.manage.bean.user.User;
import com.badminton.manage.dto.user.RequestQueryUserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public List<User> queryUser(RequestQueryUserDTO requestQueryUserDTO);
    public int countUser(RequestQueryUserDTO requestQueryUserDTO);
    public void addUser(User user);
    public void deleteUser(User user);
    public void updateUser(User user);
    public List<LoginUser> queryPassword(LoginUser loginUser);
}