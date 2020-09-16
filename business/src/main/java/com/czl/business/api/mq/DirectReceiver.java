package com.czl.business.api.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-21
 * @创建时间: 18:31
 */
@Component
@RabbitListener ( queues = "DirectQueue" )//监听的队列名称 DirectQueue
public class DirectReceiver {

    @RabbitHandler
    public void process (String testMessage) {
        System.out.println("消费者收到消息  : " + testMessage);
    }
}