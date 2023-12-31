package commerce.config;

import commerce.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = MemberService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  MemberService memberService;

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.formLogin()
        .loginPage("/members/login")
        .defaultSuccessUrl("/")
        .usernameParameter("userId")
        .failureUrl("/members/login/error")
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
        .logoutSuccessUrl("/")
        ;
  }
  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.userDetailsService(memberService)
        .passwordEncoder(passwordEncoder());
  }
}
