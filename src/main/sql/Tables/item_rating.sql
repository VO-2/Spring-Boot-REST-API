CREATE TABLE item_rating (
    rating_id INT AUTO_INCREMENT,
    item_id INT,
    rater_id INT,
    rating TINYINT(1) NOT NULL,

    CONSTRAINT PK__rating_id PRIMARY KEY (rating_id),
    CONSTRAINT FK__item_rating__item FOREIGN KEY (item_id) REFERENCES item(item_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT FK__item_rating__user FOREIGN KEY (rater_id) references user(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT rating_range CHECK (1 <= rating && rating <= 5)
);