package med.voll.api.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import med.voll.api.models.AddressData;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String addressLine;
    private String district;
    private String zipCode;
    private String number;
    private String complement;
    private String city;
    private String state;

    public Address(@NonNull final AddressData addressData) {
        this.addressLine = addressData.streetAddress();
        this.district = addressData.district();
        this.zipCode = addressData.zipcode();
        this.state = addressData.state();
        this.city = addressData.city();
        this.number = addressData.number();
        this.complement = addressData.complement();
    }

    public void atualizarInformacoes(@NonNull final AddressData addressData) {
        if (addressData.streetAddress() != null) {
            this.addressLine = addressData.streetAddress();
        }
        if (addressData.district() != null) {
            this.district = addressData.district();
        }
        if (addressData.zipcode() != null) {
            this.zipCode = addressData.zipcode();
        }
        if (addressData.state() != null) {
            this.state = addressData.state();
        }
        if (addressData.city() != null) {
            this.city = addressData.city();
        }
        if (addressData.number() != null) {
            this.number = addressData.number();
        }
        if (addressData.complement() != null) {
            this.complement = addressData.complement();
        }
    }
}
