package com.nyist.service;

import com.nyist.pojo.Module;
import com.nyist.pojo.TUser;
import com.nyist.pojo.UserList;
import com.nyist.pojo.UserModule;
import com.nyist.repository.ModuleRepository;
import com.nyist.repository.UserModuleRepository;
import com.nyist.result.NyistResult;
import com.nyist.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2018/7/15/015.
 */
@Service
@Transactional
public class UserModuleServiceImpl implements  UserModuleService {
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private TUserService tUserService;
    @Autowired
    private UserModuleRepository userModuleRepository;
    @Override
    public NyistResult moduleDistribution() {
        return null;
    }

    @Override
    public NyistResult giveModule(UserList userList) {    //得到前台数据
       List<TUser> tUserList=userList.gettUsers();
        for(TUser tUser:tUserList){
            Module module=tUser.getModuleByMid();
            module=moduleRepository.findModuleById(module.getId());   //设置模块
            tUser.setModuleByMid(module);
        }
        return NyistResult.ok();
    }

    @Override
    public NyistResult waitCheck(HttpServletRequest request) {
        //从cookie中取出token
        String token= CookieUtils.getCookieValue(request,"TOKEN");
        TUser checker= (TUser) tUserService.getUserByToken(token).getData();
        List<UserModule> userModules=userModuleRepository.findUserModulesByModuleByMidAndIsOk(checker.getModuleByMid(),0);
        return NyistResult.ok(userModules);
    }

}
