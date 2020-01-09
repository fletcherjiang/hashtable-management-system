package com.longyx.zuul;

import com.tydic.zuul.filter.PreSendForwardFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author Administrator
 */
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
@EnableOAuth2Sso
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Bean
    public PreSendForwardFilter preSendForwardFilter(){
        return new PreSendForwardFilter();
    }

}
