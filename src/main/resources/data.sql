CREATE TABLE users
(
  first_name varchar(20),
  last_name varchar(20),
  email varchar(50),
  password varchar(50),
  address varchar(50),
  PRIMARY KEY(email),
);

INSERT INTO users(first_name, last_name, email, password, address)
VALUES('Clayton', 'Beyers', 'clayton.beyers@target.com', 'myPassword', '545 Pioneer Tr, Chaska, MN 55318');

INSERT INTO users(first_name, last_name, email, password, address)
VALUES('Tarah', 'Cleveland', 'tarah.cleveland@target.com', 'myPassword', '545 Pioneer Tr, Chaska, MN 55318');