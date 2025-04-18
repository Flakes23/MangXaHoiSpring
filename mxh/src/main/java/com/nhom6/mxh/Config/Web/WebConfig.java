package com.nhom6.mxh.Config.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebConfig {
    @Autowired
    private UserDetailsService userDetailsService;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;
    private final LogoutSuccessHandler logoutSuccessHandler;

    public WebConfig(UserDetailsService userDetailsService, AuthenticationSuccessHandler authenticationSuccessHandler,
            LogoutSuccessHandler logoutSuccessHandler) {
        this.userDetailsService = userDetailsService;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    // mã hóa password
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //cho phep nhung duong dan khong can dang nhap
        http.csrf((csrf) -> csrf.disable()).authorizeHttpRequests((authorize) -> authorize.requestMatchers("/register", "/js/User/Account/**", "/js/**","css/**", "/confirmUser", "/Confirm", "/api/register", "/api/confirmUser").permitAll()
        //cac duong dan con lai can phai dang nhap
        .anyRequest().authenticated())
        //phuong thuc login
                .formLogin(login -> login.loginPage("/login")
                                         .loginProcessingUrl("/login")
                                         .successHandler(authenticationSuccessHandler)
                                         .permitAll())
                // phuong thuc logout
                .logout(logout -> logout
                        .logoutRequestMatcher(
                                new AntPathRequestMatcher("/logout", "POST"))
                        .logoutSuccessHandler(logoutSuccessHandler)
                        .permitAll().deleteCookies("auth_code", "JSESSIONID")
                        .invalidateHttpSession(true));
        return http.build();
    }

    // luu thong tin dang nhap
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        System.out.println(userDetailsService.toString() + " auth");
    }
}
