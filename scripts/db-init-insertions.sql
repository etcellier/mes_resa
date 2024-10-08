-- Insertion des avions
INSERT INTO airplane (model, capacity)
VALUES ('FGA Airbus A320', 180);
INSERT INTO airplane (model, capacity)
VALUES ('FGB Boeing 737', 150);
INSERT INTO airplane (model, capacity)
VALUES ('FGC Boeing 737', 150);

-- Insertion des vols à l'aide d'une procédure stockée
CREATE
OR REPLACE PROCEDURE init_flights_for_next_month AS
    v_start_date DATE := TO_DATE('01-10-2024', 'DD-MM-YYYY');
    v_end_date
DATE := ADD_MONTHS(v_start_date, 1);
    v_day
DATE;
    v_jour_semaine
VARCHAR2(10);

    TYPE
flight_record IS RECORD (
        flight_number VARCHAR2(10),
        departure_time VARCHAR2(5),
        arrival_time VARCHAR2(5),
        departure_airport VARCHAR2(50),
        arrival_airport VARCHAR2(50),
        airplane_model VARCHAR2(50)
    );

    TYPE
flight_table IS TABLE OF flight_record;
    v_flights
flight_table;

BEGIN
    v_day
:= v_start_date;

    WHILE
v_day <= v_end_date LOOP
        v_jour_semaine := RTRIM(LOWER(TO_CHAR(v_day, 'Day', 'NLS_DATE_LANGUAGE=FRENCH')));

CASE v_jour_semaine
            WHEN 'lundi' THEN
                v_flights := flight_table(
                    flight_record('AF1234', '08:00', '12:00', 'Lyon', 'Luxor', 'FGA Airbus A320'),
                    flight_record('AF1235', '16:00', '20:00', 'Luxor', 'Lyon', 'FGA Airbus A320'),
                    flight_record('AF2347', '10:15', '11:45', 'Munich', 'Vienne', 'FGB Boeing 737'),
                    flight_record('AF2351', '14:00', '15:30', 'Vienne', 'Bruxelles', 'FGB Boeing 737'),
                    flight_record('AF3456', '08:00', '09:00', 'Lyon', 'Nantes', 'FGC Boeing 737')
                );
WHEN 'mardi' THEN
                v_flights := flight_table(
                    flight_record('AF2345', '06:00', '07:00', 'Lyon', 'Paris', 'FGB Boeing 737'),
                    flight_record('AF2346', '08:00', '09:30', 'Paris', 'Munich', 'FGB Boeing 737'),
                    flight_record('AF2352', '17:00', '18:30', 'Bruxelles', 'Madrid', 'FGB Boeing 737'),
                    flight_record('AF2353', '19:45', '21:20', 'Madrid', 'Lyon', 'FGB Boeing 737'),
                    flight_record('AF2355', '13:00', '14:30', 'Vienne', 'Rome', 'FGB Boeing 737'),
                    flight_record('AF2356', '17:00', '18:30', 'Rome', 'Lyon', 'FGB Boeing 737')
                );
WHEN 'mercredi' THEN
                v_flights := flight_table(
                    flight_record('AF2345', '06:00', '07:00', 'Lyon', 'Paris', 'FGB Boeing 737'),
                    flight_record('AF2346', '08:00', '09:30', 'Paris', 'Munich', 'FGB Boeing 737'),
                    flight_record('AF2347', '10:15', '11:45', 'Munich', 'Vienne', 'FGB Boeing 737'),
                    flight_record('AF2351', '14:00', '15:30', 'Vienne', 'Bruxelles', 'FGB Boeing 737'),
                    flight_record('AF2352', '17:00', '18:30', 'Bruxelles', 'Madrid', 'FGB Boeing 737')
                );
WHEN 'jeudi' THEN
                v_flights := flight_table(
                    flight_record('AF1234', '08:00', '12:00', 'Lyon', 'Luxor', 'FGA Airbus A320'),
                    flight_record('AF1235', '16:00', '20:00', 'Luxor', 'Lyon', 'FGA Airbus A320'),
                    flight_record('AF2345', '06:00', '07:00', 'Lyon', 'Paris', 'FGB Boeing 737'),
                    flight_record('AF2346', '08:00', '09:30', 'Paris', 'Munich', 'FGB Boeing 737'),
                    flight_record('AF2353', '19:45', '21:20', 'Madrid', 'Lyon', 'FGB Boeing 737'),
                    flight_record('AF2355', '13:00', '14:30', 'Vienne', 'Rome', 'FGB Boeing 737'),
                    flight_record('AF3467', '09:45', '17:30', 'Nantes', 'Punta Cana', 'FGC Boeing 737'),
                    flight_record('AF3463', '12:00', '16:00', 'Punta Cana', 'Nantes', 'FGC Boeing 737')
                );
WHEN 'vendredi' THEN
                v_flights := flight_table(
                    flight_record('AF1234', '08:00', '12:00', 'Lyon', 'Luxor', 'FGA Airbus A320'),
                    flight_record('AF1235', '16:00', '20:00', 'Luxor', 'Lyon', 'FGA Airbus A320'),
                    flight_record('AF2346', '08:00', '09:30', 'Paris', 'Munich', 'FGB Boeing 737'),
                    flight_record('AF2347', '10:15', '11:45', 'Munich', 'Vienne', 'FGB Boeing 737'),
                    flight_record('AF2352', '17:00', '18:30', 'Bruxelles', 'Madrid', 'FGB Boeing 737'),
                    flight_record('AF2353', '19:45', '21:20', 'Madrid', 'Lyon', 'FGB Boeing 737'),
                    flight_record('AF2355', '13:00', '14:30', 'Vienne', 'Rome', 'FGB Boeing 737'),
                    flight_record('AF3464', '17:00', '18:00', 'Nantes', 'Lyon', 'FGC Boeing 737')
                );
ELSE
                v_flights := flight_table();
END
CASE;

FOR i IN 1..v_flights.COUNT LOOP
            INSERT INTO flight (flight_number, departure_date, departure_time, arrival_time, departure_airport, arrival_airport, airplane_id)
            VALUES (
                v_flights(i).flight_number,
                v_day,
                v_flights(i).departure_time,
                v_flights(i).arrival_time,
                v_flights(i).departure_airport,
                v_flights(i).arrival_airport,
                (SELECT airplane_id FROM airplane WHERE model = v_flights(i).airplane_model)
            );
END LOOP;

        v_day
:= v_day + 1;
END LOOP;

END;
/
