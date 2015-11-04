package com.ixactsoft.events;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Ovidiu Lupas
 */
@Component
public class MySpringContextRefreshedEventListener {

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        System.out.println("MySpringContextRefreshedEventListener.handleContextRefresh");
    }

}
