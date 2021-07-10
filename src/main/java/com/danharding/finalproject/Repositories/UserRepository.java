package com.danharding.finalproject.Repositories;

import com.danharding.finalproject.Models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
    User findByFirstName(String firstName);
    User findByLastName(String lastName);
}
