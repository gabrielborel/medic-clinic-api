package medic.clinic.api.medic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import medic.clinic.api.address.CreateAddressDTO;

public record CreateMedicDTO(
   @NotBlank
   String name,
   @NotBlank @Email
   String email,
   @NotBlank @Pattern(regexp = "\\d{4,6}")
   String crm,
   @NotNull
   MedicSpecialty specialty,
   @NotNull @Valid
   CreateAddressDTO address
) {
}
