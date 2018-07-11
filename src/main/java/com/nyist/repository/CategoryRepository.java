package com.nyist.repository;

import com.nyist.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/7/11/011.
 */
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
