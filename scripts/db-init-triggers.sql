-- Trigger pour la table airplane
CREATE
OR REPLACE TRIGGER trg_airplane_id
BEFORE INSERT ON airplane
FOR EACH ROW
BEGIN
    IF
:NEW.airplane_id IS NULL THEN
SELECT airplane_seq.NEXTVAL
INTO :NEW.airplane_id
FROM dual;
END IF;
END;
/

-- Trigger pour la table flight
CREATE
OR REPLACE TRIGGER trg_flight_id
BEFORE INSERT ON flight
FOR EACH ROW
BEGIN
    IF
:NEW.flight_id IS NULL THEN
SELECT flight_seq.NEXTVAL
INTO :NEW.flight_id
FROM dual;
END IF;
END;
/

-- Trigger pour la table passenger
CREATE
OR REPLACE TRIGGER trg_passenger_id
BEFORE INSERT ON passenger
FOR EACH ROW
BEGIN
    IF
:NEW.passenger_id IS NULL THEN
SELECT passenger_seq.NEXTVAL
INTO :NEW.passenger_id
FROM dual;
END IF;
END;
/

-- Trigger pour la table reservation
CREATE
OR REPLACE TRIGGER trg_reservation_id
BEFORE INSERT ON reservation
FOR EACH ROW
BEGIN
    IF
:NEW.reservation_id IS NULL THEN
SELECT reservation_seq.NEXTVAL
INTO :NEW.reservation_id
FROM dual;
END IF;
END;
/
