package com.nyist.repository;

import com.nyist.pojo.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/7/11/011.
 */
public interface AuthorityRepository extends JpaRepository<Authority,String> {
}
