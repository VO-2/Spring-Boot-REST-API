CREATE TABLE category_mapping (
    category_id TINYINT(3),
    category VARCHAR(75) NOT NULL UNIQUE,

    CONSTRAINT PK__category_id PRIMARY KEY (category_id)
);

INSERT INTO category_mapping (category_id, category) VALUES
 (1, "Clothing, Shoes, Jewelry & Watches"),
 (2, "Books"),
 (3, "Movies, Music & Games"),
 (4, "Electronics"),
 (5, "Computers"),
 (6, "Smart Home"),
 (7, "Home, Garden & Tools"),
 (8, "Pet Supplies"),
 (9, "Food & Grocery"),
 (10,"Beauty & Health"),
 (11,"Toys, Kids & Baby"),
 (12,"Handmande"),
 (13,"Sports"),
 (14,"Outdoors"),
 (15,"Automotive & Industrial"),
 (16,"Industrial and Scientific");