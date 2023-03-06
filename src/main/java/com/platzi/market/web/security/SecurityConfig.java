package com.platzi.market.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.platzi.market.domain.service.PlatziUserDetailsService;

@EnableWebSecurity
public class SecurityConfig {

   @Autowired
   private PlatziUserDetailsService platziUserDetailsService;

   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(platziUserDetailsService);
   }

   protected void configure(HttpSecurity httpSecurity) throws Exception {
      httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/**/authenticate").permitAll().anyRequest().authenticated();
   }

//   @Bean
//   public AuthenticationManager authenticationManagerBean() throws Exception {
//      return super.authenticationManagerBean;
//   }

}
