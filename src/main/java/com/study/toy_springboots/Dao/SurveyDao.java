package com.study.toy_springboots.Dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class SurveyDao {
    @Autowired
    private SqlSessionTemplate sessionTemplate;
    
    public Object getSurvey(String sqlMapId, Object dataMap) {
        Object survey = sessionTemplate.selectList(sqlMapId, dataMap);
        return survey;
    }

    public Object getQuestion(String sqlMapId, Object dataMap) {
        Object userData = sessionTemplate.selectList(sqlMapId, dataMap);
        return userData;
    }

    public Object getAnswer(String sqlMapId, Object dataMap) {
        Object userData = sessionTemplate.insert(sqlMapId, dataMap);
        return userData;
    }
}
