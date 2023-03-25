package com.badminton.manage.bean.order;

public class Order {
    private int orderId;
    private int userId;
    private int placeId;
    private int fieldId;
    private String time;
    private String pay;
    private String remark;
    private String name;
    private String phone;
    private String createDate;
    private String useDate;

    public Order(int orderId, int userId,int placeId, int fieldId,String time,String pay, String remark, String name, String phone, String createDate, String useDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.placeId = placeId;
        this.fieldId = fieldId;
        this.time = time;
        this.pay = pay;
        this.remark = remark;
        this.name = name;
        this.phone = phone;
        this.createDate = createDate;
        this.useDate = useDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

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

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
