package medic.clinic.api.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medic.clinic.api.address.Address;

@Entity(name = "Patient")
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Patient {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String cellphone;
   private String email;
   private String cpf;
   @Embedded
   private Address address;
   private boolean active;

   public Patient(CreatePatientDTO data) {
      this.name = data.name();
      this.email = data.email();
      this.cpf = data.cpf();
      this.address = new Address(data.address());
      this.cellphone = data.cellphone();
      this.active = true;
   }
}
