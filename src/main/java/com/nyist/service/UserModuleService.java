package com.nyist.service;

import com.nyist.pojo.UserList;
import com.nyist.pojo.UserModule;
import com.nyist.result.NyistResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/7/15/015.
 */
public interface UserModuleService {
    NyistResult moduleDistribution();
    NyistResult  giveModule(UserList userList);      //分配模块
    NyistResult waitCheck(HttpServletRequest request);      //待我审核
    NyistResult checkList(HttpServletRequest request);    //审核记录列表
    NyistResult addUserModule(UserModule userModule);     //提交审核
}
