package com.github.RuSichPT.TestPatientMicroservice.services;

import com.github.RuSichPT.TestPatientMicroservice.entities.Patient;
import com.github.RuSichPT.TestPatientMicroservice.mappers.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;

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
    public Patient select(String firstName, String midName, String lastName, Date birthday) {
        return patientMapper.selectByName(firstName, midName, lastName, birthday);
    }

    @Override
    public void update(int id, Patient newPatient) {
        Patient oldPatient = patientMapper.selectById(id);

        if (oldPatient == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else if (newPatient.equals(oldPatient))
        {
            return;
        }

        patientMapper.update(newPatient);
    }

    @Override
    public void delete(int id) {
        patientMapper.delete(id);
    }
}
