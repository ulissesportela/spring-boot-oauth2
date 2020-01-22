package com.ulisses.oauth2.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ulisses.oauth2.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String username);
}
