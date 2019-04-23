package com.app.creditcard.config;


import com.app.creditcard.repo.UserRepo;
import com.app.creditcard.service.impl.CustomerUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private CustomerUserDetailsServiceImpl customerUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customerUserDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("**/secure/**").authenticated()
                .antMatchers("\"/h2-console/**/**\"").permitAll()
                //.antMatchers("/app/**").permitAll()
                .and()
                .formLogin().loginPage("/app/welcome")
                .loginProcessingUrl("/app-login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/secure/home")
                .and()
                .logout()
                .logoutUrl("/app-logout")
                .logoutSuccessUrl("/app/welcome")
                .and().exceptionHandling()
                .accessDeniedPage("/error");

    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }
}
