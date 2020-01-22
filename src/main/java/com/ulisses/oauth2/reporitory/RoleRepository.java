package com.ulisses.oauth2.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ulisses.oauth2.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
