package com.badminton.manage.service;

import com.badminton.manage.bean.config.Config;
import com.badminton.manage.integration.dao.ConfigDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {
    @Autowired
    private ConfigDao configDao;

    public String getValue(String key) {
        return configDao.getValue(key);
    }

    public void setValue(Config config) {
        configDao.setValue(config);
    }

}
