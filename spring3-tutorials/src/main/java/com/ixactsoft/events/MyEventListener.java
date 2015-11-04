package com.ixactsoft.events;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Ovidiu Lupas
 */
@Component
public class MyEventListener {

    @EventListener
    @Order(value = 1)
    public void handleMyEvent(Event event) {
        System.out.println("MyEventListener.handleMyEvent");
        ;
    }

    @EventListener
    @Order(value = 0)
    public void handleCustomEvent(Event event) {
        System.out.println("MyEventListener.handleCustomEvent");
    }

}
