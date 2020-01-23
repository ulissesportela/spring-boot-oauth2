package com.ulisses.oauth2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ulisses.oauth2.entity.User;
import com.ulisses.oauth2.reporitory.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @Secured({"ROLE_ADMIN", "ROLE_ALUNO"})
    @GetMapping
    public Page<User> list(
    		@RequestParam("page") int page,
    		@RequestParam("size") int size
    		
    ) {
    	Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @PutMapping
    public User edit(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.userRepository.deleteById(id);
    }

}
