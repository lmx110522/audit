package com.nyist.repository;

import com.nyist.pojo.Module;
import com.nyist.pojo.UserModule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/7/11/011.
 */
public interface UserModuleRepository extends JpaRepository<UserModule,String>{
    List<UserModule> findUserModulesByModuleByMidAndIsOk(Module module,Integer isOk);
}
