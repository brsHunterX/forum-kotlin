CREATE TABLE answer(
    id BIGINT NOT NULL AUTO_INCREMENT,
    message TINYTEXT NOT NULL,
    created_at DATETIME NOT NULL,
    is_soluction BOOL DEFAULT FALSE NOT NULL,
    topic_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(topic_id) REFERENCES topic(id),
    FOREIGN KEY(author_id) REFERENCES user(id)
)