package com.nyist.repository;

import com.nyist.pojo.TUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/7/11/011.
 */
public interface TUserRepository extends JpaRepository<TUser,String> {
}
