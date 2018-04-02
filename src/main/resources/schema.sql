CREATE TABLE IF NOT EXISTS Organization (
    id                  INTEGER PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER,
    name                VARCHAR(45) NOT NULL,
    full_name           VARCHAR(45),
    inn                 VARCHAR(45),
    kpp                 VARCHAR(45),
    address             VARCHAR(45),
    phone               VARCHAR(45),
    is_active           BOOLEAN
);

CREATE TABLE IF NOT EXISTS Office (
    id                  INTEGER PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER,
    name                VARCHAR(45),
    phone               VARCHAR(45),
    address             VARCHAR(45),
    is_active           BOOLEAN,
    org_fk              INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS User (
    id                  INTEGER PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER,
    first_name          VARCHAR(45),
    second_name         VARCHAR(45),
    middle_name         VARCHAR(45),
    position            VARCHAR(45),
    phone               VARCHAR(45),
    doc_number          INTEGER,
    doc_date            DATE,
    is_identified       BOOLEAN,
    doc_type_fk         INTEGER NOT NULL,
    office_fk           INTEGER NOT NULL,
    citizenship_type_fk INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS Account (
    id                  INTEGER PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER,
    name                VARCHAR(45),
    login               VARCHAR(45) UNIQUE,
    password            VARCHAR(45),
    activation_code     VARCHAR(45),
    activation_status   BOOLEAN
);

CREATE TABLE IF NOT EXISTS Document (
    doc_code            INTEGER PRIMARY KEY,
    version             INTEGER,
    doc_name            VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS Citizenship (
    country_code        INTEGER PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER,
    country_name        VARCHAR(45)
);


CREATE INDEX Org_Fk ON Office (org_fk);
ALTER TABLE Office ADD FOREIGN KEY (org_fk) REFERENCES Organization(id);

CREATE INDEX Office_Fk ON User (office_fk);
ALTER TABLE User ADD FOREIGN KEY (office_fk) REFERENCES Office(id);

CREATE INDEX Doc_type_fk ON User (doc_type_fk);
ALTER TABLE User ADD FOREIGN KEY (doc_type_fk) REFERENCES Document(doc_code);

CREATE INDEX Citizenship_type_fk ON User (citizenship_type_fk);
ALTER TABLE User ADD FOREIGN KEY (citizenship_type_fk) REFERENCES Citizenship_type(id);