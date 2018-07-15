package com.nyist.service;

import com.nyist.pojo.TUser;
import com.nyist.result.NyistResult;

/**
 * Created by Administrator on 2018/7/15/015.
 */
public interface RoleAuthorityService {
    NyistResult setUserPower(TUser tUser);
}
