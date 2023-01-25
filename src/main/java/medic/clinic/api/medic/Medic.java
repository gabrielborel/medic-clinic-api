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
   private String cellphone;
   private String crm;
   private boolean active;
   @Enumerated(EnumType.STRING)
   private MedicSpecialty specialty;
   @Embedded
   private Address address;

   public Medic(CreateMedicDTO data) {
      this.name = data.name();
      this.email = data.email();
      this.crm = data.crm();
      this.cellphone = data.cellphone();
      this.specialty = data.specialty();
      this.address = new Address(data.address());
      this.active = true;
   }

   public void updateInfo(UpdateMedicDTO data) {
      if (data.name() != null) {
         this.name = data.name();
      }

      if (data.cellphone() != null) {
         this.cellphone = data.cellphone();
      }

      if (data.address() != null) {
         this.address.updateInfo(data.address());
      }
   }

   public void inactivate() {
      this.active = false;
   }
}
