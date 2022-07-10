CREATE TABLE user (
    user_id INT AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password_hash VARCHAR(72) NOT NULL,
    password_salt VARCHAR(70) NOT NULL,
    email VARCHAR(50) NOT NULL,

    CONSTRAINT PK__user_id PRIMARY KEY (user_id),
    CONSTRAINT username_min_length CHECK ((CHAR_LENGTH(username)) >= 2),
    CONSTRAINT email_unique UNIQUE (email)
); 