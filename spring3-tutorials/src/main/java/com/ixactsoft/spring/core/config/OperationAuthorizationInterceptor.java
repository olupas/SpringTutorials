package com.ixactsoft.spring.core.config;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @author Ovidiu Lupas
 */
@Component
@DependsOn("whitelistedIdentities")
public class OperationAuthorizationInterceptor {

    private Map<String, Set<String>> whitelist;

    @Autowired
    public OperationAuthorizationInterceptor(@Qualifier("whitelistedIdentities") Map<String, Set<String>> whitelist) {
        this.whitelist = whitelist;
        System.out.println(whitelist);
    }
}
