

DROP TRIGGER IF EXISTS financefolio.bill_addition;


DELIMITER $
CREATE TRIGGER bill_addition BEFORE INSERT ON bill
FOR EACH ROW 
BEGIN
	DECLARE id SMALLINT UNSIGNED ;
    INSERT INTO expense(description, addition_date, cost) VALUES('',CURDATE(),NEW.cost);
	SELECT MAX(expense_id) INTO id FROM expense;
    SET NEW.bill_id = id;
    IF(NEW.dateTo is NULL) THEN
        SET NEW.dateTo = DATE_ADD(NEW.dateFrom, INTERVAL 1 MONTH); 
    END IF;

END$

DELIMITER ;