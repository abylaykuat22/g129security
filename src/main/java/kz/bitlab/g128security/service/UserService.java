package kz.bitlab.g128security.service;

import kz.bitlab.g128security.entity.User;
import kz.bitlab.g128security.reposity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(String username, String password, String rePassword, String fullName) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            System.out.println("User already exists");
            return;
        }

        if (!Objects.equals(password, rePassword)) {
            System.out.println("Passwords don't match!");
            return;
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setFullName(fullName);
        newUser.setRoles(Collections.singleton(roleService.getUserRole()));
        userRepository.save(newUser);
        System.out.println("User created successfully");
    }
}
