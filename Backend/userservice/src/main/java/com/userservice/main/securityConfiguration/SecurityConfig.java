package com.userservice.main.securityConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
////    private final UserDetailsService userDetailsService;
////
////    public SecurityConfig(UserDetailsService userDetailsService) {
////        this.userDetailsService = userDetailsService;
////    }
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
////    }
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////            .authorizeRequests()
////                .antMatchers("/public/**").permitAll()  // Example: allow access to public resources
////                .anyRequest().authenticated()
////                .and()
////            .formLogin()
////                .loginPage("/login")
////                .permitAll()
////                .and()
////            .logout()
////                .permitAll();
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////}
//
////@SuppressWarnings("deprecation")
////@Configuration
////@EnableWebSecurity
////public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
////	
////	
////	@Autowired
////	private UserService userService;
////	
////	
////	@Bean
////	public BCryptPasswordEncoder passwordEncoder() {
////		
////		return new BCryptPasswordEncoder();	
////	}
////	
////	
////	@Bean
////	public DaoAuthenticationProvider authencationprovider() {
////		
////		DaoAuthenticationProvider auth  = new DaoAuthenticationProvider();
////	    auth.setUserDetailsService((UserDetailsService) userService);
////	    auth.setPasswordEncoder(passwordEncoder()); 
////	    
////	    return auth;
////	}
////	
////	
////     @Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
////		auth.authenticationProvider(authencationprovider());
////		
////	}
////	
////	
////
////	@Override
////	protected void configure(HttpSecurity http)throws Exception{
////        http.authorizeRequests().antMatchers(
////                "/registration**",
////                "/js/**",
////                "/css/**",
////                "/img/**")
////                .permitAll()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .permitAll()
////                .and()
////                .logout()
////                .invalidateHttpSession(true)
////                        .clearAuthentication(true)
////                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                        .logoutSuccessUrl("/login?logout")
////                        .permitAll();
////		
////        	}
////	}
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user") // Username
                .password(passwordEncoder().encode("password")) // Encoded password
        .roles("USER");// Role(s) for this user
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//            .authorizeHttpRequests()          
//                .antMatchers("/pubilic/**").permitAll() // Allow access to home page without authentication             
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
                .logout(logout -> logout  // Configure logout
                        .logoutUrl("/logout") // Specify logout URL
                        .logoutSuccessUrl("/login?logout") // Redirect to login page after logout
                        .invalidateHttpSession(true) // Invalidate session
                        .deleteCookies("JSESSIONID")); // Remove session cookies
    }
}
