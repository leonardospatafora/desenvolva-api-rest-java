package med.voll.api.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import med.voll.api.enums.Expertise;
import med.voll.api.models.MedicalData;
import med.voll.api.models.UpdateDoctorData;

@Table(name = "medicos")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    private String phoneNumber;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Expertise expertise;

    @Embedded
    private Address address;

    private Boolean active;

    public Doctor(@NonNull final MedicalData medicalData) {
        this.active = true;
        this.name = medicalData.name();
        this.email = medicalData.email();
        this.phoneNumber = medicalData.phoneNumber();
        this.crm = medicalData.crm();
        this.expertise = medicalData.expertise();
        this.address = new Address(medicalData.address());
    }

    public void updateInfos(@NonNull final UpdateDoctorData updateDoctorData) {
        if (updateDoctorData.name() != null) {
            this.name = updateDoctorData.name();
        }
        if (updateDoctorData.phoneNumber() != null) {
            this.phoneNumber = updateDoctorData.phoneNumber();
        }
        if (updateDoctorData.addressData() != null) {
            this.address.atualizarInformacoes(updateDoctorData.addressData());
        }

    }

    public void exclude() {
        this.active = false;
    }
}
