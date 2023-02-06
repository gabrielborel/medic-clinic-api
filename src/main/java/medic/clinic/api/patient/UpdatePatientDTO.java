package medic.clinic.api.patient;

import jakarta.validation.constraints.NotNull;
import medic.clinic.api.address.CreateAddressDTO;

public record UpdatePatientDTO(
   @NotNull
   Long id,
   String name,
   String cellphone,
   CreateAddressDTO address
) {
}
