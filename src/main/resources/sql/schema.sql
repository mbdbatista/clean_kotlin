CREATE TABLE IF NOT EXISTS messages (
    id                     VARCHAR(60)  DEFAULT RANDOM_UUID() AUTO_INCREMENT PRIMARY KEY,
    text                   VARCHAR      NOT NULL
);

CREATE TABLE IF NOT EXISTS category (
    id                     INTEGER AUTO_INCREMENT PRIMARY KEY,
    name                   VARCHAR NOT NULL
);