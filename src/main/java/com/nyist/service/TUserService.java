package com.nyist.service;

import com.nyist.pojo.TUser;
import com.nyist.pojo.TUser4;
import com.nyist.result.NyistResult;

/**
 * Created by Administrator on 2018/7/12/012.
 */
public interface TUserService {
        NyistResult login(String username,String password);
        NyistResult addTUser4(TUser4 tUser4);
        NyistResult updatePasswrod(TUser4 tUser4);
        NyistResult findAll();    //账号管理
        NyistResult findAuditor(Integer grouping) ;
        NyistResult checkLaboratory();   //教研室查看
        NyistResult getUser(String id);
        void logout(String token);
        public NyistResult laboratoryList(String parentId);
}
