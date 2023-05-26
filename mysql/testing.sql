


INSERT INTO bill(bill_type, cost, dateFrom, dateTo) VALUES ('water', 10, curdate() ,NULL);

INSERT INTO miscellaneous(misc_exp_name) VALUES ('groceries');

INSERT INTO misc_micro_expenses(parent_expense_id, micro_expense_name, cost) VALUES (2, 'milk', 1.2);
INSERT INTO misc_micro_expenses(parent_expense_id, micro_expense_name, cost) VALUES (2, 'apples', 2.2);
INSERT INTO misc_micro_expenses(parent_expense_id, micro_expense_name, cost) VALUES (2, 'beef', 11.0);
INSERT INTO misc_micro_expenses(parent_expense_id, micro_expense_name, cost) VALUES (2, 'chocolate', 3.5);
INSERT INTO misc_micro_expenses(parent_expense_id, micro_expense_name, cost) VALUES (2, 'beer', 2.6);
INSERT INTO misc_micro_expenses(parent_expense_id, micro_expense_name, cost) VALUES (2, 'tomatoes', 1.0);