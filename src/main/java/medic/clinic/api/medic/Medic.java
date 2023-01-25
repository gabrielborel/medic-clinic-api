package medic.clinic.api.medic;

import jakarta.persistence.*;
import lombok.*;
import medic.clinic.api.address.Address;

@Entity(name = "Medic")
@Table(name = "medics")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Medic {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String email;
   private String crm;
   @Enumerated(EnumType.STRING)
   private MedicSpecialty specialty;
   @Embedded
   private Address address;

   public Medic(CreateMedicDTO data) {
      this.name = data.name();
      this.email = data.email();
      this.crm = data.crm();
      this.specialty = data.specialty();
      this.address = new Address(data.address());
   }
}
