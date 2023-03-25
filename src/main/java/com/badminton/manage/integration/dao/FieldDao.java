package com.badminton.manage.integration.dao;

import com.badminton.manage.bean.field.Field;
import com.badminton.manage.dto.field.PayDetailDTO;
import com.badminton.manage.dto.field.RequestQueryFieldDTO;
import com.badminton.manage.dto.field.RequestQueryFieldTimeItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FieldDao {
    public List<Field> queryField(RequestQueryFieldDTO requestQueryFieldDTO);
    public int countField(RequestQueryFieldDTO requestQueryFieldDTO);
    public void addField(Field field);
    public void deleteField(Field field);
    public void updateField(Field field);
    public List<PayDetailDTO> payList();
    public void payUpdate(PayDetailDTO payDetailDTO);
    public List<String> getFieldTime(RequestQueryFieldTimeItemDTO requestQueryFieldTimeItemDTO);
}