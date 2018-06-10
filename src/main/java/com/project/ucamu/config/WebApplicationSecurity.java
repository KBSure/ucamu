package com.project.ucamu.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/boards").and()
                .authorizeRequests()
                .requestMatchers(new AntPathRequestMatcher("/**.html")).permitAll()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/boards/writeform").hasRole("USER")
                .antMatchers("/boards/**").permitAll()
                .antMatchers("/users/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .csrf().ignoringAntMatchers("/**")
//                .ignoringAntMatchers("/h2-console/**")
                .and().headers().frameOptions().disable()
                .and().formLogin()
//                .and().rememberMe().tokenRepository(simpleBoardTokenRepositoryImpl).rememberMeParameter("remember-me").tokenValiditySeconds(1209600)
                .and().logout().permitAll();
    }
}
