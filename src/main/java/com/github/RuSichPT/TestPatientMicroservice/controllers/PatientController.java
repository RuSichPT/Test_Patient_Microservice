package com.github.RuSichPT.TestPatientMicroservice.controllers;

import com.github.RuSichPT.TestPatientMicroservice.entities.Patient;
import com.github.RuSichPT.TestPatientMicroservice.services.PatientServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping
    public Patient insertPatient(@RequestBody Patient newPatient)
    {
        Patient oldPatient = patientService.select(newPatient.getFirstName(), newPatient.getMidName(), newPatient.getLastName(), newPatient.getBirthday());
        if (oldPatient == null)
        {
            return patientService.insert(newPatient);
        }
        else
        {
            return oldPatient;
        }
    }

    @GetMapping(path = "{id}")
    public Patient selectPatient(@PathVariable int id)
    {
        Patient patient = patientService.select(id);

        if (patient == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return patient;
    }

    @GetMapping()
    public Patient selectPatient(@RequestParam String firstName, @RequestParam String midName, @RequestParam String lastName, @RequestParam Date birthday)
    {
        Patient patient = patientService.select(firstName, midName, lastName, birthday);

        if (patient == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return patient;
    }

    @PutMapping(path = "{id}")
    public Patient updatePatient(@PathVariable int id, @RequestBody Patient patient)
    {
        return patientService.update(id, patient);
    }

    @DeleteMapping(path = "{id}")
    public void deletePatient(@PathVariable int id)
    {
        patientService.delete(id);
    }
}
