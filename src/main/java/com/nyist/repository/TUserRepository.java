package com.nyist.repository;

import com.nyist.pojo.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/7/11/011.
 */
@Service
@Transactional
public interface TUserRepository extends JpaRepository<TUser,String> {

    TUser findTUserByUsernameAndPassword(String username,String password);
    @Modifying
    @Query(value = "UPDATE t_user t set t.password=?1 where t.id=?2",nativeQuery=true)
    void updateTUserPassword(String password,String id);
    @Query(value = "select count(*) from t_user where parent_id=?1",nativeQuery=true)
    Integer getChildCount(String parentId);
    @Query(value = "select * from t_user where role=3 and grouping=?1",nativeQuery = true)
    List<TUser> findAuditor(Integer grouping);
    List<TUser> findTUsersByRole(Integer role);
    Long countByTuserByParentIdAndIsOk(TUser tUser,Integer isOk);
    Long countByTuserByParentId(TUser tUser);
    TUser findTUserById(String id);
    List<TUser> findTUserByTuserByParentId(TUser tUser);
}
