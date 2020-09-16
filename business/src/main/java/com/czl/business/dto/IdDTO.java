package com.czl.business.dto;

import lombok.*;

import java.util.List;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 11:25
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class IdDTO {

    /**
     * 雪花id
     */
    private Long SnowFlakeId;

    /**
     * 数据库法
     */
    private List<Long> DbId;
}
