DROP USER IF EXISTS 'FinanceFolioJava'@'localhost';
CREATE USER 'FinanceFolioJava'@'localhost' IDENTIFIED BY 'FinFolJavPass';

GRANT ALL ON financefolio.* TO 'FinanceFolioJava'@'localhost'; 
