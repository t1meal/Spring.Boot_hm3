BEGIN;

DROP TABLE IF EXISTS buyers CASCADE;
CREATE TABLE buyers
(
    id   bigserial PRIMARY KEY,
    name VARCHAR(255)
);
INSERT INTO buyers (name)
VALUES ('Alexandr'),
       ('Mihail');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255),
    cost  int
);
INSERT INTO products (title, cost)
VALUES ('milk', 79),
       ('bread', 24),
       ('butter', 220),
       ('cheese', 350),
       ('coca-cola', 69);

DROP TABLE IF EXISTS buyers_products CASCADE;
CREATE TABLE buyers_products
(
    buyer_id   bigint,
    product_id bigint,
    FOREIGN KEY (buyer_id) REFERENCES buyers (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);
INSERT INTO buyers_products (buyer_id, product_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 3),
       (2, 4),
       (2, 5);
COMMIT;