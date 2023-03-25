package com.badminton.manage.bean.order;

public class OrderStatistics {
    private double weekStatistics;
    private double monthStatistics;
    private double yearStatistics;

    public OrderStatistics(double weekStatistics, double monthStatistics, double yearStatistics) {
        this.weekStatistics = weekStatistics;
        this.monthStatistics = monthStatistics;
        this.yearStatistics = yearStatistics;
    }

    public double getWeekStatistics() {
        return weekStatistics;
    }

    public void setWeekStatistics(double weekStatistics) {
        this.weekStatistics = weekStatistics;
    }

    public double getMonthStatistics() {
        return monthStatistics;
    }

    public void setMonthStatistics(double monthStatistics) {
        this.monthStatistics = monthStatistics;
    }

    public double getYearStatistics() {
        return yearStatistics;
    }

    public void setYearStatistics(double yearStatistics) {
        this.yearStatistics = yearStatistics;
    }
}
