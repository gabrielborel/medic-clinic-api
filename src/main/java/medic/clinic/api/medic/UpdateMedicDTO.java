package medic.clinic.api.medic;

import jakarta.validation.constraints.NotNull;
import medic.clinic.api.address.CreateAddressDTO;

public record UpdateMedicDTO(
   @NotNull
   Long id,
   String name,
   String cellphone,
   CreateAddressDTO address
) {
}
