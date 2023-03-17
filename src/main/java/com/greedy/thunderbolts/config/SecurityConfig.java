package com.greedy.thunderbolts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig {
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
        return http
        		.csrf().disable()
                .authorizeRequests()
                .antMatchers("/board/**", "/thumbnail/**", "/member/update", "/member/delete").hasRole("MEMBER")
                // 관리자만 사용 가능한 기능은 현재는 없음
                .anyRequest().permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login/loginMain")             
                    .defaultSuccessUrl("/")  
                    .failureForwardUrl("/login/loginfail")
                    .usernameParameter("userId")			// 아이디 파라미터명 설정 기본값 username에서 변경
                    .passwordParameter("userPwd")			// 패스워드 파라미터명 설정 기본값 password에서 변경
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/login/logout"))
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/")
                // 따라서 인가 오류 처리는 생략하였음
    			.and()
    				.build();
    }

}


