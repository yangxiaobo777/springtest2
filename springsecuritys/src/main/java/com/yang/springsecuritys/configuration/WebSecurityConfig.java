package com.yang.springsecuritys.configuration;


import com.yang.springsecuritys.filters.MyAuthenticationFailureHandler;
import com.yang.springsecuritys.filters.VerificationCodeFilter;
import com.yang.springsecuritys.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yang
 * @className WebSecurityConfig
 * @description TODO
 * @date 2021/12/14 10:01
 * @Version 1.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyUserDetailService userDetailService;

   /* @Autowired
    private AuthenticationProvider provider;

    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> detailsSource;


*/
   public static void main(String[] args) {
       Assert.notNull(null,"is null");
       System.out.println("ok");

   }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("xiao").password("123").roles("USER")
                .and()
                .withUser("bo").password("456").roles("ADMIN")
                .and()
                .passwordEncoder(new MyPasswordEncoder());*/
        //auth.authenticationProvider(provider);
        /*auth.jdbcAuthentication()
                .dataSource(dataSource)
                .withUser("xiao").password("123").roles("USER")
                .and()
                .withUser("bo").password("456").roles("ADMIN")
                .and()
                .withUser("yang").password("123").roles("ADMIN,USER")
                .and()
                .passwordEncoder(new MyPasswordEncoder());*/

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**","/image/captcha.jpg","/myLogin.html").permitAll()
                //.antMatchers("").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()


                //.loginPage("/myLogin.html")
                //.loginProcessingUrl("/auth/form")
                //.authenticationDetailsSource(detailsSource)
                .failureHandler(new MyAuthenticationFailureHandler())
                .and()
                .rememberMe()
                .userDetailsService(userDetailService)
                .key("jjjjj")
                .and()
                .sessionManagement()
                .sessionFixation()
                .migrateSession()
                .invalidSessionUrl("")
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true);









         http.addFilterBefore(new VerificationCodeFilter(), UsernamePasswordAuthenticationFilter.class);

         http.logout()
                 .logoutUrl("/toLogOut")
                 .logoutSuccessUrl("/logOutSuccess")
                 .logoutSuccessHandler(new LogoutSuccessHandler() {
                     @Override
                     public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

                     }
                 })
                 .invalidateHttpSession(true)
                 .deleteCookies("cookies1")
                 .addLogoutHandler(new LogoutHandler() {
                     @Override
                     public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

                     }
                 });



                //.loginPage("/myLogin.html");

    }





}
