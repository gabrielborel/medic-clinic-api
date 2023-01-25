package medic.clinic.api.controller;

import medic.clinic.api.medic.CreateMedicDTO;
import medic.clinic.api.medic.Medic;
import medic.clinic.api.medic.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medics")
public class MedicController {
   @Autowired
   private MedicRepository repository;

   @PostMapping
   public void create(@RequestBody CreateMedicDTO data) {
      repository.save(new Medic(data));
   }
}
