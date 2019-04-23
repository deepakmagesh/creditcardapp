INSERT INTO `role` (`role_id`, `role`)
VALUES
(1,'ADMIN');
INSERT INTO `user` (`user_id`, `username`, `password`)
VALUES
(1000,'admin','admin');
INSERT INTO `user_role` (`user_id`, `role_id`)
VALUES
(1000,1);
