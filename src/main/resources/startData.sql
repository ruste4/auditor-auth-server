INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

INSERT INTO users (login, pass, firstname,lastname) VALUES ('anton', '123', 'Антон', 'Иванов');
INSERT INTO users (login, pass, firstname,lastname) VALUES ('ivan', '456', 'Иван', 'Антонов');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 1);
