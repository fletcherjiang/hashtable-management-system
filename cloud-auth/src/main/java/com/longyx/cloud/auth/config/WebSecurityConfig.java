package com.longyx.cloud.auth.config;


/**
 * @program: cloud_manage_lyx
 * @author: Mr.Michael
 * @create: 2019-12-21 23:41
 **/
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//public class  WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//  @Autowired
//  private AuthenticationProvider authenticationProvider;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Bean
////    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
////        return new SecurityEvaluationContextExtension();
////    }
//
//    /**
//     * 认证管理
//     * @return 认证管理对象
//     * @throws Exception 认证异常信息
//     */
//    // 不定义没有password grant_type
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService())
//                .passwordEncoder(passwordEncoder());
//        auth.authenticationProvider(authenticationProvider);
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .logout().logoutSuccessUrl("http://localhost:9000/oauth/exit");
//
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // 将 check_token 暴露出去，否则资源服务器访问时报 403 错误
//        web.ignoring().antMatchers("/oauth/check_token");
//    }
//
//}
