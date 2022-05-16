CREATE TABLE courses(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO courses VALUES (1, 'Kotlin', 'Programação');
INSERT INTO courses VALUES (2, 'Flutter', 'Mobile');
INSERT INTO courses VALUES (3, 'Docker', 'DevOps');