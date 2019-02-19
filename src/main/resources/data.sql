CREATE TABLE users
(
  first_name varchar(20),
  last_name varchar(20),
  email varchar(50),
  password varchar(50),
  street_address varchar (140),
  city varchar (100),
  state varchar (10),
  zip_code int,
  PRIMARY KEY(email),
);

INSERT INTO users(first_name, last_name, email, password, street_address, city, state, zip_code)
VALUES('Clayton', 'Beyers', 'clayton.beyers@target.com', 'myPassword', '3115 Golden Valley', 'Golden Valley', 'MN', 55422);

INSERT INTO users(first_name, last_name, email, password, street_address, city, state, zip_code)
VALUES('Tarah', 'Cleveland', 'tarah.cleveland@target.com', 'myPassword', '3115 Golden', 'Beverly Hills', 'CA', 90210);