package com.xk.upms.model.vo;

import com.xk.upms.model.dto.UpmsUserRoleExample;
import com.xk.upms.model.po.UpmsRole;
import com.xk.upms.model.po.UpmsUser;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * UpmsUser Resp for Page: Index
 * Created by yuan on 2022/11/30
 */
@Getter
@Setter
public class UpmsUserDetailResp extends UpmsUser {

    private List<UpmsRole> roleList;

}
