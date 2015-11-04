package com.ixactsoft.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Ovidiu Lupas
 */
@Component
public class MySpringContextClosedListener implements ApplicationListener<ContextClosedEvent> {


    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("MySpringContextClosedListener.onApplicationEvent");
    }
}