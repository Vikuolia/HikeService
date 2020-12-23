package com.example.hike.rabbitmq;

import com.example.hike.model.Hike;
import com.example.hike.service.HikeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.hike.rabbitmq.Config.QUEUE;

@Component
public class Consumer {

    @Autowired
    HikeService hikeService;

    @RabbitListener(queues = QUEUE)
    public  void consumeMessageFromQueue(Hike hike){
        System.out.println(hikeService.addHike(hike));
    }
}

