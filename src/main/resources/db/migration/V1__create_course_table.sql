CREATE TABLE course(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO course VALUES (1, 'Kotlin', 'Programação');
INSERT INTO course VALUES (2, 'Flutter', 'Mobile');
INSERT INTO course VALUES (3, 'Docker', 'DevOps');