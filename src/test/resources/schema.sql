DROP TABLE IF EXISTS provincia;
DROP TABLE IF EXISTS user;

CREATE table provincia (id INTEGER PRIMARY KEY ,
                        nombre VARCHAR(100) NOT NULL ,
                        pais_id INTEGER);
INSERT INTO provincia (id, nombre, pais_id) VALUES (1, 'Buenos Aires', 1);
INSERT INTO provincia (id, nombre, pais_id) VALUES (2, 'Mendoza', 1);
INSERT INTO provincia (id, nombre, pais_id) VALUES (5, 'San Luis', 1);

CREATE table user (id INTEGER PRIMARY KEY ,
                   username VARCHAR(100),
                   password VARCHAR(100));
INSERT INTO user (id, username, password) VALUES (1, 'Julian', 'asd123');
INSERT INTO user (id, username, password) VALUES (2, 'Pepe', 'asd123');