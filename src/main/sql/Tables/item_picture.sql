CREATE TABLE item_picture (
    picture_id INT AUTO_INCREMENT,
    item_id INT,
    picture MEDIUMBLOB,

    CONSTRAINT PK__picture_id PRIMARY KEY (picture_id),
    CONSTRAINT FK__item_picture__item FOREIGN KEY (item_id) REFERENCES item(item_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT picture_max_size CHECK (OCTET_LENGTH(picture) <= 2100000)
);