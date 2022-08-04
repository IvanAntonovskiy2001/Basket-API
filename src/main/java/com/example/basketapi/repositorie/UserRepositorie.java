package com.example.basketapi.repositorie;

import com.example.basketapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorie extends JpaRepository<User, Long> {
    User getUsersByLogin(String login);
}
