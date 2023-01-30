package com.xk.common.base;

import com.xk.upms.model.po.UpmsSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface BaseRepostitory extends JpaRepository<UpmsSystem, Long>, Serializable {

    @Query(value = "SELECT SUBSTR(a.COLUMN_COMMENT, 4)\n" +
            "FROM  information_schema.COLUMNS a \n" +
            "WHERE 1=1 \n" +
            "AND a.TABLE_SCHEMA = 'truck' \n" +
            "AND a.TABLE_NAME = :tableName \n" +
            "ORDER BY SUBSTR(a.COLUMN_COMMENT, 1, 2)", nativeQuery = true)
    List<Object> queryTableComent(String tableName);

}
