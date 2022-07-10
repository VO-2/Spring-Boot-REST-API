CREATE TABLE item_review (
    review_id INT AUTO_INCREMENT,
    item_id INT,
    author_id INT,
    review_text VARCHAR(1000) NOT NULL,

    CONSTRAINT PK__review_id PRIMARY KEY (review_id),
    CONSTRAINT FK__item_review__item FOREIGN KEY (item_id) REFERENCES item(item_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT FK__item_review__user FOREIGN KEY (author_id) REFERENCES user(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);