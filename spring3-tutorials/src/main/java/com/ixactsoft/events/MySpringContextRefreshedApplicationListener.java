package com.ixactsoft.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Ovidiu Lupas
 */
@Component
public class MySpringContextRefreshedApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("MySpringContextRefreshedListener.onApplicationEvent");
    }
}