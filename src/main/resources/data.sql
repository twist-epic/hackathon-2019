CREATE TABLE users
(
  first_name varchar(20),
  last_name varchar(20),
  email varchar(50),
  password varchar(50),
  PRIMARY KEY(email),
);

INSERT INTO users(first_name, last_name, email, password)
VALUES('Clayton', 'Beyers', 'first.last@target.com', 'myPassword');

INSERT INTO users(first_name, last_name, email, password)
VALUES('Tarah', 'Cleveland', 'first.last@target.com', 'myPassword');
