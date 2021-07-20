package com.danharding.coastercreditcounter.Repositories;

import com.danharding.coastercreditcounter.Models.User;
import com.danharding.coastercreditcounter.Services.DataAccess.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // TODO: get rid of this cheese ... please ... lolz
public class MySQLUserDao implements UserDao {

    private final UserRepository userRepository;

    public MySQLUserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public void delete(User deleteUser) {
        userRepository.delete(deleteUser);
    }

}
