package com.nyist.repository;

import com.nyist.pojo.Document;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/7/11/011.
 */
public interface DocumentRepository extends JpaRepository<Document,String> {
}
