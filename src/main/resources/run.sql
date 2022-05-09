INSERT INTO `mydb`.`cars` (`manufacture`,`year`) VALUES ("Volvo",1998);
INSERT INTO `mydb`.`cars` (`manufacture`,`year`) VALUES ("BMW",2001);
INSERT INTO `mydb`.`cars` (`manufacture`,`year`) VALUES ("Audi",2010);
INSERT INTO `mydb`.`cars` (`manufacture`,`year`) VALUES ("Lexus",2014);
INSERT INTO `mydb`.`cars` (`manufacture`,`year`) VALUES ("Volkswagen",1991);
INSERT INTO `mydb`.`cars` (`year`) VALUES (2001);
INSERT INTO `mydb`.`cars`(`manufacture`) VALUE ("Peugeot");
INSERT INTO `mydb`.`users`(`name`,`surname`,`email`) VALUES ("John","Pinkman","JP@gmail.com");
INSERT INTO `mydb`.`users`(`name`,`surname`,`email`) VALUES ("Michail","Zelentsov","zelentsov@mail.ru");
INSERT INTO `mydb`.`users`(`name`,`surname`) VALUES ("Tom","Ordy");
INSERT INTO `mydb`.`users`(`name`,`email`) VALUES ("Richard","riod@yandex.ru");
INSERT INTO `mydb`.`users`(`name`,`surname`,`email`) VALUES ("Irina","Kolosova","iror@gmail.com");
INSERT INTO mydb.lifts(manufacture) VALUE ("Johnsway");
INSERT INTO mydb.lifts(manufacture) VALUE ("Slebrity");
INSERT INTO mydb.lifts(manufacture) VALUE ("Krown");
INSERT INTO mydb.compressors(manufacture) VALUE ("JSP");
INSERT INTO mydb.compressors(manufacture,perfomance) VALUE ("JSP",1350);
INSERT INTO mydb.compressors(manufacture,perfomance) VALUE ("Pillow",1700);
INSERT INTO mydb.hydraulic_presses(manufacture) VALUE ("HYDRO");
INSERT INTO mydb.hydraulic_presses(manufacture) VALUE ("Tyres");
INSERT INTO mydb.hydraulic_presses(manufacture) VALUE ("PeakForm");
INSERT INTO mydb.cutters(manufacture) VALUE ("CUT+PRO");
INSERT INTO mydb.cutters(manufacture) VALUE ("Shilo");
INSERT INTO mydb.cutters(manufacture) VALUE ("Joker");
INSERT INTO mydb.tire_changers(manufacture) VALUE ("Tires-plus");
INSERT INTO mydb.tire_changers(manufacture) VALUE ("Titanium");
INSERT INTO mydb.tire_changers(manufacture) VALUE ("Horrors");
INSERT INTO `mydb`.`workers`(`id`,`position`,`experience`,`users_id`)VALUES(1,"Motor Engineer",9,2);
INSERT INTO `mydb`.`workers`(`id`,`position`,`experience`,`users_id`)VALUES(2,"Motor Engineer",9,3);
INSERT INTO `mydb`.`clients`(`id`,`users_id`,`cars_id`)VALUES(1,1,4);
INSERT INTO `mydb`.`clients`(`id`,`users_id`,`cars_id`)VALUES(2,4,2);
INSERT INTO mydb.orders(`name`,`price`,`workers_id`,`clients_id`,`cars_id`) VALUES ("Engine Problem",1900,1,2,1);
INSERT INTO mydb.orders(`name`,`price`,`workers_id`,`clients_id`,`cars_id`) VALUES ("Security problem",2750,2,1,1);
INSERT INTO service_stations(`name`,`address`) VALUES ("THE BEST ONE","Victory's square 14");
INSERT INTO orders_has_service_stations(`orders_id`,`service_Stations_id`) VALUES (1,1);
UPDATE `mydb`.`cars` SET `manufacture` = 'VOLVO (renamed)',`year` = 1998 WHERE`id` = 1;
UPDATE mydb.cars SET manufacture = 'BMW(renamed)', year = 2001 WHERE `id` = 2;
UPDATE mydb.users SET name = 'Petya' WHERE id = 1;
UPDATE mydb.users SET name = 'Nastya' WHERE id = 2;
UPDATE mydb.tire_changers SET manufacture = 'Tire-pluS' WHERE id = 1;
UPDATE mydb.compressors SET manufacture = 'jsp' WHERE id = 1;
UPDATE mydb.cutters SET manufacture = 'cut+pro' WHERE id = 1;
UPDATE mydb.hydraulic_presses SET manufacture = 'Hydro+' WHERE id = 1;
UPDATE mydb.users SET email = 'PJ@gmail.com' WHERE id = 1;
UPDATE mydb.lifts SET manufacture = 'JOHNSWAY' WHERE id = 2;
DELETE FROM `mydb`.`cars` WHERE id = 1;
DELETE FROM mydb.users WHERE id = 1;
DELETE FROM `mydb`.`users` WHERE email = 'PJ@gmail.com';
DELETE FROM mydb.cars WHERE year > 2000;
DELETE FROM mydb.users WHERE name = 'TOM';
DELETE FROM mydb.users WHERE name = 'TOM';
DELETE FROM mydb.users WHERE surname = 'pol';
DELETE FROM mydb.users WHERE name = 'kitten';
DELETE FROM mydb.users WHERE name = 'dog';
DELETE FROM mydb.users WHERE surname = 'coach';

