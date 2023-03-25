package com.badminton.manage.dto.user;

import com.badminton.manage.bean.common.PageInfo;

public class RequestQueryUserDTO {
    private String phone;
    private int pageSize;
    private int firstIndex;
    private PageInfo pageInfo;
    private int userId;

    public RequestQueryUserDTO(int pageSize, int firstIndex, int userId, String phone) {
        this.pageSize = pageSize;
        this.firstIndex = firstIndex;
        this.userId = userId;
        this.phone = phone;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}