DROP TABLE IF EXISTS mobile_phone_store;
DROP TABLE IF EXISTS stores;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS mobile_phones;
CREATE TABLE IF NOT EXISTS mobile_phones
(
    id          SERIAL PRIMARY KEY,
    brand       VARCHAR(30),
    model       VARCHAR(30),
    performance INT,
    price       INT
);
CREATE TABLE IF NOT EXISTS users
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(20),
    surname         VARCHAR(20),
    age             INT,
    users_mobile_phone_id INT,
    FOREIGN KEY (users_mobile_phone_id)
        REFERENCES mobile_phones (id)
);
CREATE TABLE stores
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(15)
);
CREATE TABLE mobile_phone_store
(
    store_id        INT,
    mobile_phone_id INT,
    FOREIGN KEY (store_id) REFERENCES stores (id),
    FOREIGN KEY (mobile_phone_id) REFERENCES mobile_phones (id)
);