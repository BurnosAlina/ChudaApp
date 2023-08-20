CREATE TABLE user_role
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE user_info
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50)         NOT NULL,
    last_name  VARCHAR(50)         NOT NULL,
    email      VARCHAR(100) UNIQUE NOT NULL,
    password   VARCHAR(255)        NOT NULL,
    role_id    BIGINT,
    FOREIGN KEY (role_id) REFERENCES user_role (id)
);

CREATE TABLE expense
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    date        DATE NOT NULL,
    description VARCHAR(100) NOT NULL,
    amount      FLOAT NOT NULL
);

CREATE TABLE income
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    date        DATE NOT NULL,
    description VARCHAR(100) NOT NULL,
    amount      FLOAT NOT NULL
);

CREATE TABLE product
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        varchar(50) NOT NULL,
    amount      FLOAT NOT NULL
);

