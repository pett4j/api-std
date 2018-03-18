create database IF NOT EXISTS skipthedishes;
create user 'springuser'@'localhost' identified by 'skipuser'; 
grant all on db_example.* to 'springuser'@'localhost';