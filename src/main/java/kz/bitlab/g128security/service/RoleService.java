package kz.bitlab.g128security.service;

import kz.bitlab.g128security.entity.Role;
import kz.bitlab.g128security.reposity.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").orElseThrow();
    }
}
