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
    is_active           TINYINT(1) DEFAULT 0,
    office_id           INTEGER NOT NULL,
);

CREATE TABLE IF NOT EXISTS Login (
    user_id             INTEGER NOT NULL UNIQUE,
    version             INTEGER NOT NULL,
    login               VARCHAR(45) NOT NULL UNIQUE,
    password            VARCHAR(45) NOT NULL
);

CREATE TABLE IF NOT EXISTS Document (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL,
    doc_name            VARCHAR(45) NOT NULL,
    doc_number          INTEGER NOT NULL,
    doc_date            DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS Citizenship (
    id                  INTEGER  PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL,
    citizenship_name    VARCHAR(45) NOT NULL,
    citizenship_code    INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS User_Document (
    user_id             INTEGER NOT NULL,
    doc_id              INTEGER NOT NULL,
);

CREATE TABLE IF NOT EXISTS User_Citizenship (
    user_id             INTEGER NOT NULL,
    citizenship_id      INTEGER NOT NULL,
);

CREATE INDEX Org_Id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(id);

CREATE INDEX Office_Id ON User (office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX User_id ON Login (user_id);
ALTER TABLE Login ADD FOREIGN KEY (user_id) REFERENCES User(id);

CREATE INDEX User_Document_Id ON User_Document (user_id);
ALTER TABLE User_Document ADD FOREIGN KEY (user_id) REFERENCES User(id);

CREATE INDEX Document_User_Id ON User_Document (doc_id);
ALTER TABLE User_Document ADD FOREIGN KEY (doc_id) REFERENCES Document(id);

CREATE INDEX User_Citizenship_Id ON User_Citizenship (user_id);
ALTER TABLE User_Citizenship ADD FOREIGN KEY (user_id) REFERENCES User(id);

CREATE INDEX Citizenship_User_Id ON User_Citizenship (citizenship_id);
ALTER TABLE User_Citizenship ADD FOREIGN KEY (citizenship_id) REFERENCES Citizenship(id);

