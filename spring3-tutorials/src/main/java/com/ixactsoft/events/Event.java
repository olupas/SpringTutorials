package com.ixactsoft.events;

import org.springframework.context.ApplicationEvent;

/**
 * @author Ovidiu Lupas
 */
public class Event extends ApplicationEvent {

    private String type;

    public Event(Object source, String type) {
        super(source);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                '}';
    }
}
