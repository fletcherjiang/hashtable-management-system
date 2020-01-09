package com.longyx.cloud.auth.config;

import com.longyx.common.security.config.MyResourceServerConfig;
import com.longyx.common.security.properties.WebSecurityProperties;
import com.longyx.common.security.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: Longyx
 * @Package: com.longyx.auth.config
 * @ClassName: SophiaWebSecurityConfig
 * @Description: web security 访问安全配置
 */
@EnableWebSecurity
@Configuration
@AutoConfigureBefore({MyResourceServerConfig.class, MyAuthorizationServerConfig.class})
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService cloudUserDetailService;

    @Autowired
    private WebSecurityProperties securityProperties;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers(securityProperties.getWeb().getUnInterceptUris())
                .permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(cloudUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //     auth
    //             .inMemoryAuthentication()
    //             .passwordEncoder(new BCryptPasswordEncoder())
    //             .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN");
    // }


}
