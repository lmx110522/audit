package com.nyist.service;

import com.nyist.pojo.CheckResult;
import com.nyist.pojo.TUser;
import com.nyist.pojo.TUser4;
import com.nyist.repository.TUserRepository;
import com.nyist.result.NyistResult;
import com.nyist.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/12/012.
 */

@Service
@Transactional
@PropertySource(value="classpath:redis.properties")
public class TUserServiceImpl implements TUserService {

    @Autowired
    private TUserRepository tUserRepository;
    @Autowired
    private JedisCluster jedisCluster;

    @Value("${REDIS_USER_SESSION_KEY}")
    private String REDIS_USER_SESSION_KEY;

    @Value("${SSO_SESSION_EXPIRE}")
    private Integer SSO_SESSION_EXPIRE;
    @Override
    public NyistResult login(String username, String password) {
        boolean result=false;
        TUser tUser=tUserRepository.findTUserByUsernameAndPassword(username,password);
        if(tUser==null)
            return NyistResult.build(400,"用户不存在");
        if(!DigestUtils.md5DigestAsHex(password.getBytes()).equals(tUser.getPassword())){
            return NyistResult.build(400,"密码错误");
        }
        //登录成功，把用户信息写入redis
        //生成一个用户token
        String token = UUID.randomUUID().toString();
        jedisCluster.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(tUser));
        //设置session过期时间
        jedisCluster.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
        return NyistResult.ok(token);
    }

    @Override
    public NyistResult addTUser4(TUser4 tUser4) {    //添加用户,权限请通过前台直接进行pojo绑定
        TUser tUser=tUser4.getUser();
        String parentId=tUser4.getParentId();
        if(parentId!=null) {
            TUser parent = tUserRepository.getOne(parentId);
            tUser.setTuserByParentId(parent);
            tUser.setGrouping(parent.getGrouping());
        }
        tUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tUser.setIsOk(1);
        tUserRepository.save(tUser);
        return NyistResult.ok();
    }
    //修改密码
    @Override
    public NyistResult updatePasswrod(TUser4 tUser4) {
        TUser tUser=tUser4.getUser();
        String uuidPass= DigestUtils.md5DigestAsHex(tUser.getPassword().getBytes());
        tUser.setPassword(uuidPass);
    //    tUserRepository.updateTUserPassword(uuidPass,tUser.getId());
        return NyistResult.ok();
    }

    @Override
    public NyistResult findAll() {
        List<TUser> tUsers=tUserRepository.findAll();
        return NyistResult.ok(tUsers);
    }

    @Override
    public NyistResult findAuditor(Integer grouping){
        List<TUser> Auditors=tUserRepository.findAuditor(grouping);     //按文理组查找审核人
        return NyistResult.ok(Auditors);
    }

    @Override
    public NyistResult checkLaboratory() {
        List<TUser> parents=tUserRepository.findTUsersByRole(2);    //查找全部系院
        List<CheckResult> result=new ArrayList<CheckResult>();
        for (TUser parent:parents){
            CheckResult checkResult=new CheckResult();
            Long allcount=tUserRepository.countByTuserByParentId(parent);
            Long getcount=tUserRepository.countByTuserByParentIdAndIsOk(parent,4);   //查找全部上传过文件的教研室
            checkResult.settUser(parent);
            checkResult.setAllLaboratoryCount(allcount);
            checkResult.setGetLaboratoryCount(getcount);
            result.add(checkResult);
        }
        //将对应的pojo返回
        return NyistResult.ok(result);
    }
    @Override
    public NyistResult getUser(String id){
        TUser tUser=tUserRepository.findTUserById(id);
        return NyistResult.ok(tUser);
    }
    @Override
    public void logout(String token) {
        jedisCluster.del(REDIS_USER_SESSION_KEY + ":" + token);
    }
    @Override
    public NyistResult laboratoryList(String parentId){
        TUser parent =tUserRepository.findTUserById(parentId);
        List<TUser> result=tUserRepository.findTUserByTuserByParentId(parent);
        return NyistResult.ok(result);
    }
}
