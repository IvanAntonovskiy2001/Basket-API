package com.example.basketapi.controler;

import com.example.basketapi.model.Basket;
import com.example.basketapi.model.User;
import com.example.basketapi.service.BasketService;
import com.example.basketapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path="/basket", produces="application/json")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
public class BasketController {
    private final BasketService basketService;
    private final UserService userService;

    @PostMapping(value = "/create/{count}",consumes = "application/json", produces = "application/json")
    public List<Basket> createBaskett(@RequestBody Basket basket, @PathVariable("count") String count){
        if(userService.in(count) == true) {
            User user = userService.getUser(count);
            user.getBaskets().add(basket);
            userService.saveUser(user);
            return user.getBaskets();
        } else {
            return null;
        }
    }

    @DeleteMapping (value = "/{count}/{id}")
    public List<Basket> deleteById(@PathVariable("count") String count, @PathVariable Long id){
        if(userService.in(count) == true) {
        basketService.deleteBasketId(userService.getUser(count), id);
        User user = userService.getUser(count);
        return user.getBaskets();
        } else {
            return null;
        }
    }

    @DeleteMapping (value = "/{count}/all")
    public List<Basket> deleteById(@PathVariable("count") String count){
        if(userService.in(count) == true) {
        User user = userService.getUser(count);
        basketService.deleteBasketALl(user);
        User user1 = userService.getUser(count);
        return user1.getBaskets();
        } else {
            return null;
        }

    }
}
