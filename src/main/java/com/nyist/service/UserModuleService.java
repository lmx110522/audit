package com.nyist.service;

import com.nyist.pojo.UserModuleList;
import com.nyist.result.NyistResult;

/**
 * Created by Administrator on 2018/7/15/015.
 */
public interface UserModuleService {
    NyistResult moduleDistribution();
    NyistResult giveModule(UserModuleList userModuleList);      //分配模块

}
