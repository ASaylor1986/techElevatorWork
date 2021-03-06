START TRANSACTION;

DROP TABLE IF EXISTS customer_purchases;
DROP TABLE IF EXISTS art;
DROP TABLE IF EXISTS artists;
DROP TABLE IF EXISTS customers;


CREATE TABLE customers
(
    customerId int GENERATED BY DEFAULT AS IDENTITY,
    firstName varchar(64) NOT NULL,
    lastName varchar(64) NOT NULL,
    address varchar(256) NOT NULL,
    phone varchar(14),

    CONSTRAINT pk_customers PRIMARY KEY (customerId)
);

CREATE TABLE artists
(
    artistId int GENERATED BY DEFAULT AS IDENTITY,
    firstName varchar(64) NOT NULL,
    lastName varchar(64) NOT NULL,

    CONSTRAINT pk_artists PRIMARY KEY (artistId)
);

CREATE TABLE art
(
    artCode varchar(4) NOT NULL,
    title varchar(128) NOT NULL,
    artistId int NOT NULL,

    CONSTRAINT pk_art PRIMARY KEY (artCode),
    CONSTRAINT fk_art_artists FOREIGN KEY (artistId) REFERENCES artists (artistId)

);

CREATE TABLE customer_purchases
(
    customerId int NOT NULL,
    artCode varchar(4) NOT NULL,
    purchaseDate date NOT NULL,
    price numeric(2) NOT NULL,

    CONSTRAINT pk_customer_purchases PRIMARY KEY (customerId, artCode, purchaseDate),
    CONSTRAINT fk_customer_purchases_customer FOREIGN KEY (customerId) REFERENCES customers (customerId),
    CONSTRAINT fk_customer_purchases_art FOREIGN KEY (artCode) REFERENCES art (artCode)
);


INSERT INTO artists (firstName, lastName)
VALUES ('Rick', 'Steves'), ('Carol', 'Channing'), ('Dennis', 'Frings');

INSERT INTO art (artCode, title, artistId)
VALUES ('LWT', 'Laughing with Teeth',
        (SELECT artistId FROM artists WHERE firstName = 'Carol' AND lastName = 'Channing'));

COMMIT TRANSACTION;


