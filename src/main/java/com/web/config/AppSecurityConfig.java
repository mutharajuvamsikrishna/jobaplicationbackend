package com.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.web.filter.JwtRequestFilter;
import com.web.service.UserDetail;

@EnableWebSecurity
@Order(1)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired

	private UserDetail myUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
@Autowired
private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean(name = "userAuthentication")
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeRequests()
				.antMatchers(
						"/authenticate", "/authenticate1", "/register", "/save", "/otp1", "/changepassword",
						"/otp5", "/changepassword1", "/adminregister", "/adminotp1", "/adminsave",
						"/adminchangepassword", "/adminotp5", "/adminchangepassword1", "/alluserregisters",
						"/alladminregisters", "/superadminlogin", "/superchangepassword", "/superchangepassword1",
						"/superadmreq", "/superdelete", "/adminsearch", "/supreditupdate", "/superviewprofessional",
						"/supreg", "/supsave", "/deleteuserreg", "/supadminreg", "/deleteadminreg", "/supadminsave",
						"/getallreg", "/getalladminreg")
				.permitAll()
				.and() // Add this to separate JWT and OAuth configurations
				.authorizeRequests()
				.antMatchers("/loginoauth","/reg/**")
				.permitAll() // Allow access to the OAuth2.0 login URL
				.and() // Add this to separate JWT and OAuth configurations
				.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
				.oauth2Login()
				.successHandler(customAuthenticationSuccessHandler)
				.and()
				.exceptionHandling()
				.and()
				.cors()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}


}