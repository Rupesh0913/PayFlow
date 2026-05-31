package com.airtribe.payFlow.service;

import com.airtribe.payFlow.entity.User;
import com.airtribe.payFlow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     * At application startup, Spring scans all classes and creates
     * objects (beans) for classes annotated with @Service and repositories.
     * Spring automatically injects the UserRepository object here using
     * Dependency Injection through @Autowired.
     */

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User findByUpiId(String upiId) {
        return userRepository.findByUpiId(upiId);
    }

    public List<User> getUsersWithBalanceGreaterThan(Double amount) {
        return userRepository.findUsersWithBalanceGreaterThan(amount);
    }
}
