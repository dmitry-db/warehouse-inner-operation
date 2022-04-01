package warehouse.inneroperationscore.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import warehouse.inneroperationscore.security.handler.LoginSuccessHandler;
import warehouse.inneroperationscore.security.services.interfaces.UserSecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserSecurityService userSecurityService;
    private final LoginSuccessHandler loginSuccessHandler;

    public SecurityConfig(UserSecurityService userSecurityService, LoginSuccessHandler loginSuccessHandler) {
        this.userSecurityService = userSecurityService;
        this.loginSuccessHandler = loginSuccessHandler;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/security/**").hasRole("OWNER")
                .anyRequest().authenticated();
        http.formLogin()
                .permitAll()
                .successHandler(loginSuccessHandler)
                .usernameParameter("login")
                .passwordParameter("password")
                .permitAll();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
