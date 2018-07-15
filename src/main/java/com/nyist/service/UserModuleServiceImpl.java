package com.nyist.service;

import com.nyist.pojo.Module;
import com.nyist.pojo.TUser;
import com.nyist.pojo.UserModule;
import com.nyist.pojo.UserModuleList;
import com.nyist.repository.TUserRepository;
import com.nyist.repository.UserModuleRepository;
import com.nyist.result.NyistResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2018/7/15/015.
 */
public class UserModuleServiceImpl implements  UserModuleService {
    @Autowired
    private UserModuleRepository userModuleRepository;
/*    @Autowired
    private TUserRepository tUserRepository;*/
    @Override
    public NyistResult moduleDistribution() {
        return null;
    }

    @Override
    public NyistResult giveModule(UserModuleList userModuleList) {
        List<UserModule> userModules=userModuleList.getUserModuleList();
        for(UserModule userModule:userModules){
            TUser user=userModule.gettUserByUid();
            Module module=userModule.getModuleByMid();
            user.setModuleByMid(module);  //更新数据
            userModuleRepository.save(userModule);
        }
        return NyistResult.ok();
    }

}
