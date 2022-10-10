package com.example.restwebServices.restfulwebservices.UserJpa;

import com.example.restwebServices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userJpaRepo extends JpaRepository<User, Integer> {


}
