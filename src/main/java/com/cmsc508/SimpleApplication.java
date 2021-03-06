package com.cmsc508;

import com.cmsc508.handlers.OAuthAuthenticationSuccessHandler;
import com.cmsc508.model.Student;
import com.cmsc508.repository.StudentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

import javax.servlet.Filter;

@SpringBootApplication
@EnableOAuth2Client
@RestController
public class SimpleApplication extends WebSecurityConfigurerAdapter {

    @Autowired
    JdbcTemplate jdbcTemplate;

	@Autowired
	OAuth2ClientContext oauth2ClientContext;

	@Autowired
	private OAuthAuthenticationSuccessHandler oAuthAuthenticationSuccessHandler;

	@Bean
	@ConfigurationProperties("security.oauth2.client")
	public AuthorizationCodeResourceDetails google() {
		return new AuthorizationCodeResourceDetails();
	}

	@Bean
	@ConfigurationProperties("security.oauth2.resource")
	public ResourceServerProperties googleResource() {
		return new ResourceServerProperties();
	}

	@Bean
	public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(filter);
		registration.setOrder(-100);
		return registration;
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**")
				.authorizeRequests()
				.antMatchers("/", "/login**", "/webjars/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and().formLogin().loginPage("/login")
				.and().logout().logoutSuccessUrl("/").permitAll()
				.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and().addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
		;
	}


	private Filter ssoFilter() {
		OAuth2ClientAuthenticationProcessingFilter googleFilter = new OAuth2ClientAuthenticationProcessingFilter("/login");
		OAuth2RestTemplate googleTemplate = new OAuth2RestTemplate(google(), oauth2ClientContext);
		googleFilter.setRestTemplate(googleTemplate);
		UserInfoTokenServices tokenServices = new UserInfoTokenServices(googleResource().getUserInfoUri(), google().getClientId());
		tokenServices.setRestTemplate(googleTemplate);
        tokenServices.setPrincipalExtractor(map -> {
            Student student = new Student();
            student.setEmail((String) map.get("email"));
            student.setName((String) map.get("name"));
            student.setOauthUserId((String) map.get("id"));

            return (new StudentsRepository(jdbcTemplate)).createOrUpdate(student);
        });
		googleFilter.setTokenServices(tokenServices);
		googleFilter.setAuthenticationSuccessHandler(oAuthAuthenticationSuccessHandler);
		return googleFilter;
	}
}
