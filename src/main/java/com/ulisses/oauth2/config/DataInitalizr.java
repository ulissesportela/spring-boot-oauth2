package com.ulisses.oauth2.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ulisses.oauth2.entity.User;
import com.ulisses.oauth2.reporitory.UserRepository;

@Component
public class DataInitalizr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		List<User> users = userRepository.findAll();
		
		if (users.isEmpty()) {
			
			User user = User.builder()
							.nome("Ulisses Douglas")
							.email("ulisses.portela@gmail.com")
							.password("123456")
							.build();
			userRepository.save(user);
		}
	}

}
