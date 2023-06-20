INSERT INTO `auth-service`.`roles` (id, name)
    VALUES (1, 'ADMIN')
    ON DUPLICATE KEY UPDATE id = 1;

INSERT INTO `auth-service`.`roles` (id, name)
    VALUES (2, 'USER')
    ON DUPLICATE KEY UPDATE id = 2;