BEGIN;

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
COMMIT;