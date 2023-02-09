package com.study.toy_springboots.Dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class LoginDao {
    @Autowired
    private SqlSessionTemplate sessionTemplate;
    
    public Object selectId(String sqlMapId, Object dataMap) {
        Object userData = sessionTemplate.selectList(sqlMapId, dataMap);
        return userData;
    }

    public Object getLogin(String sqlMapId, Object dataMap) {
        Object userData = sessionTemplate.selectList(sqlMapId, dataMap);
        return userData;
    }

    public Object insertUserData(String sqlMapId, Object dataMap) {
        Object userData = sessionTemplate.insert(sqlMapId, dataMap);
        return userData;
    }
}
