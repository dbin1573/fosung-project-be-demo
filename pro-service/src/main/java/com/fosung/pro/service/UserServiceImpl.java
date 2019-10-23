package com.fosung.pro.service;


import com.fosung.framework.dao.support.service.jpa.AppJPABaseDataServiceImpl;
import com.fosung.pro.dao.UserDao;
import com.fosung.pro.entity.User;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends AppJPABaseDataServiceImpl<User, UserDao>
        implements IUserService {

    private Map<String, String> expressionMap = new LinkedHashMap<String, String>() {
        {
            put("name", "userName:LIKE");// EQ  GT LT

        }
    };

    @Override
    public Map<String, String> getQueryExpressions() {
        return expressionMap;
    }
}
