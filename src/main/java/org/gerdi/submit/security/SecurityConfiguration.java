package org.gerdi.submit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    public final static String AUTHORIZATION_HEADER = "Authorization";

    @Autowired
    private TokenProvider tokenProvider;

//    @Autowired
//    private AuthenticationProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(this.authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        JWTFilter customFilter = new JWTFilter(this.tokenProvider);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);

        // @formatter:off
        http.authorizeRequests().antMatchers("/css/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/authenticate").permitAll()
                .anyRequest().fullyAuthenticated();
        // @formatter:on
        http.csrf().disable();

    }
}
