package com.czl.privileges.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:28
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "interfaces")
public class Interfaces {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 接口id
     */
    @TableField(value = "interface_id")
    private Long interfaceId;

    /**
     * 接口名字
     */
    @TableField(value = "interface_name")
    private String interfaceName;

    /**
     * 接口路径
     */
    @TableField(value = "interface_path")
    private String interfacePath;

}