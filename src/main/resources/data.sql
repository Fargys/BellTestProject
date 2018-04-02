--Document--
INSERT INTO Document (doc_code, version,doc_name) 
VALUES (10, 0, 'Passport');

INSERT INTO Document (doc_code, version,doc_name) 
VALUES (15, 0, 'Driver license');

--Citizenship--
INSERT INTO Citizenship (country_code, version, country_name) 
VALUES (10, 0, 'Russia');

INSERT INTO Citizenship (country_code, version, country_name) 
VALUES (15, 0, 'Ukraine');

--Organization--
INSERT INTO Organization (version, name, full_name, inn, kpp, address, phone, is_active) 
VALUES (0, 'MC', 'MacDonalds corp.', 0123456789 , 012345678, 'Red Place', '8(911) 123-34-45', true);

INSERT INTO Organization (version, name, full_name, inn, kpp, address, phone, is_active) 
VALUES (0, 'Google', 'Google corp.', 9876543210 , 876543210, 'Somewhere street', '8(911) 321-43-54', false);

--Office--
INSERT INTO Office (version, name, phone, address, is_active, org_fk) 
VALUES (0, 'Office #1', '8(911) 543-34-45', 'Office #1 address', true, 1);

INSERT INTO Office (version, name, phone, address, is_active, org_fk) 
VALUES (0, 'Office #2', '8(911) 345-43-54', 'Office #2 address', false, 2);

--User--
INSERT INTO User (version, first_name, second_name, middle_name, position, phone, doc_number, doc_date, is_identified, doc_type_fk, office_fk, citizenship_type_fk) 
VALUES (0, 'Walter', 'White', 'Hartwell' , 'Cook' , '8(911) 737-35-25', 1234567, '2018-03-15', true, 10, 1, 10);

INSERT INTO User (version, first_name, second_name, middle_name, position, phone, doc_number, doc_date, is_identified, doc_type_fk, office_fk, citizenship_type_fk) 
VALUES (0, 'Jesse', 'Pinkman', 'Bruce' , 'Cook assistant' , '8(911) 373-53-52', 7654321, '2011-09-22', false, 15, 2, 15);

--Account--
INSERT INTO Account (version, name, login, password, activation_code, activation_status)
VALUES (0, 'Walter', 'heisenberg@gmail.com', 'qwerty', 'somecode #1' , true);

INSERT INTO Account (version, name, login, password, activation_code, activation_status)
VALUES (0, 'Jesse', 'whatsup@gmail.com', '123456', 'somecode #2' , false);

