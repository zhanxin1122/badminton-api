package com.badminton.manage.dto.field;

public class PayDetailDTO {
    private int id;
    private String dayName;
    private String dayDate;
    private int hourPayAm;
    private int hourPayPm;
    private int hourPayNight;

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDayDate() {
        return dayDate;
    }

    public void setDayDate(String dayDate) {
        this.dayDate = dayDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHourPayAm() {
        return hourPayAm;
    }

    public void setHourPayAm(int hourPayAm) {
        this.hourPayAm = hourPayAm;
    }

    public int getHourPayPm() {
        return hourPayPm;
    }

    public void setHourPayPm(int hourPayPm) {
        this.hourPayPm = hourPayPm;
    }

    public int getHourPayNight() {
        return hourPayNight;
    }

    public void setHourPayNight(int hourPayNight) {
        this.hourPayNight = hourPayNight;
    }
}
