package com.github.RuSichPT.TestPatientMicroservice.services;

import com.github.RuSichPT.TestPatientMicroservice.entities.Patient;

import java.sql.Date;

public interface PatientService {

    void insert(Patient patient);

    Patient select(int id);

    Patient select(String firstName, String midName, String lastName, Date birthday);

    void update(int id, Patient patient);

    void delete(int id);

}
