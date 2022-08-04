# Basket-API
REST API 
В даннов апи реализовано поведение продуктовой корзины , то есть можно создать пользователя с корзиной , в которую можно "класть" продукты с помощью json file
методы:
1) POST: http://localhost:8080/auth/{login}/{pass} - Запрос для регистрации пользователя.
curl --location --request POST ‘http://localhost:8080/client/ auth/pas/pas'

2) POST: http://localhost:8080/client/entrance/{login}/{pass}- Запрос для входа в аккаунт - нужно для использования возможностей корзины
curl --location --request POST ‘http://localhost:8080/client/ entrance/pas/pas'

3) POST: http://localhost:8080/client/out/{login} - запрос для выхода из аккаунта
curl --location --request POST ‘http://localhost:8080/client/ out/pas'

4)POST:http://localhost:8080/client/changePassword/{login}/ {pass}/{newPass} - запросс для смены пароля
 curl --location --request POST ‘http://localhost:8080/client/changePassword/pas/pas/pass'

5)DELETE:http://localhost:8080/client/{login} - удвление позльзователя

6)POST: http://localhost:8080/client/get/{login} - получение JSON с всей его информацией
curl --location --request POST ' http://localhost:8080/client/get/pas' 

7) POST: http://localhost:8080/basket/create/{login} - (требуется совершить вход в аккаунт , 2 пункт ) добавление продукта в продуктовую корзину с помощью json
 curl --location --request POST 'http://localhost:8080/basket/create/pas' \
 --header 'Content-Type: application/json' \
 --data-raw '{
 "title" : "milk",
 "name" : "milk",
 "price" : "234",
  "count" : "1",
  }'
  
  8) DELETE : http://localhost:8080/basket/{login}/{id_product}
-(требуется совершить вход в аккаунт , 2 пункт ) удаление продукта по id
 curl --location --request DELETE 'http://localhost:8080/basket/pas/7' \
 --header 'Content-Type: application/json' \
 --data-raw '{
 "title" : "milk",
 "name" : "mmm",
 "price" : "192" ,
 "count":"93"
}’
 9) DELETE :  http://localhost:8080/basket/{login}/all -
(требуется совершить вход в аккаунт , 2 пункт ) удаление всех продуктов
 curl --location --request DELETE ' http://localhost:8080/basket/
 pas/all' \
 --header 'Content-Type: application/json' \
 --data-raw '{
 "title" : "milk",
 "name" : "mmm",
 "price" : "192" ,
 "count":"93"
}’
