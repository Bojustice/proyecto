CREATE TABLE if NOT EXISTS roles(
    id SERIAL,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    rol INT NOT NULL,
    PRIMARY KEY (id)
);