package com.czl.business.api.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-26
 * @创建时间: 18:03
 */

@Component
@RabbitListener ( queues = "fanout.C" )
public class FanoutReceiverC {

    @RabbitHandler
    public void process (String testMessage) {
        System.out.println("FanoutReceiverC消费者收到消息  : " + testMessage);
    }

}
