CREATE TABLE roles(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO roles VALUES (1, 'Student');