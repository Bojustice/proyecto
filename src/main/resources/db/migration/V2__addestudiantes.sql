CREATE TABLE if NOT EXISTS estudiantes(
    id SERIAL,
    roles_id INT NOT NULL,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_roles
    FOREIGN KEY (roles_id)
    REFERENCES roles(id)
);