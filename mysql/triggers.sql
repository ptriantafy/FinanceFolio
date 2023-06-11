

DROP TRIGGER IF EXISTS financefolio.bill_addition;


DELIMITER $
CREATE TRIGGER financefolio.bill_addition BEFORE INSERT ON bill
FOR EACH ROW 
BEGIN
	DECLARE id SMALLINT UNSIGNED ;
    INSERT INTO expense(description,expense_category, addition_date, cost) VALUES('','Bill',CURDATE(),NEW.cost);
	SELECT MAX(expense_id) INTO id FROM expense;
    SET NEW.bill_id = id;
    IF(NEW.dateTo is NULL) THEN
        SET NEW.dateTo = DATE_SUB(NEW.dateFrom, INTERVAL 2 MONTH); 
    END IF;

END$

DELIMITER ;

DROP TRIGGER IF EXISTS financefolio.misc_addition;


DELIMITER $
CREATE TRIGGER financefolio.misc_addition BEFORE INSERT ON miscellaneous
FOR EACH ROW 
BEGIN
	DECLARE id SMALLINT UNSIGNED ;
    INSERT INTO expense(expense_name,description,expense_category, addition_date, cost) VALUES(new.misc_exp_name,'','Miscellaneous',CURDATE(),NEW.cost);
	SELECT MAX(expense_id) INTO id FROM expense;
    SET NEW.misc_id = id;
END$

DELIMITER ;

DROP TRIGGER IF EXISTS financefolio.misc_micro_exp_addition;


DELIMITER $
CREATE TRIGGER financefolio.misc_micro_exp_addition AFTER INSERT ON misc_micro_expenses
FOR EACH ROW 
BEGIN

    DECLARE cost_sum DECIMAL(10,2);

    SELECT cost INTO cost_sum FROM miscellaneous WHERE misc_id = NEW.parent_expense_id;

    
    UPDATE miscellaneous
    SET miscellaneous.cost = cost_sum + NEW.cost
    WHERE misc_id = NEW.parent_expense_id;

 
    UPDATE expense
    SET expense.cost = cost_sum + NEW.cost
    WHERE expense_id = NEW.parent_expense_id;


    
END$

DELIMITER ;

DROP TRIGGER IF EXISTS financefolio.subscription_addition;


DELIMITER $
CREATE TRIGGER financefolio.subscription_addition BEFORE INSERT ON subscription
FOR EACH ROW 
BEGIN
	DECLARE id SMALLINT UNSIGNED ;
    INSERT INTO expense(expense_name, description,expense_category, addition_date, cost) VALUES(new.sub_name,'','Subscription',CURDATE(),NEW.cost);
	SELECT MAX(expense_id) INTO id FROM expense;
    SET NEW.subscription_id = id;
END$

DELIMITER ;