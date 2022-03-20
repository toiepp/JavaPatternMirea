DROP TABLE IF EXISTS departures;
DROP TABLE IF EXISTS post_offices;

CREATE TABLE departures
(
	id   serial PRIMARY KEY,
	type varchar(45) NOT NULL,
	date varchar(45) NOT NULL
);

CREATE TABLE post_offices
(
	id        serial PRIMARY KEY,
	name      varchar(45) NOT NULL,
	city_name varchar(45) NOT NULL
);

INSERT INTO departures (type, date)
VALUES ('Train', '2022-01-31');
INSERT INTO departures (type, date)
VALUES ('Aircraft', '2022-04-21');
INSERT INTO departures (type, date)
VALUES ('Aircraft', '2022-11-30');
INSERT INTO departures (type, date)
VALUES ('Truck', '2022-02-22');
INSERT INTO departures (type, date)
VALUES ('Truck', '2023-01-31');


INSERT INTO post_offices (name, city_name)
VALUES ('UPS', 'Singapore');
INSERT INTO post_offices (name, city_name)
VALUES ('CDEK', 'Moscow');
INSERT INTO post_offices (name, city_name)
VALUES ('FedEx', 'New York');