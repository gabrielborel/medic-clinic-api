package medic.clinic.api.medic;

import medic.clinic.api.address.CreateAddressDTO;

public record CreateMedicDTO(String name, String email, String crm, MedicSpecialty specialty, CreateAddressDTO address) {
}
