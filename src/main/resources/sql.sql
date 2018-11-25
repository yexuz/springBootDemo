CREATE TABLE `book` (
                      `id` bigint(20) NOT NULL AUTO_INCREMENT,
                      `reader` varchar(20) DEFAULT NULL,
                      `isbn` varchar(20) DEFAULT NULL,
                      `title` varchar(20) DEFAULT NULL,
                      `author` varchar(20) DEFAULT NULL,
                      `description` varchar(200) DEFAULT NULL,
                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `reader` (
                        `username` varchar(20) NOT NULL DEFAULT '',
                        `fullname` varchar(20) DEFAULT NULL,
                        `password` varchar(20) DEFAULT NULL,
                        PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
                      `id` varchar(20) NOT NULL DEFAULT '',
                      `username` varchar(20) DEFAULT NULL,
                      `password` varchar(20) DEFAULT NULL,
                      `address` varchar(50) DEFAULT NULL,
                      `phone` varchar(20) DEFAULT NULL,
                      `slat` varchar(20) DEFAULT NULL,
                      `enable` tinyint(2) DEFAULT NULL,
                      `createDate` datetime DEFAULT NULL,
                      `updateDate` datetime DEFAULT NULL,
                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

