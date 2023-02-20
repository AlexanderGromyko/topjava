DELETE FROM meals;
DELETE FROM user_role;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (datetime, description, calories, user_id)
VALUES ('2023-02-18 09:30:00-00', 'Завтрак', '1000', '100000'),
       ('2023-02-19 14:15:00-00', 'Обед', '1200', '100000'),
       ('2023-02-19 18:50:00-00', 'Ужин', '400', '100000'),
       ('2023-02-20 10:00:00-00', 'Завтрак', '700', '100001'),
       ('2023-02-20 13:00:00-00', 'Обед', '1500', '100001'),
       ('2023-02-20 19:00:00-00', 'Ужин', '150', '100001');