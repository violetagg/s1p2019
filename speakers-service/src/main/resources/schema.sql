DROP TABLE IF EXISTS speakers;
CREATE TABLE speakers (
    id SERIAL PRIMARY KEY,
    firstname VARCHAR NOT NULL,
    lastname VARCHAR NOT NULL
);