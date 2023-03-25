package com.badminton.manage.dto.order;

import java.util.List;

public class RequestAddOrderDTO {
    private int userId;
    private String name;
    private String phone;
    private String remark;
    private int placeId;
    private List<Integer> fieldIdList;
    private List<String> payList;
    private List<String> timeList;
    private String createDate;
    private String useDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public List<Integer> getFieldIdList() {
        return fieldIdList;
    }

    public void setFieldIdList(List<Integer> fieldIdList) {
        this.fieldIdList = fieldIdList;
    }

    public List<String> getPayList() {
        return payList;
    }

    public void setPayList(List<String> payList) {
        this.payList = payList;
    }

    public List<String> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<String> timeList) {
        this.timeList = timeList;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }
}
