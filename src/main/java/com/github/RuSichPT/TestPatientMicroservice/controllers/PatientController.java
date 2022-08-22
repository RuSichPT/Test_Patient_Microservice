package com.github.RuSichPT.TestPatientMicroservice.controllers;

import com.github.RuSichPT.TestPatientMicroservice.entities.Patient;
import com.github.RuSichPT.TestPatientMicroservice.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @PostMapping
    public void insertPatient(@RequestBody Patient order)
    {
        patientService.insert(order);
    }

    @GetMapping(path = "{id}")
    public Patient selectPatient(@PathVariable int id)
    {
        Patient patient = patientService.select(id);

        if (patient == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return patient;
    }

    @GetMapping(path = "{firstName}/{midName}/{lastName}")
    public Patient selectPatient(@PathVariable String firstName, @PathVariable String midName, @PathVariable String lastName)
    {
        Patient patient = patientService.select(firstName, midName, lastName);

        if (patient == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return patient;
    }

    @PutMapping(path = "{id}")
    public void updatePatient(@PathVariable int id, @RequestBody Patient patient)
    {
        patientService.update(id, patient);
    }

    @DeleteMapping(path = "{id}")
    public void deletePatient(@PathVariable int id)
    {
        patientService.delete(id);
    }
}
