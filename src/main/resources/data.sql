CREATE TABLE users
(
  first_name varchar(20),
  last_name varchar(20),
  email varchar(50),
  password varchar(50),
  house_number int,
  street_name varchar(100),
  city varchar(50),
  state varchar(20),
  zip_code int,
  PRIMARY KEY(email),
);

CREATE TABLE purchases
(
  title varchar(100),
  tcin int,
  brand varchar(100),
  price double,
  quantity int,
  email varchar(50),
  PRIMARY KEY(tcin),
);

INSERT INTO users(first_name, last_name, email, password, house_number, street_name, city, state, zip_code )
VALUES('Clayton', 'Beyers', 'clayton.beyers@target.com', 'myPassword', 1234 , 'myStreetName', 'myCity', 'myState', 90210);

INSERT INTO users(first_name, last_name, email, password, house_number, street_name, city, state, zip_code )
VALUES('Tarah', 'Cleveland', 'tarah.cleveland@target.com', 'myPassword', 1234 , 'myStreetName', 'myCity', 'myState', 12345);

INSERT INTO purchases(title, tcin, brand, price, quantity, email)
VALUES ('gummy worms', 13245450, 'Market Pantry', .99, 12, 'clayton.beyers@target.com');