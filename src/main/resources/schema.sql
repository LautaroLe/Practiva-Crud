DROP TABLE IF EXISTS users;
CREATE TABLE users (
 id INT PRIMARY KEY,
 nombre VARCHAR(250) NOT NULL,
 apellido VARCHAR(250) NOT NULL,
 email VARCHAR(250) NOT NULL
)