package com.study.toy_springboots.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.toy_springboots.Dao.LoginDao;

@Service
public class LoginService {
    @Autowired
    LoginDao loginDao;
    public Object selectId(Object dataMap) {
        String sqlMapId = "Login.selectUserID";
        Object userData = loginDao.selectId(sqlMapId, dataMap);
        return userData;
    }

    public Object getLogin(Object dataMap) {
        String sqlMapId = "Login.getLogin";
        Object userData = loginDao.selectId(sqlMapId, dataMap);
        return userData;
    }

    public Object insertUserData(Object dataMap) {
        String sqlMapId = "Login.insertUserData";
        Object userData = loginDao.selectId(sqlMapId, dataMap);
        return userData;
    }
}
