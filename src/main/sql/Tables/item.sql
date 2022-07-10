CREATE TABLE item (
    item_id INT AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    upload_date DATE NOT NULL DEFAULT (CURRENT_DATE()),
    stock INT NOT NULL DEFAULT 0,
    for_sale BOOL NOT NULL DEFAULT 0,
    price INT NOT NULL DEFAULT 0,
    description VARCHAR(1500),
    categories SET(
        '1', -- Clothing, Shoes, Jewelry & Watches
        '2', -- Books
        '3', -- Movies, Music & Games
        '4', -- Electronics
        '5', -- Computers
        '6', -- Smart Home
        '7', -- Home, Garden & Tools
        '8', -- Pet Supplies
        '9', -- Food & Grocery
        '10', -- Beauty & Health
        '11', -- Toys, Kids & Baby
        '12', -- Handmande
        '13', -- Sports
        '14', -- Outdoors
        '15', -- Automotive & Industrial
        '16' -- Industrial and Scientific
    ) NOT NULL,
    thumbnail MEDIUMBLOB,

    CONSTRAINT PK__item_id PRIMARY KEY (item_id),
    CONSTRAINT stock_min CHECK (stock >= 0),
    CONSTRAINT price_min CHECK (price >= 0),
    CONSTRAINT thumbnail_max_size CHECK (OCTET_LENGTH(thumbnail) <= 2100000)
);
