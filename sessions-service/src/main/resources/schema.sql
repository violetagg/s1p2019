DROP TABLE IF EXISTS sessions;
CREATE TABLE sessions (
    id SERIAL PRIMARY KEY,
    title VARCHAR NOT NULL,
    day VARCHAR NOT NULL,
    timeslot VARCHAR NOT NULL,
    room VARCHAR NOT NULL,
    speakers VARCHAR NOT NULL,
    companies VARCHAR NOT NULL
);