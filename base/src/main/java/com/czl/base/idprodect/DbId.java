package com.czl.base.idprodect;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.czl.base.entity.IdGenerator;
import com.czl.base.mapper.IdGeneratorMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 15:16
 */
//todo 尚未完成
@Log4j2
@Service ( value = "DbId" )
public class DbId {

    /**
     * 批次量
     */
    private static final int BATCH_SIZE = 100;

    /**
     * 重试次数
     */
    private static final int TRY_TIMES = 5;

    private IdGeneratorMapper idGeneratorMapper;

    public List<Long> generateSerialId (String tableName) {
        List<Long> idList = new ArrayList<>();
        for (int i = 0 ; i < BATCH_SIZE ; i++) {
            Long id = generateId(tableName);
            idList.add(id);
        }
        return idList;
    }

    public Long generateId (String tableName) {
        //可能失败，需要重试
        for (int i = 0 ; i < TRY_TIMES ; i++) {
            QueryWrapper<IdGenerator> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(IdGenerator :: getTable_name, tableName);
            IdGenerator idGenerator = idGeneratorMapper.selectOne(queryWrapper);
            if (idGenerator == null) {
                try {
                    idGenerator = IdGenerator.builder().table_name(tableName).maxId(1L).step(2).version(0).build();
                    idGeneratorMapper.insert(idGenerator);
                    return idGenerator.getMaxId();
                }catch (Exception e) {
                    log.error("失败了");
                }
            } else {
                try {
                    Long oldMax = idGenerator.getMaxId();
                    Long newMax = oldMax + idGenerator.getStep();
                    LambdaUpdateWrapper<IdGenerator> updateWrapper = new LambdaUpdateWrapper<>();
                    updateWrapper.eq(IdGenerator :: getTable_name, tableName).eq(IdGenerator :: getVersion, idGenerator.getVersion()).eq(IdGenerator :: getMaxId, oldMax);
                    idGenerator.setMaxId(newMax);
                    idGenerator.setVersion(idGenerator.getVersion() + 1);
                    int row = idGeneratorMapper.update(idGenerator, updateWrapper);
                    if (row == 1) {
                        return idGenerator.getMaxId();
                    } else {
                        log.error("失败了");
                    }
                }catch (Exception e) {
                    log.error("失败了");
                }

            }
        }
        return null;
    }

}
