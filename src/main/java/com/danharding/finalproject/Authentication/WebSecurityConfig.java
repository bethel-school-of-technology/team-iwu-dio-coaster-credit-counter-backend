package com.danharding.finalproject.Authentication;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import com.danharding.finalproject.Services.MySQLUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	MySQLUserDetailsService mySQLUserDetailsService;
	private static final String UNICODE_FORMAT = "UTF-8";

	@Bean
	public PasswordEncoder passwordEncoder() {
		System.out.println("passwordEncoder function called");
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(mySQLUserDetailsService).passwordEncoder(passwordEncoder());
	}

	public static void encryptData() {
		
		String text = "";
 
		try {
			SecretKey key = generateKey("AES");
			Cipher cipher;
			cipher = Cipher.getInstance("AES");
			byte[] encryptedData = encryptString(text, key, cipher);
			String encryptedString = new String(encryptedData);
			System.out.println(encryptedString);

		} catch (Exception e) {

		}
	}

	public static SecretKey generateKey(String encryptionType) {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(encryptionType);
			SecretKey myKey = keyGenerator.generateKey();
			return myKey;
		} catch (Exception e) {
			return null;
		}
	}

	public static byte[] encryptString(String dataToEncrypt, SecretKey myKey, Cipher cipher) {
		try {
			byte[] text = dataToEncrypt.getBytes(UNICODE_FORMAT);
			cipher.init(Cipher.ENCRYPT_MODE, myKey);
			byte[] textEncrypted = cipher.doFinal(text);

			return textEncrypted;
		} catch (Exception e) {
			return null;
		}
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST, "/users/register").permitAll()
				.antMatchers(HttpMethod.POST, "/users/login").permitAll()
				.antMatchers(HttpMethod.POST, "/coasters/credits").permitAll()
				.antMatchers(HttpMethod.POST, "/coasters/bucketlist").permitAll()
				.antMatchers(HttpMethod.GET, "/coasters/credits").permitAll()
				.antMatchers(HttpMethod.GET, "/users").permitAll()
				.antMatchers(HttpMethod.GET, "/coasters/bucketlist").permitAll()
				.antMatchers(HttpMethod.DELETE, "/coasters/bucketlist/{id}").permitAll()
				.antMatchers(HttpMethod.PUT, "/users/{id}").permitAll()
				.anyRequest().authenticated().and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager())).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.applyPermitDefaultValues();
		corsConfig.setExposedHeaders(Arrays.asList("Authorization"));
		source.registerCorsConfiguration("/**", corsConfig);
		return source;
	}
}
