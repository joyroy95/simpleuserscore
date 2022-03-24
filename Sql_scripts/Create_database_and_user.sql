create database simpleuserscore;

CREATE USER 'simpleuserscore'@'localhost' IDENTIFIED BY 'simpleuserscore';

GRANT ALL PRIVILEGES ON * . * TO 'simpleuserscore'@'localhost';

ALTER USER 'simpleuserscore'@'localhost' IDENTIFIED WITH mysql_native_password BY 'simpleuserscore';