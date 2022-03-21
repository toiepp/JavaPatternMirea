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
VALUES ('Meedoo', 'Dongxin');
INSERT INTO post_offices (name, city_name)
VALUES ('Yodo', 'Buk');
INSERT INTO post_offices (name, city_name)
VALUES ('Edgeify', 'Boulogne-Billancourt');
INSERT INTO post_offices (name, city_name)
VALUES ('Quatz', 'Marseille');
INSERT INTO post_offices (name, city_name)
VALUES ('Yamia', 'Novovladykino');
INSERT INTO post_offices (name, city_name)
VALUES ('Agivu', 'Shazi');
INSERT INTO post_offices (name, city_name)
VALUES ('Shufflester', 'Erandique');
INSERT INTO post_offices (name, city_name)
VALUES ('Chatterbridge', 'Xiaozhi');
INSERT INTO post_offices (name, city_name)
VALUES ('Shuffletag', 'Ballyboden');
INSERT INTO post_offices (name, city_name)
VALUES ('Topicware', 'Ombarade');
INSERT INTO post_offices (name, city_name)
VALUES ('Meemm', 'Suishan');
INSERT INTO post_offices (name, city_name)
VALUES ('Bubblebox', 'Calidñgan');
INSERT INTO post_offices (name, city_name)
VALUES ('Mudo', 'Mayantoc');
INSERT INTO post_offices (name, city_name)
VALUES ('Quaxo', 'Bol’shoye Selo');
INSERT INTO post_offices (name, city_name)
VALUES ('Babbleopia', 'Tchamba');
INSERT INTO post_offices (name, city_name)
VALUES ('Oyope', 'Attard');
INSERT INTO post_offices (name, city_name)
VALUES ('Brainsphere', 'Changkeng');
INSERT INTO post_offices (name, city_name)
VALUES ('Rhynoodle', 'Phanna Nikhom');
INSERT INTO post_offices (name, city_name)
VALUES ('Vidoo', 'Šumice');
INSERT INTO post_offices (name, city_name)
VALUES ('Linktype', 'Adamstown');


INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Dablist', '29-09-2022', 9);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Skyvu', '26-10-2022', 17);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Jabbersphere', '09-11-2022', 11);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Voomm', '16-08-2022', 4);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Brainverse', '20-09-2022', 9);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Bubblebox', '14-08-2022', 6);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Livetube', '18-07-2022', 11);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Voomm', '29-08-2022', 20);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Flashspan', '01-06-2022', 20);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Jabberstorm', '15-07-2022', 9);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('LiveZ', '08-07-2022', 14);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Ailane', '16-12-2022', 15);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Yakitri', '30-01-2022', 8);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Flipopia', '08-06-2022', 14);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Yombu', '10-01-2022', 19);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Eabox', '14-09-2022', 18);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Browsebug', '24-04-2022', 7);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Brainbox', '01-04-2022', 12);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Aimbu', '22-01-2022', 11);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Podcat', '18-07-2022', 10);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Browsebug', '27-10-2022', 11);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Oyoyo', '28-11-2022', 17);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Riffpath', '08-05-2022', 6);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Npath', '26-03-2022', 10);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Yodo', '01-08-2022', 11);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Jaxspan', '27-11-2022', 8);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Bubblemix', '23-02-2022', 1);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Livetube', '18-05-2022', 5);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Ailane', '09-02-2022', 10);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Voonyx', '16-04-2022', 15);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Yotz', '07-01-2022', 18);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Topicware', '07-08-2022', 14);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Yakijo', '14-07-2022', 9);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Trudeo', '24-02-2022', 17);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Topdrive', '16-11-2022', 19);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Dynabox', '23-02-2022', 13);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Fiveclub', '26-09-2022', 3);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Gigazoom', '18-05-2022', 11);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Skibox', '06-04-2022', 12);
INSERT INTO departures (type, date, departure_post_office_id)
VALUES ('Divavu', '25-09-2022', 6);


SELECT * from departures;
