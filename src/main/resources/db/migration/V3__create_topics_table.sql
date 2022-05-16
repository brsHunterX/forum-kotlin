CREATE TABLE topics(
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    message TINYTEXT NOT NULL,
    created_at DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    course_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(course_id) REFERENCES courses(id),
    FOREIGN KEY(author_id) REFERENCES users(id)
)