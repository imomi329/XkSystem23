package com.xk.upms.dao.repository;

import com.xk.upms.model.po.UpmsRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface UpmsRolePermissionRepository extends JpaRepository<UpmsRolePermission, Long>, Serializable {

    List findByRoleId(long roleId);

}
