package com.czl.rabbitmq.api;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-21
 * @创建时间: 18:16
 */
@RestController
public class MqController {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    @GetMapping ( "/sendDirectMessage" )
    public String sendDirectMessage () {
        String message = "直连";
        rabbitTemplate.convertAndSend("DirectExchange", "DirectRouting", message);
        return "ok";
    }

    @GetMapping ( "/sendTopicMessage1" )
    public String sendTopicMessage1 () {
        String message = "主题1";
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", message);
        return "ok";
    }

    @GetMapping ( "/sendTopicMessage2" )
    public String sendTopicMessage2 () {
        String message = "主题2";
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", message);
        return "ok";
    }

    @GetMapping ( "/sendFanoutMessage" )
    public String sendFanoutMessage () {
        String message = "扇形";
        rabbitTemplate.convertAndSend("fanoutExchange", null, message);
        return "ok";
    }
}