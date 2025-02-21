package med.voll.api.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
        @NotBlank
        String streetAddress,
        @NotBlank
        String district,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zipcode,
        @NotBlank
        String city,
        @NotBlank
        String state,
        String complement,
        String number) {
}
