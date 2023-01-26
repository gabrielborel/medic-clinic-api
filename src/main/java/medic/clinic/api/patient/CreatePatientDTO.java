package medic.clinic.api.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import medic.clinic.api.address.CreateAddressDTO;

public record CreatePatientDTO(
   @NotBlank
   String name,
   @NotBlank
   @Email
   String email,
   @NotBlank
   String cellphone,
   @NotBlank
   @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
   String cpf,
   @NotNull @Valid
   CreateAddressDTO address
) {
}