DROP TABLE IF EXISTS departures;
DROP TABLE IF EXISTS post_offices;

CREATE TABLE post_offices
(
	id        serial PRIMARY KEY,
	name      varchar(45) NOT NULL,
	city_name varchar(45) NOT NULL
);

CREATE TABLE departures
(
	id                       serial PRIMARY KEY,
	type                     varchar(45) NOT NULL,
	date                     varchar(45) NOT NULL,
	departure_post_office_id INT REFERENCES post_offices ( id )
);

INSERT INTO post_offices (name, city_name)
VALUES ('UPS', 'Singapore');
INSERT INTO post_offices (name, city_name)
VALUES ('CDEK', 'Moscow');
INSERT INTO post_offices (name, city_name)
VALUES ('FedEx', 'New York');


INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Train', '2022-01-31', 2);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Aircraft', '2022-04-21', 2);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Aircraft', '2022-11-30', 3);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Truck', '2022-02-22', 1);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Truck', '2023-01-31', 1);
