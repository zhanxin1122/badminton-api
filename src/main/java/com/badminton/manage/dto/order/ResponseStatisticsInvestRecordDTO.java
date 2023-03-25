package com.badminton.manage.dto.order;

import com.badminton.manage.bean.order.OrderStatistics;
import com.badminton.manage.dto.common.BaseResponseResultDTO;

public class ResponseStatisticsInvestRecordDTO extends BaseResponseResultDTO {
    private OrderStatistics data;

    public ResponseStatisticsInvestRecordDTO(String code, String msg, OrderStatistics data) {
        super(code, msg);
        this.data = data;
    }

    public OrderStatistics getData() {
        return data;
    }

    public void setData(OrderStatistics data) {
        this.data = data;
    }
}
