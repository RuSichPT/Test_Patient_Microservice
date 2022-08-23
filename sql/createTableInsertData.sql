-- PATIENT
CREATE SEQUENCE patient_SEQ INCREMENT BY 1;
CREATE TABLE "patient"
(
    ID INTEGER PRIMARY KEY,
    FIRST_NAME VARCHAR(64),
    MID_NAME VARCHAR(64),
    LAST_NAME VARCHAR(64),
    GENDER_ID SMALLINT,
    BIRTHDAY DATE,
    PHONE VARCHAR(24),
    EMAIL VARCHAR(32),
    ADDRESS VARCHAR(128)
);

INSERT INTO "patient" (ID, FIRST_NAME, MID_NAME, LAST_NAME,
                       GENDER_ID, BIRTHDAY, PHONE, EMAIL, ADDRESS)
VALUES (NEXTVAL('patient_seq'), 'Павел', 'Андреевич', 'Токарев',
                        1, '12.07.1996', '+7952558****', 'tokarev*********@mail.ru', 'Воронеж'),
        (NEXTVAL('patient_seq'), 'Василий', 'Андреевич', 'Уткин',
                        1, '13.09.1998', '+7952558****', 'utkin*********@mail.ru', 'Москва');

INSERT INTO \"patient\" +
            "(ID, FIRST_NAME, MID_NAME, LAST_NAME, GENDER_ID, BIRTHDAY, PHONE, EMAIL, ADDRESS) " +
VALUES +
            "(NEXTVAL('patient_seq'), ${firstName}, ${midName}, ${lastName}, ${genderId}, ${birthday}, ${phone}, ${email}, ${address});"