package com.github.RuSichPT.TestParientMicroservice.services;

import com.github.RuSichPT.TestParientMicroservice.entities.Patient;

public interface PatientService {

    void insert(Patient patient);

    Patient select(int id);

    Patient select(String firstName, String midName, String lastName);

    void update(int id, Patient patient);

    void delete(int id);

}
