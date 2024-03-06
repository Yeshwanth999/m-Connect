package com.userservice.main.securityConfiguration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.userservice.main.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{

	@Bean
	public UserDetailsService userDetailsService() {

		return new UserServiceImpl();
	}

	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable()) // Disabling CSRF for simplicity, enable it in production
	            .authorizeRequests(authorizeRequests -> authorizeRequests
	                    .requestMatchers(new AntPathRequestMatcher("/user/login")).permitAll()
	                    .requestMatchers(new AntPathRequestMatcher("/user/updateemp/{gmail}")).permitAll()
	                    .requestMatchers(new AntPathRequestMatcher("/user/applyLeave/{guid}")).permitAll()
	                    .requestMatchers(new AntPathRequestMatcher("/user/**")).authenticated())
	            .formLogin(withDefaults());

	    return http.build();
	}


	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

}

//    @Autowired
//    private UserServiceImpl userService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // Configure authentication provider
//        auth.userDetailsService(userService)
//            .passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(requests -> requests
//                        .antMatchers("/user/login").permitAll() // Allow login endpoint without authentication
//                        .anyRequest().authenticated())
//                .formLogin(login -> login
//                        .loginPage("/user/SignIn") // Custom login page
//                        .permitAll())
//                .logout(logout -> logout  // Configure logout
//                      .logoutUrl("/logout") // Specify logout URL
//                      .logoutSuccessUrl("/login?logout") // Redirect to login page after logout
//                      .invalidateHttpSession(true) // Invalidate session
//                      .deleteCookies("JSESSIONID")); // Remove session cookies
//    }
////    .logout(logout -> logout
////          .logoutUrl("/user/logout") // Custom logout URL
////          .logoutSuccessUrl("/SignIn?logout")
////          .permitAll())
////  .csrf(csrf -> csrf.disable()); // Disable CSRF for simplicity (enable it in production)
////}
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
//
////                .logout(logout -> logout  // Configure logout
////                        .logoutUrl("/logout") // Specify logout URL
////                        .logoutSuccessUrl("/login?logout") // Redirect to login page after logout
////                        .invalidateHttpSession(true) // Invalidate session
////                        .deleteCookies("JSESSIONID")); // Remove session cookies
////    }
////    
//    
//   