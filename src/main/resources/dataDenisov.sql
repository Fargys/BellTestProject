INSERT INTO Document (id, version, doc_name, doc_number, doc_date) 
VALUES (1, 0, 'Passport', 10, '2018-03-05');

INSERT INTO Citizenship (id, version, citizenship_name, citizenship_code) 
VALUES (1, 0, 'Russia', 10);

INSERT INTO Organization (id, version, name, fullName, inn, kpp, address, phone, is_active) 
VALUES (1, 0, 'MC', 'MacDonalds corp.', 0123456789 , 012345678, 'Red Place', '8(911) 123-34-45', 1);

INSERT INTO Office (id, version, name, phone, is_active, org_id) 
VALUES (1, 0, 'Something office name', '8(911) 543-34-45', 1, 1);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, is_active, office_id, doc_id, citizenship_id) 
VALUES (1, 0, 'Walter', 'White', 'Hartwell' , 'manager' , '8(911) 737-35-25', 1, 1, 1, 1)