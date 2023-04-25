CREATE TABLE category (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(200),
     description VARCHAR(1000)
);

CREATE TABLE offer (
     id INT AUTO_INCREMENT PRIMARY KEY,
     title VARCHAR(200),
     description VARCHAR(1000),
     img_url VARCHAR(10000),
     price DECIMAL(10,2),
     category_id VARCHAR(30)
);