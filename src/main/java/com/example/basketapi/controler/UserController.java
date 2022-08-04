package com.example.basketapi.controler;

import com.example.basketapi.model.Basket;
import com.example.basketapi.model.User;
import com.example.basketapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(path="/client", produces="application/json")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;


    @PostMapping(path = "/auth/{login}/{pass}")
    public String getAuntification(@PathVariable("login") String login,@PathVariable("pass") String pass){
        Boolean exist = userService.existsUser(login);
        if (exist == false) {
            List<Basket> basket = null;
            User user = new User(null, login, pass, "NO", null);
            userService.saveUser(user);
            return "user create" + "\n LOGIN - " + login + "\n PASSWORD - " + pass ;
        } else {
            return "user already exists";
        }

    }
    @PostMapping(path = "/entrance/{login}/{pass}")
    public String etrance(@PathVariable("login") String login,@PathVariable("pass") String pass){
        Boolean exist = userService.existsUser(login);
        User user1 = userService.getUser(login);
        if(exist == false){
            return "create account";
        } else {
            if (userService.authentication(login,pass) == true) {
                User user = userService.getUser(login);
                user.setAuth("YES");
                userService.saveUser(user);
                return "entrance complite";
            } else  {
                return "incorrect username or password ";
            }
        }
    }

    @PostMapping(path = "/out/{login}")
    public String out(@PathVariable("login") String login){
        Boolean exist = userService.existsUser(login);
        if(exist == false){
            return "create account";
        } else {
            User user = userService.getUser(login);
            user.setAuth("NO");
            userService.saveUser(user);
            return "out complite";
        }
    }

    @PostMapping (path = "/changePassword/{login}/{pass}/{passNew}")
    public String newPassword (@PathVariable("login") String login,
                               @PathVariable("pass") String pass,
                               @PathVariable("passNew") String passNew){
        Boolean exist = userService.existsUser(login);
        if(exist == false){
            return "create account";
        } else if (userService.authentication(login,pass) == true && userService.in(login) == true) {
            User user = userService.getUser(login);
            user.setPassword(passNew);
            userService.saveUser(user);
            return "complite";
        }  else if (!userService.in(login)  && userService.authentication(login,pass) == true) {
            return "not entrance ";
        } else {
            return "incorrect username or password ";
        }
    }

    @PostMapping(path = "/get/{login}")
    public User getAuntification(@PathVariable("login") String login){
        return userService.getUser(login);
    }



    @DeleteMapping(path = "/{count}")
    public String deleteAccount(@PathVariable("count") String count){
        userService.deleteUser(count);
        return "Delete - " + count;
    }

}
