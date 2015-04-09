CREATE TABLE geoip (
    ip varchar(15) NOT NULL,
    added TIMESTAMP DEFAULT NOW(),
    country varchar(255) NOT NULL,
    city varchar(255),
    service varchar(255),
    constraint geoip_pk PRIMARY KEY (ip)
);