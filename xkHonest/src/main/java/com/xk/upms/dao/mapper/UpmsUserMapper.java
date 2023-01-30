package com.xk.upms.dao.mapper;

import com.xk.upms.model.dto.UpmsUserRoleExample;
import com.xk.upms.model.po.UpmsUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UpmsUserMapper {

    public List<UpmsUserRoleExample> selectAllwithRole();

}