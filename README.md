# respoBank

Kendimi geliştirmek için başladığım ve ufak tefek hatalarımın olduğu bir proje.
Bazı yerleri bilmediğimden dolayı ve güzel bir kaynak bulamadığımdan dolayı karmaşık oldu

Hata veya bunu şu şekilde daha iyi ve stabil yapabilirsin dediğiniz yerler var ise bana ulaşmayı unutmayınız ^^
Discord adresim: respect lol#2018

Son olarak **star** atarak bana destek çıkabilirsin ^^

# Schema script

```
CREATE SCHEMA `respoBank` ;
CREATE TABLE `respoBank`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `age` VARCHAR(4) NOT NULL,
  `money` DOUBLE NOT NULL,
  `phoneNumber` VARCHAR(24) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`iduser`));
