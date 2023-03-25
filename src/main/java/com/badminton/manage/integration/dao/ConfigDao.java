package com.badminton.manage.integration.dao;

import com.badminton.manage.bean.config.Config;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConfigDao {
    public String getValue(String key);
    public void setValue(Config config);
}
