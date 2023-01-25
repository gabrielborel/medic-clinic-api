package medic.clinic.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
   private String street;
   private String district;
   private String code;
   private String number;
   private String complement;
   private String city;
   private String state;

   public Address(CreateAddressDTO data) {
      this.street = data.street();
      this.district = data.district();
      this.code = data.code();
      this.number = data.number();
      this.complement = data.complement();
      this.city = data.city();
      this.state = data.state();
   }
}
