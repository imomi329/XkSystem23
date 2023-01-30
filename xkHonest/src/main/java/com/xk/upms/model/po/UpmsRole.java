package com.xk.upms.model.po;

import com.xk.common.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by yuan on 2022/06/10
 */
@Entity
@Getter
@Setter
@Table(name = "upms_role")
public class UpmsRole extends BaseEntity implements Serializable {
    /**
     * 流水號
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "faceset_generator", strategy = "guid")
    @Column(name = "role_id")
    @NotNull(groups = Update.class)
    private Long id;
    /**
     * 角色名稱
     */
    private String name;
    /**
     * 角色標題
     */
    private String title;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 排序
     */
    private Long orders;

}