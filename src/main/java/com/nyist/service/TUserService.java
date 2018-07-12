package com.nyist.service;

import com.nyist.result.NyistResult;

/**
 * Created by Administrator on 2018/7/12/012.
 */
public interface TUserService {
        NyistResult login(String username,String password);
}
