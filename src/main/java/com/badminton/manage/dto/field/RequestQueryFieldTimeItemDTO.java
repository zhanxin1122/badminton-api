package com.badminton.manage.dto.field;

public class RequestQueryFieldTimeItemDTO {
    private String startDate;
    private String endDate;
    private int fieldId;

    public RequestQueryFieldTimeItemDTO(String startDate, String endDate, int fieldId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.fieldId = fieldId;
    }

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

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }
}
