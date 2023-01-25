package medic.clinic.api.medic;

public record ListMedicDTO(
   String name,
   String email,
   String crm,
   MedicSpecialty specialty
) {
   public ListMedicDTO(Medic medic) {
      this(
         medic.getName(),
         medic.getEmail(),
         medic.getCrm(),
         medic.getSpecialty()
      );
   }
}
