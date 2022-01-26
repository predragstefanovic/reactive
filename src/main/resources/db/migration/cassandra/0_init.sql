CREATE TABLE people(
  city text,
  lastname text,
  firstname text,
  email text,
  employment text,
  PRIMARY KEY ((city), lastname, firstname, email))
  WITH CLUSTERING ORDER BY (lastName ASC, firstname ASC, email ASC);