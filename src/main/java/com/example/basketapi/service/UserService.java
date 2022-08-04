package com.example.basketapi.service;

import com.example.basketapi.model.User;
import com.example.basketapi.repositorie.UserRepositorie;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class UserService {
    private final UserRepositorie userRepositorie;

    public boolean existsUser (String login){
        User user = userRepositorie.getUsersByLogin(login);
        if(user == null){
            return false;
        } else {
            return true;
        }
    }
    public boolean authentication (String login , String pass){
        User user = userRepositorie.getUsersByLogin(login);
        Boolean temp = false;
        if(user.getLogin().equals(login) && user.getPassword().equals(pass)){
            temp = true;
        }
        return temp;
    }

    public boolean in (String login){
        User user = userRepositorie.getUsersByLogin(login);
        Boolean temp = false;
        if(user.getAuth().equals("YES")){
            temp = true;
        }
        return temp;
    }

    public void saveUser (User client){
        log.info("saving ne{}",client);
        userRepositorie.save(client);
    }
    public void deleteUser(String auntification){
        User user = userRepositorie.getUsersByLogin(auntification);
        userRepositorie.deleteById(user.getId());
    }


    public User getUser(String auntification){
        return userRepositorie.getUsersByLogin(auntification);
    }

}
