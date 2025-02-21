package med.voll.api.models;

import jakarta.validation.constraints.NotNull;

public record UpdateDoctorData(
        @NotNull
        Long id,
        String name,
        String phoneNumber,
        AddressData addressData) {
}
