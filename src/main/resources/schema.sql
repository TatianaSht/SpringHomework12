CREATE TABLE IF NOT EXISTS users (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    age INT,
    email varchar(50)
);

INSERT INTO users (name, age, email) VALUES
('Pavel', 28, 'pavel@gmail.com'),
('Semen', 31, 'semen@gmail.com'),
('Dmitriy', 40, 'dmitriy@gmail.com');