package com.xk.upms.dao.repository;

import com.xk.upms.model.po.UpmsSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface UpmsSystemRepository extends JpaRepository<UpmsSystem, Long>, Serializable {
}
