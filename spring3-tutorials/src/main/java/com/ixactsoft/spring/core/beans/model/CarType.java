package com.ixactsoft.spring.core.beans.model;

/**
 * Created with IntelliJ IDEA.
 * User: Ovidiu Lupas
 * Date: 07.10.2015
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public enum CarType {

   JEEP ("jeep"), VAN("van"), SEDAN("sedan");

    private String description;

    private CarType(String description) {
        this.description = description;
    }


    public static CarType getByDescription(String description) {
        for (CarType type : values()) {
            if (type.description.equals(description)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Illegal description "+description);
    }

}
