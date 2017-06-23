package com.ixactsoft.spring.core.config;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class WhitelistConfiguration {

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * Loads the whitelist properties file.
     *
     * @param whitelistPath
     * @return
     */
    @Bean
    public PropertiesFactoryBean whitelistProperties(@Value("${whitelist.path}") String whitelistPath) throws
            MalformedURLException {
        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        factoryBean.setLocation(resourceLoader.getResource(whitelistPath));
        return factoryBean;
    }

    @Bean
    @DependsOn("whitelistProperties")
    public Map<String, Set<String>> whitelistedIdentities(@Qualifier("whitelistProperties") Properties whitelistProperties) {
        Map<String, Set<String>> result = new HashMap<>();
        for (Map.Entry<Object, Object> entry : whitelistProperties.entrySet()) {
            result.put((String) entry.getKey(), commaDelimitedListToSet((String) entry.getValue()));
        }
        return result;
    }

    /**
     * Self-explanatory.
     *
     * @param value input string
     * @return set containing the values between commas
     */
    private static Set<String> commaDelimitedListToSet(String value) {
        return org.springframework.util.StringUtils.commaDelimitedListToSet(value);
    }

}

