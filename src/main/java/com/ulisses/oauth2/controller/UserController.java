package com.ulisses.oauth2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ulisses.oauth2.entity.User;
import com.ulisses.oauth2.reporitory.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @Secured({"ROLE_ADMIN", "ROLE_ALUNO"})
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> list() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public User edit(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        this.userRepository.deleteById(id);
    }

}
