CREATE TABLE IF NOT EXISTS messages (
    id                     VARCHAR(60)  DEFAULT RANDOM_UUID() PRIMARY KEY,
    text                   VARCHAR      NOT NULL
);

INSERT INTO messages (id, text) values ('1', 'Mensagem 1');