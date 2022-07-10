CREATE TABLE purchase (
    purchase_id INT AUTO_INCREMENT,
    item_id INT,
    purchaser_id INT,
    purchase_date DATE NOT NULL DEFAULT (CURRENT_DATE()),

    CONSTRAINT PK__purchase_id PRIMARY KEY (purchase_id),
    CONSTRAINT FK__purchase__item FOREIGN KEY (item_id) REFERENCES item(item_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT FK__purchase__user FOREIGN KEY (purchaser_id) REFERENCES user(user_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);