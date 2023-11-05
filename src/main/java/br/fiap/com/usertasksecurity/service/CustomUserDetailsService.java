package br.fiap.com.usertasksecurity.service;

import br.fiap.com.usertasksecurity.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private List<User> users = Arrays.asList(
            new User(1, "harry", "password123", "ROLE_USER"),
            new User(2, "sebastian", "admin123", "ROLE_ADMIN")
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();

        if (user.isPresent()) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.get().getUsername())
                    .password(user.get().getPassword())
                    .roles(String.valueOf(user.get().getRoles()))
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }
    }
}

