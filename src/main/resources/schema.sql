DROP TABLE IF EXISTS mobile_phones;
CREATE TABLE IF NOT EXISTS mobile_phones
(
    id          SERIAL PRIMARY KEY,
    brand       VARCHAR(64),
    model       VARCHAR(64),
    performance INT,
    price       INT
    );