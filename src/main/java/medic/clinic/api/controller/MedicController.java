package medic.clinic.api.controller;

import jakarta.validation.Valid;
import medic.clinic.api.medic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
   public Page<ListMedicDTO> list(@PageableDefault(size = 10) Pageable pagination) {
      return repository
         .findAll(pagination)
         .map(ListMedicDTO::new);
   }

   @PutMapping
   @Transactional
   public void update(@RequestBody @Valid UpdateMedicDTO data) {
      var medic = repository.getReferenceById(data.id());
      medic.updateInfo(data);
   }

   @DeleteMapping("/{id}")
   @Transactional
   public void delete(@PathVariable Long id) {
      var medic = repository.getReferenceById(id);
      medic.inactivate();
   }
}
