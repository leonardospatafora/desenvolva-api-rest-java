package med.voll.api.models;

import lombok.NonNull;
import med.voll.api.entities.Doctor;
import med.voll.api.enums.Expertise;

public record ListDoctorData(Long id, String nome, String email, String crm, Expertise expertise) {

    public ListDoctorData(@NonNull final Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getExpertise());
    }

}
