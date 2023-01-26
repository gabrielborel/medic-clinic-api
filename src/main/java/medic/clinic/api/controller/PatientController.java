package medic.clinic.api.controller;

import medic.clinic.api.patient.CreatePatientDTO;
import medic.clinic.api.patient.Patient;
import medic.clinic.api.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {
   @Autowired
   private PatientRepository repository;

   @PostMapping
   @Transactional
   public void create(@RequestBody CreatePatientDTO data) {
      System.out.println(data);
      repository.save(new Patient(data));
   }
}
