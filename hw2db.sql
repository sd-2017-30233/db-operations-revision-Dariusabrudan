use hw2;
CREATE TABLE course (
  `idcourse` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `teacher` varchar(45) NOT NULL,
  `studyyear` int(11) NOT NULL,
  PRIMARY KEY (`idcourse`));
CREATE TABLE student (
  `idstudent` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `birthdate` date NOT NULL,
  `address` varchar(45) NOT NULL,
  PRIMARY KEY (`idstudent`));
CREATE TABLE enrolment (
  `idenrolment` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idstudent` int(11) unsigned NOT NULL,
  `idcourse` int(11) unsigned NOT NULL,
  `enrolmentdate` date NOT NULL,
  PRIMARY KEY (`idenrolment`),
  FOREIGN KEY (`idstudent`) REFERENCES student1(`idstudent`),
  FOREIGN KEY (`idcourse`) REFERENCES course1(`idcourse`));
