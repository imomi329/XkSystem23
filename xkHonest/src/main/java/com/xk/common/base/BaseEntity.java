package com.xk.common.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 通用字段， is_del 根据需求自行添加
 *
 * @author Zheng Jie
 * @Date 2019年10月24日20:46:32
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    @ApiModelProperty(value = "創建者", required = true, example = "王小明")
    @CreatedBy
    @Column(name = "create_by", updatable = false)
    @Comment("96_創建者")
    private String createBy;

    @ApiModelProperty(value = "編輯者", required = true, example = "王小明")
    @LastModifiedBy
    @Column(name = "update_by")
    @Comment("98_編輯者")
    private String updateBy;

    @ApiModelProperty(value = "創建時間", required = true, example = "王小明")
    @CreationTimestamp
    @Column(name = "create_time", updatable = false)
    @Temporal(TemporalType.DATE)
    @Comment("97_創建時間")
    private Date createTime;

    @ApiModelProperty(value = "編輯時間", required = true, example = "王小明")
    @UpdateTimestamp
    @Column(name = "update_time")
    @Temporal(TemporalType.DATE)
    @Comment("99_編輯時間")
    private Date updateTime;

    /* 分组校验 */
    public @interface Create {
    }

    /* 分组校验 */
    public @interface Update {
    }

}
