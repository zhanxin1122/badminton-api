package com.badminton.manage.service;
import com.badminton.manage.bean.order.InvestRecord;
import com.badminton.manage.bean.order.Order;
import com.badminton.manage.bean.order.OrderStatistics;
import com.badminton.manage.bean.common.PageInfo;
import com.badminton.manage.bean.user.User;
import com.badminton.manage.common.GlobalStatic;
import com.badminton.manage.dto.common.CommonQueryResponseDTO;
import com.badminton.manage.dto.common.CommonResponseDTO;
import com.badminton.manage.dto.order.*;
import com.badminton.manage.common.Util;
import com.badminton.manage.dto.user.RequestQueryUserDTO;
import com.badminton.manage.integration.dao.OrderDao;
import com.badminton.manage.integration.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    public CommonQueryResponseDTO queryOrder(RequestQueryOrderDTO requestQueryOrderDTO) {
        PageInfo pageInfo = requestQueryOrderDTO.getPageInfo();
        int pageNo = pageInfo.getPageNo();
        int pageSize = pageInfo.getPageSize();
        int firstIndex = (pageNo - 1) * pageSize;
        requestQueryOrderDTO.setFirstIndex(firstIndex);
        requestQueryOrderDTO.setPageSize(pageSize);
        List<Order> orderList = orderDao.queryOrder(requestQueryOrderDTO);
        int totalCount = orderDao.countOrder(requestQueryOrderDTO);
        double totalPage = Math.ceil((double) totalCount / (double) pageSize);
        System.out.println(totalCount);
        System.out.println(totalPage);
        CommonQueryResponseDTO commonQueryResponseDTO = Util.getCommonQueryResponseDTO(orderList, totalCount, (int)totalPage);
        return commonQueryResponseDTO;
    }
    public CommonResponseDTO addOrder(RequestAddOrderDTO requestAddOrderDTO) {
        List<Integer> fieldList = requestAddOrderDTO.getFieldIdList();
        List<String> payList = requestAddOrderDTO.getPayList();
        List<String> timeList = requestAddOrderDTO.getTimeList();
        for(int i = 0; i < fieldList.size(); i++) {
            if(timeList.get(i) != "") {
                String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
                Order order = new Order(0, requestAddOrderDTO.getUserId(),requestAddOrderDTO.getPlaceId(), fieldList.get(i), timeList.get(i),payList.get(i),  requestAddOrderDTO.getRemark(),requestAddOrderDTO.getName(), requestAddOrderDTO.getPhone(), createDate, requestAddOrderDTO.getUseDate());
                orderDao.addOrder(order);
            }
        }
        return Util.getCommonResponseDTO(null);
    }

    public ResponseStatisticsInvestRecordDTO statisticsInvestRecord() {
        long nowTimestamp = System.currentTimeMillis();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = simpleDateFormat.format(nowTimestamp);
        Calendar calendar = Calendar.getInstance();
        // 过去一周
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -7);
        String beforeWeekDate = simpleDateFormat.format(calendar.getTime());
        // 过去一个月
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        String beforeMonthDate = simpleDateFormat.format(calendar.getTime());
        // 过去一年
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -1);
        String beforeYearDate = simpleDateFormat.format(calendar.getTime());
        double weekStatistics = orderDao.statisticsInvestRecord(new QueryStatisticsInvestRecordMapper(beforeWeekDate, nowDate));
        double monthStatistics = orderDao.statisticsInvestRecord(new QueryStatisticsInvestRecordMapper(beforeMonthDate, nowDate));
        double yearStatistics = orderDao.statisticsInvestRecord(new QueryStatisticsInvestRecordMapper(beforeYearDate, nowDate));
        OrderStatistics orderStatistics = new OrderStatistics(weekStatistics, monthStatistics, yearStatistics);
        ResponseStatisticsInvestRecordDTO responseStatisticsInvestRecordDTO = new ResponseStatisticsInvestRecordDTO(GlobalStatic.RESPONSE_CODE_SUCCESS, GlobalStatic.RESPONSE_SUCCESS_MSG, orderStatistics);
        return responseStatisticsInvestRecordDTO;
    }

    public CommonQueryResponseDTO queryInvestRecord(RequestQueryRecordDTO requestQueryRecordDTO) {
        PageInfo pageInfo = requestQueryRecordDTO.getPageInfo();
        int pageNo = pageInfo.getPageNo();
        int pageSize = pageInfo.getPageSize();
        int firstIndex = (pageNo - 1) * pageSize;
        requestQueryRecordDTO.setFirstIndex(firstIndex);
        requestQueryRecordDTO.setPageSize(pageSize);
        List<InvestRecord> orderList = orderDao.queryInvestRecord(requestQueryRecordDTO);
        int totalCount = orderDao.countInvestRecord(requestQueryRecordDTO);
        double totalPage = Math.ceil((double) totalCount / (double) pageSize);
        System.out.println("分页信息=====");
        System.out.println(totalCount);
        System.out.println(totalPage);
        CommonQueryResponseDTO commonQueryResponseDTO = Util.getCommonQueryResponseDTO(orderList, totalCount, (int)totalPage);
        return commonQueryResponseDTO;
    }

    public CommonResponseDTO addInvestRecord(InvestRecord investRecord) {
        investRecord.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
        orderDao.addInvestRecord(investRecord);

        // 更新用户余额
        RequestQueryUserDTO requestQueryUserDTO = new RequestQueryUserDTO(10, 0, investRecord.getUserId(), "");
        User user = userDao.queryUser(requestQueryUserDTO).get(0);
        double newBalance = user.getBalance() + investRecord.getMoney();
        user.setBalance(newBalance);
        userDao.updateUser(user);
        return Util.getCommonResponseDTO(null);
    }
}