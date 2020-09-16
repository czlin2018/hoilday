package com.czl.base.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 15:37
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@TableName ( value = "id_generator" )
public class IdGenerator {

    /**
     * id
     */
    @TableField ( value = "area_name" )
    private Integer id;

    /**
     * 当前最大id
     */
    @TableField ( value = "max_id" )
    private Long maxId;

    /**
     * 号段的布长
     */
    @TableField ( value = "step" )
    private Integer step;

    /**
     * 业务类型
     */
    @TableField ( value = "table_name" )
    private String table_name;

    /**
     * 版本号
     */
    @TableField ( value = "version" )
    private Integer version;

}
