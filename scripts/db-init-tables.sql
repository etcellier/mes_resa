-- Création des tables
CREATE TABLE airplane
(
    airplane_id NUMBER PRIMARY KEY,
    model       VARCHAR2(50) NOT NULL,
    capacity    NUMBER NOT NULL
);

CREATE TABLE flight
(
    flight_id         NUMBER PRIMARY KEY,
    flight_number     VARCHAR2(10) NOT NULL UNIQUE,
    departure_date    DATE   NOT NULL,
    departure_time    VARCHAR2(5) NOT NULL,
    arrival_time      VARCHAR2(5) NOT NULL,
    departure_airport VARCHAR2(50) NOT NULL,
    arrival_airport   VARCHAR2(50) NOT NULL,
    airplane_id       NUMBER NOT NULL,
    CONSTRAINT fk_airplane
        FOREIGN KEY (airplane_id)
            REFERENCES airplane (airplane_id)
);

CREATE TABLE passenger
(
    passenger_id NUMBER PRIMARY KEY,
    first_name   VARCHAR2(50) NOT NULL,
    last_name    VARCHAR2(50) NOT NULL,
    birthdate    DATE NOT NULL
);

CREATE TABLE reservation
(
    reservation_id   NUMBER PRIMARY KEY,
    reservation_date DATE   NOT NULL,
    flight_id        NUMBER NOT NULL,
    passenger_id     NUMBER NOT NULL,
    seat_number      VARCHAR2(5) NOT NULL,
    CONSTRAINT fk_flight
        FOREIGN KEY (flight_id)
            REFERENCES flight (flight_id),
    CONSTRAINT fk_passenger
        FOREIGN KEY (passenger_id)
            REFERENCES passenger (passenger_id)
);
