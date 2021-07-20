package com.danharding.coastercreditcounter.Services.DataAccess;

import java.util.List;
import java.util.Optional;

import com.danharding.coastercreditcounter.Models.User;

public interface UserDao {
    User findByUsername(String username);
    List<User> findAll();
    Optional<User> findById(long id);
    User save(User newUser);
    void delete(User deleteUser);
}
