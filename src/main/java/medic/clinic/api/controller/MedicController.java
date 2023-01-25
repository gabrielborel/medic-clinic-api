package medic.clinic.api.controller;

import jakarta.validation.Valid;
import medic.clinic.api.medic.CreateMedicDTO;
import medic.clinic.api.medic.ListMedicDTO;
import medic.clinic.api.medic.Medic;
import medic.clinic.api.medic.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medics")
public class MedicController {
   @Autowired
   private MedicRepository repository;

   @PostMapping
   @Transactional
   public void create(@RequestBody @Valid CreateMedicDTO data) {
      repository.save(new Medic(data));
   }

   @GetMapping
   public List<ListMedicDTO> list() {
      return repository
         .findAll()
         .stream()
         .map(ListMedicDTO::new)
         .toList();
   }
}
