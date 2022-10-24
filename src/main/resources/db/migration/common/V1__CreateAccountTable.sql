CREATE TABLE account
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR           NOT NULL,
    last_name  VARCHAR           NOT NULL,
    birthdate  DATE              NOT NULL,
    balance    NUMERIC DEFAULT 0 NOT NULL
);
