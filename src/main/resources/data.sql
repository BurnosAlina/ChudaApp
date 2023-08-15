INSERT INTO user_role (id, name, description)
VALUES
    (1, 'ROLE_Admin', 'Administrator role'),
    (2, 'ROLE_Manager', 'Regular user role'),
    (3, 'ROLE_User', 'Regular user role');

INSERT INTO user_info (first_name, last_name, email, password, role_id)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '{noop}pass1', 1),
    ('Jane', 'Doe', 'jane.doe@example.com', '{noop}pass2', 2),
    ('Bob', 'Smith', 'bob.smith@example.com', '{noop}pass3', 3);

INSERT INTO expense (date, description, amount)
VALUES
    ('2023-07-02', 'zakupy', 22.5),
    ('2023-07-05', 'mieszkanie', 1515),
    ('2023-07-06', 'media', 284);

INSERT INTO income (date, description, amount)
VALUES
    ('2023-07-02', 'wypłata', 4500),
    ('2023-07-05', 'zwrot z podatku', 1515),
    ('2023-07-06', 'Bartek oddał', 284);