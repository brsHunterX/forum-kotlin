CREATE TABLE user(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO user VALUES (1, 'Bruno Santos', 'bruno.santos@gmail.com');
INSERT INTO user VALUES (2, 'Pedro Santos', 'pedro.santos@gmail.com');
INSERT INTO user VALUES (3, 'Sandra Maria', 'sandra.maria@gmail.com');