package com.project.ucamu.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebApplicationSecurity extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .requestMatchers(new AntPathRequestMatcher("/coreui/**"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/") //임시
                .and().authorizeRequests()
                    .requestMatchers(new AntPathRequestMatcher("/**.html")).permitAll()
                    .antMatchers("/board/**/write").hasRole("USER")
                    .antMatchers("/board/**/great").hasRole("USER")
                    .antMatchers("/board/**/rewrite").hasRole("USER")
                    .antMatchers("/board/**/delete").hasRole("USER")
                    .antMatchers("/").permitAll()
                    .antMatchers("/board/**").permitAll()
                    .antMatchers("/user/join/**").permitAll()
                    .antMatchers("/h2-console/**").permitAll()
                    .anyRequest().fullyAuthenticated()
//                .and().csrf().ignoringAntMatchers("/**")
//                .ignoringAntMatchers("/h2-console/**")
                .and().headers().frameOptions().disable()
                .and().formLogin()
                    .loginPage("/user/login")
    //                .loginProcessingUrl("/user/login")
                    .usernameParameter("idName")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/") // 성공하면 이동하는 페이지. --> 컨트롤러에 매핑 X --> 404
                    .successHandler(customAuthenticationSuccessHandler())
                    .failureUrl("/user/login")
                    .permitAll()
//                .and().rememberMe().tokenRepository(simpleBoardTokenRepositoryImpl).rememberMeParameter("remember-me").tokenValiditySeconds(1209600)
                .and().logout().permitAll();
    }

    @Bean
    public CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler(){
        CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler = new CustomAuthenticationSuccessHandler();
        customAuthenticationSuccessHandler.setUseReferer(true);
        customAuthenticationSuccessHandler.setDefaultTargetUrl("/");
        customAuthenticationSuccessHandler.setTargetUrlParameter("loginRedirect");

        return customAuthenticationSuccessHandler;
    }

    //logoutSucessHandler
}