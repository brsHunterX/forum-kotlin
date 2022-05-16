package br.com.alura.forum.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
  private val service: UserDetailsService
): WebSecurityConfigurerAdapter() {

  @Bean
  fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
    return BCryptPasswordEncoder();
  }

  override fun configure(http: HttpSecurity?) {
    http
      ?.authorizeRequests()
      ?.antMatchers("/topics")?.hasAuthority("Student")
      ?.anyRequest()
      ?.authenticated()
      ?.and()
      ?.sessionManagement()
      ?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      ?.and()
      ?.formLogin()
      ?.disable()
      ?.httpBasic();
  }

  override fun configure(auth: AuthenticationManagerBuilder?) {
    auth
      ?.userDetailsService(service)
      ?.passwordEncoder(bCryptPasswordEncoder());
  }
}