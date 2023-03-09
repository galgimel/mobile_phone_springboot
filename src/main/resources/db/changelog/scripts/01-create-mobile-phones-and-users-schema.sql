-- CREATE TABLE ADDRESSES
-- (
--     ID SERIAL PRIMARY KEY,
--     STREET VARCHAR(30) NOT NULL,
--     CITY VARCHAR(30),
--     PIN INT
-- );
-- CREATE TABLE USERS
-- (
--     ID SERIAL PRIMARY KEY,
--     NAME VARCHAR(30) NOT NULL,
--     EMAIL VARCHAR(30),
--     PHONE INT,
--     ADDRESS INT NOT NULL,
--     FOREIGN KEY(ADDRESS) REFERENCES ADDRESSES(ID)
-- );
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