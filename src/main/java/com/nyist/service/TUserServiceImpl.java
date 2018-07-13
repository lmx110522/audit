package com.nyist.service;

import com.nyist.pojo.TUser;
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
    public void logout(String token) {
        jedisCluster.del(REDIS_USER_SESSION_KEY + ":" + token);
    }
}
