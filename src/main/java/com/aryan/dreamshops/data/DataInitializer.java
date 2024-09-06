package com.aryan.dreamshops.data;

import com.aryan.dreamshops.model.Role;
import com.aryan.dreamshops.model.User;
import com.aryan.dreamshops.repository.RoleRepository;
import com.aryan.dreamshops.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
@RequiredArgsConstructor
@Component
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Set<String> roles = Set.of("ROLE_ADMIN", "ROLE_CUSTOMER");
        createDefaultRolesIfNotExists(roles);
        createDefaultUserIfNotExists();
        createDefaultAdminIfNotExists();
    }

    private void createDefaultUserIfNotExists() {
        Role userRole = roleRepository.findByName("ROLE_CUSTOMER").get();
        for (int i = 1; i <= 5; i++) {
            String email = "user" + i + "@email.com";
            if (!userRepository.existsByEmail(email)) {
                userRepository.save(
                        User.builder()
                                .firstName("The User")
                                .lastName("User" + i)
                                .email(email)
                                .roles(Set.of(userRole))
                                .password(passwordEncoder.encode("1234"))
                                .build()
                );
            }
        }
    }

    private void createDefaultAdminIfNotExists() {
        Role userRole = roleRepository.findByName("ROLE_ADMIN").get();
        for (int i = 1; i <= 2; i++) {
            String email = "admin" + i + "@email.com";
            if (!userRepository.existsByEmail(email)) {
                userRepository.save(
                        User.builder()
                                .firstName("Admin")
                                .lastName("Admin" + i)
                                .email(email)
                                .roles(Set.of(userRole))
                                .password(passwordEncoder.encode("1234"))
                                .build()
                );
            }
        }
    }

    private void createDefaultRolesIfNotExists(Set<String> roles) {
        roles.stream()
                .filter(role->roleRepository.findByName(role).isEmpty())
                .map(Role::new).forEach(roleRepository::save);

    }
}
