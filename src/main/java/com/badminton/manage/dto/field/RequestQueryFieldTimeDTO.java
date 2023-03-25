package com.badminton.manage.dto.field;

import java.util.List;

public class RequestQueryFieldTimeDTO {
    private String startDate;
    private String endDate;
    private List<Integer> fieldIdList;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Integer> getFieldIdList() {
        return fieldIdList;
    }

    public void setFieldIdList(List<Integer> fieldIdList) {
        this.fieldIdList = fieldIdList;
    }
}
