package com.czl.business.api.id;

import com.czl.base.idprodect.SnowFlakeId;
import com.czl.base.response.ApiResponse;
import com.czl.business.dto.IdDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 11:23
 */
@Validated
@RestController
public class IdController {


    @GetMapping ( "id/getId" )
    public ApiResponse getId () {
        IdDTO idDTO = IdDTO.builder()
                .SnowFlakeId(SnowFlakeId.generateId())
                .build();
        return ApiResponse.respond(idDTO);
    }
}
