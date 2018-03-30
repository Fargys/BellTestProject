CREATE TABLE IF NOT EXISTS Organization (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL,
    name                VARCHAR(45) NOT NULL,
    fullName            VARCHAR(45) NOT NULL,
    inn                 INTEGER NOT NULL,
    kpp                 INTEGER NOT NULL,
    address             VARCHAR(45) NOT NULL,
    phone               VARCHAR(45) NOT NULL,
    is_active           TINYINT(1) DEFAULT 0
);

CREATE TABLE IF NOT EXISTS Office (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL,
    name                VARCHAR(45) NOT NULL,
    phone               VARCHAR(45) NOT NULL,
    is_active           TINYINT(1) DEFAULT 0,
    org_id              VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS User (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL,
    first_name          VARCHAR(45) NOT NULL,
    second_name         VARCHAR(45) NOT NULL,
    middle_name         VARCHAR(45) NOT NULL,
    position            VARCHAR(45) NOT NULL,
    phone               VARCHAR(45) NOT NULL,
    is_identified       TINYINT(1) DEFAULT 0,
    office_id           INTEGER NOT NULL,
    doc_id              INTEGER NOT NULL,
    citizenship_id      INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS Login (
    user_id             INTEGER NOT NULL UNIQUE,
    version             INTEGER NOT NULL,
    login               VARCHAR(45) NOT NULL UNIQUE,
    password            VARCHAR(45) NOT NULL,
    activation_code      VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS Document (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL,
    doc_number          INTEGER NOT NULL,
    doc_date            DATE NOT NULL, 
    doc_type            VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Document_type (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL,
    doc_code            INTEGER NOT NULL,
    doc_name            VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Citizenship_type (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL,
    citizenship_code    INTEGER NOT NULL,
    citizenship_name    VARCHAR(45) NOT NULL
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

