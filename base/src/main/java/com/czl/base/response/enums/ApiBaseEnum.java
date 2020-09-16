package com.czl.base.response.enums;

import java.io.Serializable;

/**
 * api接口响应的顶级抽象
 */
public interface ApiBaseEnum extends Serializable {

    /**
     * api响应code码
     * @return
     */
    int getCode ();

    /**
     * api响应code码描述
     * @return
     */
    String getMsg ();

    /**
     * api响应code码中文描述
     * @return
     */
    String getNote ();

}
