package medic.clinic.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateAddressDTO(
   @NotBlank
   String street,
   @NotBlank
   String district,
   @NotBlank @Pattern(regexp = "\\d{8}")
   String code,
   @NotBlank
   String city,
   @NotBlank
   String state,
   String number,
   String complement) {
}
