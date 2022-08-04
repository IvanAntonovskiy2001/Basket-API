package com.example.basketapi.service;

import com.example.basketapi.model.Basket;
import com.example.basketapi.model.User;
import com.example.basketapi.repositorie.BasketRepositorie;
import com.example.basketapi.repositorie.UserRepositorie;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Data
public class BasketService {
    private final BasketRepositorie basketRepositories;
    private final UserRepositorie userRepositorie;
    public List<Basket> listBasket(String auntificator) {
        List<Basket> product = userRepositorie.getUsersByLogin(auntificator).getBaskets();
        return product;
    }

    public void saveBasket(List<Basket> product , User user) {
        log.info("Saving ne {}",product);
        user.setBaskets(product);
        userRepositorie.save(user);
    }


    public void deleteBasketId(User user,Long id) {
        List<Basket> baskets = user.getBaskets();
        for (int i = 0 ; i < baskets.size();i++){
            if(baskets.get(i).getId() == id){
                baskets.remove(baskets.get(i));
            }
        }
        user.setBaskets(baskets);
        userRepositorie.save(user);
    }

    public  void deleteBasketALl(User user){
        List<Basket> baskets = user.getBaskets();
        baskets.clear();
        user.setBaskets(baskets);
        userRepositorie.save(user);
    }


}
