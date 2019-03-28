package study.recruit.config;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.spel.spi.EvaluationContextExtension;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import study.recruit.common.Fix;
import study.recruit.common.Methods;
import study.recruit.entity.TblCandidate;
import study.recruit.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final LoginService loginService;

    @Autowired
    public WebSecurityConfig(LoginService loginService) {
        this.loginService = loginService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(Fix.MAP_ADM + "/**")
                .hasAuthority(Fix.ROL_ADM)
                .antMatchers(Fix.MAP_DEP + "/**")
                .hasAuthority(Fix.ROL_DEP)
                .antMatchers(Fix.MAP_CAN + "/**")
                .hasAuthority(Fix.ROL_CAN)
                .antMatchers(Fix.MAP_LOG + "/**")
                .hasAnyAuthority(Fix.ROL_ADM, Fix.ROL_DEP, Fix.ROL_CAN)
                .and()
                .formLogin()
                .loginPage("/loginPage")
                .loginProcessingUrl("/sign_in")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .successHandler(loginSuccessHandler())
                .failureHandler(loginFailureHandler())
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access_denied")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/sign_out", "GET"))
                .permitAll()
                .logoutSuccessUrl("/loginPage")
                .and()
                .csrf().disable();
    }

    private AuthenticationSuccessHandler loginSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                Methods methods = new Methods();
                TblCandidate tblCandidate = methods.getUser().getCandidate();
                response.getWriter().append(tblCandidate != null ? tblCandidate.getId() + "" : methods.getUser().getDepartment().getId() + "");
            }
        };
    }

    private AuthenticationFailureHandler loginFailureHandler() {
        return new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("dd/MM/yyyy HH:mm").create();
                response.getWriter().append(gson.toJson("Error"));
            }
        };
    }

    @Bean
    public EvaluationContextExtension securityExtension() {
        return new EvaluationContextExtension() {
            @Override
            public String getExtensionId() {
                return "security";
            }

            @Override
            public Object getRootObject() {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                return new SecurityExpressionRoot(authentication) {
                };
            }
        };
    }
}
