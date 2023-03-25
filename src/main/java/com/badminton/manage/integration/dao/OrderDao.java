package com.badminton.manage.integration.dao;

import com.badminton.manage.bean.order.InvestRecord;
import com.badminton.manage.bean.order.Order;
import com.badminton.manage.dto.order.QueryStatisticsInvestRecordMapper;
import com.badminton.manage.dto.order.RequestQueryOrderDTO;
import com.badminton.manage.dto.order.RequestQueryRecordDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    public List<Order> queryOrder(RequestQueryOrderDTO requestQueryOrderDTO);
    public int countOrder(RequestQueryOrderDTO requestQueryOrderDTO);
    public void addOrder(Order order);
    public double statisticsInvestRecord(QueryStatisticsInvestRecordMapper queryStatisticsInvestRecordMapper);
    public List<InvestRecord> queryInvestRecord(RequestQueryRecordDTO requestQueryRecordDTO);
    public int countInvestRecord(RequestQueryRecordDTO requestQueryRecordDTO);
    public void addInvestRecord(InvestRecord investRecord);

    //    public void deleteField(Field field);
//    public void updateField(Field field);
}