package com.ixactsoft.async.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * WebApplicationInitializer for Servlet 3.0+ environments in order to configure the ServletContext programmatically
 * -- as opposed to (or possibly in conjunction with) the traditional web.xml-based approach.
 *
 * @author Ovidiu Lupas
 */
public class SpringAsyncWebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
//        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
//        appContext.setConfigLocation("/WEB-INF/conf/spring-mvc-beans.xml");
//
//        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(appContext));
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");

        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext appContext = getContext();
        container.addListener(new ContextLoaderListener(appContext));

        ServletRegistration.Dynamic dispatcher = container.addServlet("DispatcherServlet", new DispatcherServlet(appContext));
        dispatcher.setAsyncSupported(true);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringAsyncConfig.class);
        return context;
    }
}
