CREATE TABLE orders
(
o_id int,
c_id character varying(255),
total numeric,
PRIMARY KEY (o_id)
);

CREATE INDEX orders_customer_id ON orders(c_id);