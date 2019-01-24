CREATE TABLE users
(
  first_name varchar(20),
  last_name varchar(20),
  email varchar(50),
  password varchar(50),
  address varchar(200),
  PRIMARY KEY(email),
);

INSERT INTO users(first_name, last_name, email, password, address)
VALUES('Clayton', 'Beyers', 'clayton.beyers@target.com', 'myPassword', '1234 Street Ave, Town, MN 12345');

INSERT INTO users(first_name, last_name, email, password, address)
VALUES('Tarah', 'Cleveland', 'tarah.cleveland@target.com', 'myPassword', '1234 Street Ave, Town, MN 12345');

INSERT INTO users(first_name, last_name, email, password, address)
VALUES('Avni', 'Cleveland', 'tarah.cleveland@gmail.com', 'myPassword', '1234 Street Ave, Town, MN 12345');