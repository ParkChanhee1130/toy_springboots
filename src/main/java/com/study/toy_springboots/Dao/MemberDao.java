package com.study.toy_springboots.Dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class MemberDao {
    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public Object getMembersData(String sqlMapId, Object dataMap) {
        Object membersData= sessionTemplate.selectList(sqlMapId, dataMap);
        return membersData;
    }

    public Object getOneMembersData(String sqlMapId, Object dataMap) {
        Object membersData= sessionTemplate.selectOne(sqlMapId, dataMap);
        return membersData;
    }

    public Object delete(String sqlMapId, Object dataMap) {
        Object membersData= sessionTemplate.delete(sqlMapId, dataMap);
        return membersData;
    }

    public Object update(String sqlMapId, Object dataMap) {
        Object membersData= sessionTemplate.update(sqlMapId, dataMap);
        return membersData;
    }

    public Object save(String sqlMapId, Object dataMap) {
        Object membersData= sessionTemplate.insert(sqlMapId, dataMap);
        return membersData;
    }

}