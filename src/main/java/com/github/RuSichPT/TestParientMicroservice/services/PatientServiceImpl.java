package com.github.RuSichPT.TestParientMicroservice.services;

import com.github.RuSichPT.TestParientMicroservice.entities.Patient;
import com.github.RuSichPT.TestParientMicroservice.mappers.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    public PatientMapper patientMapper;
    @Override
    public void insert(Patient patient) {
        patientMapper.insert(patient);
    }

    @Override
    public Patient select(int id) {
        return patientMapper.selectById(id);
    }

    @Override
    public Patient select(String firstName, String midName, String lastName) {
        return patientMapper.selectByName(firstName, midName, lastName);
    }

    @Override
    public void update(int id, Patient newPatient) {
        Patient oldPatient = patientMapper.selectById(id);

        if (id != newPatient.getId() || (oldPatient == null))
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        patientMapper.update(newPatient);
    }

    @Override
    public void delete(int id) {
        patientMapper.delete(id);
    }
}
