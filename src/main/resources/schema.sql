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
    mobile_phone_id INT,
    FOREIGN KEY (mobile_phone_id)
        REFERENCES mobile_phones (id)
);