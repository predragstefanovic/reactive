CREATE TABLE orders
(
o_id SERIAL,
c_id CHARACTER VARYING(255),
total BIGINT,
PRIMARY KEY (o_id)
);

CREATE INDEX orders_customer_id ON orders(c_id);