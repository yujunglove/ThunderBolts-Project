package com.greedy.thunderbolts.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageConfig {
	
	@Bean
	public MessageSource messgaeSource() {
		
		ReloadableResourceBundleMessageSource messageSource 
		= new ReloadableResourceBundleMessageSource();
	
	messageSource.setBasename("classpath:/messages/messages");
	messageSource.setDefaultEncoding("UTF-8");
	
	return messageSource;
		
	}
	
	@Bean
	public MessageSourceAccessor messageSourceAccessor() {
		return new MessageSourceAccessor(messgaeSource());
	}

}
