package com.xk.upms.dao.repository;

import com.xk.upms.model.po.UpmsUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface UpmsUserRoleRepository extends JpaRepository<UpmsUserRole, Long>, Serializable {

    List findByRoleId(Long roleId);

    List findByUserId(Long userId);

}
