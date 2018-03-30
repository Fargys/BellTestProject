CREATE TABLE IF NOT EXISTS Organization (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER,
    name                VARCHAR(45),
    fullName            VARCHAR(45),
    inn                 INTEGER,
    kpp                 INTEGER,
    address             VARCHAR(45),
    phone               VARCHAR(45),
    is_active           TINYINT(1) DEFAULT 0
);

CREATE TABLE IF NOT EXISTS Office (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER,
    name                VARCHAR(45),
    phone               VARCHAR(45),
    is_active           TINYINT(1) DEFAULT 0,
    org_id              VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS User (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER,
    first_name          VARCHAR(45),
    second_name         VARCHAR(45),
    middle_name         VARCHAR(45),
    position            VARCHAR(45),
    phone               VARCHAR(45),
    is_identified       TINYINT(1) DEFAULT 0,
    office_id           INTEGER,
    doc_id              INTEGER,
    citizenship_id      INTEGER
);

CREATE TABLE IF NOT EXISTS Login (
    user_id             INTEGER UNIQUE,
    version             INTEGER ,
    login               VARCHAR(45) UNIQUE,
    password            VARCHAR(45),
    activation_code      VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS Document (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER,
    doc_number          INTEGER,
    doc_date            DATE, 
    doc_type            VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS Document_type (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER,
    doc_code            INTEGER,
    doc_name            VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS Citizenship_type (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER,
    citizenship_code    INTEGER,
    citizenship_name    VARCHAR(45)
);


CREATE INDEX Org_Id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(id);

CREATE INDEX Office_Id ON User (office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX Doc_id ON User (doc_id);
ALTER TABLE User ADD FOREIGN KEY (doc_id) REFERENCES Document(id);

CREATE INDEX Citizenship_id ON User (citizenship_id);
ALTER TABLE User ADD FOREIGN KEY (citizenship_id) REFERENCES Citizenship_type(id);

CREATE INDEX User_id ON Login (user_id);
ALTER TABLE Login ADD FOREIGN KEY (user_id) REFERENCES User(id);

CREATE INDEX Doc_type ON Document (doc_type);
ALTER TABLE Document ADD FOREIGN KEY (doc_type) REFERENCES Document_type(id);

