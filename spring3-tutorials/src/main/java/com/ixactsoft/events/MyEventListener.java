package com.ixactsoft.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Ovidiu Lupas
 */
@Component
public class MyEventListener {

    @EventListener
    public void handleMyEvent(Event event) {
        System.out.println("MySpringEventListener.handleMyEvent" + event);
    }
}
