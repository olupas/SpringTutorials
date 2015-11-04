package com.ixactsoft.events;

/**
 * @author Ovidiu Lupas
 */
public class Event {

    private String type;
    private Object source;

    public Event(Object source, String type) {
        this.source = source;
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
                ", source=" + source +
                '}';
    }
}
