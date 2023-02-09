package com.study.toy_springboots.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.toy_springboots.Dao.MemberDao;
import com.study.toy_springboots.Utils.Paginations;

@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;
    public Object getMemberData(Object dataMap) {
        String sqlMapId = "memberList.memberData";
        Object userData = memberDao.getMembersData(sqlMapId, dataMap);
        return userData;
    }

    public Object getTotalCount(Object dataMap) {
        String sqlMapId = "memberList.totalCount";
        Object userData = memberDao.getOneMembersData(sqlMapId, dataMap);
        return userData;
    }

    public Object getOneMemberData(Object dataMap) {
        String sqlMapId = "memberList.memberDataOne";
        Object userData = memberDao.getOneMembersData(sqlMapId, dataMap);
        return userData;
    }

    public Object delete(Object dataMap) {
        String sqlMapId = "memberList.deleteMember";
        Object userData = memberDao.delete(sqlMapId, dataMap);
        return userData;
    }

    public Object update(Object dataMap) {
        String sqlMapId = "memberList.updateMember";
        Object userData = memberDao.update(sqlMapId, dataMap);
        return userData;
    }

    public Object save(Object dataMap) {
        String sqlMapId = "memberList.createMember";
        
        Object userData = memberDao.save(sqlMapId, dataMap);
        return userData;
    }

    public Object insertMultiAndGetList(Object dataMap) {
        String sqlMapId = "FileUpload.insertMulti";
        Object result = memberDao.save(sqlMapId, dataMap);
        result = this.save(dataMap);
        result = this.getMemberData(dataMap);
        return result;
    }

    public Object deleteAndGetList(Object dataMap) {
        Object result = this.delete(dataMap);
        result = this.getMemberData(dataMap);
        return result;
    }

    public Object updateAndGetList(Object dataMap) {
        Object result = this.update(dataMap);
        result = this.getMemberData(dataMap);
        return result;
    }

    public Object saveAndGetList(Object dataMap) {
        Object result = this.save(dataMap);
        result = this.getMemberData(dataMap);
        return result;
    }

    public Object getMemberDataAndTotalCount(Object dataMap) {
        Map<String,Object> result = new HashMap<String,Object>();
        int totalCount = (int) this.getTotalCount(dataMap);
        // int currentPage = (int)(((Map<String, Object>) dataMap).get("currentPage"));
        int currentPage = (int) ((Map<String, Object>) dataMap).get("currentPage");
        Paginations paginations = new Paginations(totalCount, currentPage);
        result.put("paginations",paginations);
        ((Map<String, Object>) dataMap).put("pageBegin",paginations.getPageBegin()-1);
        ((Map<String, Object>) dataMap).put("pageScale",paginations.getPageScale());
        Object userData = this.getMemberData(dataMap);
        result.put("userData", userData);
        return result;
    }
}
