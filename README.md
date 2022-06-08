1. Создать БД, записать данные в application.properties
2. Добавить в БД роли:
   insert into roles (id,name) values (1, 'ROLE_USER');
   insert into roles (id,name) values (2, 'ROLE_ADMIN');
3. Добавить первого пользователя(можно через AuthController.registeUser() или инсертом)
4. Выполнить команду mvn spring-boot:run