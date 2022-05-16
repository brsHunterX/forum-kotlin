CREATE TABLE users(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password TEXT NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO users VALUES (1, 'Bruno Santos', 'bruno.santos@gmail.com', '$2a$12$zmKze9kN/ActvixuH1xlm.uWcmbs9DhX17jwaBk6GxPSCQ3bRbjWi');
INSERT INTO users VALUES (2, 'Pedro Santos', 'pedro.santos@gmail.com', '$2a$12$zmKze9kN/ActvixuH1xlm.uWcmbs9DhX17jwaBk6GxPSCQ3bRbjWi');
INSERT INTO users VALUES (3, 'Sandra Maria', 'sandra.maria@gmail.com', '$2a$12$zmKze9kN/ActvixuH1xlm.uWcmbs9DhX17jwaBk6GxPSCQ3bRbjWi');