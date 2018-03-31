INSERT INTO Document_type (id, version, doc_code, doc_name) 
VALUES (1, 0, 10, 'Passport');

INSERT INTO Citizenship_type (id, version, citizenship_code, citizenship_name) 
VALUES (1, 0, 10, 'Russia');

INSERT INTO Document (id, version, doc_number, doc_date, doc_type) 
VALUES (1, 0, '2134568990', '2018-03-05', 1);

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active) 
VALUES (1, 0, 'MC', 'MacDonalds corp.', 0123456789 , 012345678, 'Red Place', '8(911) 123-34-45', 1);

INSERT INTO Office (id, version, name, phone, is_active, org_id) 
VALUES (1, 0, 'Something office name', '8(911) 543-34-45', 1, 1);

INSERT INTO Login (id, version, login, password)
VALUES (1, 0, 'heisenberg', 'qwerty');

INSERT INTO User (id, version, first_name, second_name, middle_name, position, 
        phone, is_identified, office_id, doc_id, citizenship_id, account_id) 
VALUES (1, 0, 'Walter', 'White', 'Hartwell' , 'manager' , '8(911) 737-35-25', 1, 1, 1, 1, 1);

