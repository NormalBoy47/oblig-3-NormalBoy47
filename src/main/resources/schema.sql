CREATE TABLE Billett
(
    id INTEGER AUTO_INCREMENT NOT NULL,
    Film VARCHAR(50) NOT NULL,
    Antall INTEGER NOT NULL,
    ForNavn VARCHAR(50) NOT NULL,
    EtterNavn VARCHAR(50) NOT NULL,
    Nummer INTEGER NOT NULL,
    Epost VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);
