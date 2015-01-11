CREATE TABLE `user` (
  `userId` int(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `userTel` varchar(20) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


INSERT INTO `user`.`user` (`userId`, `userName`, `password`, `userTel`) VALUES ('1', 'admin', 'admin', '13666666666');