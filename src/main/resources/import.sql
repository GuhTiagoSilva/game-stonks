INSERT INTO tb_role (role) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (role) VALUES ('ROLE_PLAYER');

INSERT INTO tb_user (username, email, password, role_id) VALUES ('Alex', 'alex@gmail.com', '1234567', 1);
INSERT INTO tb_user (username, email, password, role_id) VALUES ('Maria', 'maria@gmail.com', '1234567', 2);