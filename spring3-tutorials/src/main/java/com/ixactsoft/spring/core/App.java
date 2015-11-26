package com.ixactsoft.spring.core;

import com.ixactsoft.events.Event;
import com.ixactsoft.events.MyEventTrigger;
import com.ixactsoft.spring.core.beans.HelloWorld;
import com.ixactsoft.spring.core.beans.model.Person;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("conf/spring-app-beans.xml");
        context.start();

        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();

        Map<String, Person> persons = context.getBeansOfType(Person.class);
        System.out.println(persons);

        MyEventTrigger trigger = context.getBean(MyEventTrigger.class);
        trigger.publishEvent(new Event(trigger, "mytype"));

        context.close();
    }
}