SELECT 
    `users_id`, `cars_id`, `name`, `manufacture`, `year`
FROM
    mydb.clients
        JOIN
    mydb.users ON clients.users_id = users.id
        JOIN
    mydb.cars ON clients.cars_id = cars.id;
ALTER TABLE mydb.clients add age BIGINT(10);
ALTER TABLE mydb.clients add constraint `c1` check (age>=18);
ALTER TABLE mydb.clients MODIFY COLUMN age INT(10);
ALTER TABLE mydb.clients DROP CHECK `c1`;
ALTER TABLE mydb.clients RENAME COLUMN age TO ages;
ALTER TABLE mydb.clients DROP COLUMN ages;

SELECT `users_id`,`cars_id`,`name`,`surname`,`email`,`manufacture`,`year` FROM `clients`
JOIN `cars` ON cars_id=cars.id LEFT JOIN `users` ON users_id=users.id;

SELECT `users_id`,`name`,`position`,`experience` FROM `workers`
RIGHT JOIN `users` ON users_id=users.id;

SELECT `users_id`,users.name,`position`,`experience`,`orders_id`,`price`,orders.name FROM `workers`
INNER JOIN `users` ON users_id=users.id JOIN orders_has_service_stations JOIN orders ON `orders_id`=orders.id;

SELECT 
    orders.name,
    `price`,
    `workers_id`,
    `clients_id`,
    orders.cars_id,
    users.name,
    users.surname,
    users.email,
    cars.manufacture,
    cars.year,
    workers.users_id,
    workers.position,
    users.name
FROM
    orders
        JOIN
    `workers` ON workers_id = workers.id
        JOIN
    `clients` ON clients_id = clients.id
        JOIN
    `cars` ON orders.cars_id = cars.id
        RIGHT JOIN
    `users` ON clients_id = users.id
        AND workers.users_id = users.id;
    
    insert cars (manufacture, year) VALUES ("Volvo",2000);
    SELECT manufacture , COUNT(*) AS Quantity, avg(year) AS Average_year, 
    min(year) AS Min_year, max(year) AS Max_year FROM cars group by manufacture;
    
    
    SELECT SUM(price) AS Revenue FROM orders;
	SELECT name,clients_id,max(price) AS Max_price, 
    min(price) AS Min_price FROM orders group by clients_id,name 
    order by clients_id;
    
    SELECT name,manufacture FROM users JOIN cars 
    
