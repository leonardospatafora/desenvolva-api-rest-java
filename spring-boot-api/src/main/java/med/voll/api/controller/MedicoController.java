package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.entities.Doctor;
import med.voll.api.models.ListDoctorData;
import med.voll.api.models.MedicalData;
import med.voll.api.models.UpdateDoctorData;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void singUp(@RequestBody @Valid final MedicalData medicalData) {
        repository.save(new Doctor(medicalData));
    }

    @GetMapping
    public Page<ListDoctorData> list(@PageableDefault(size = 10, sort = {"name"}) final Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(ListDoctorData::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid final UpdateDoctorData updateDoctorData) {
        var medico = repository.getReferenceById(updateDoctorData.id());
        medico.updateInfos(updateDoctorData);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable final Long id) {
        var medico = repository.getReferenceById(id);
        medico.exclude();
    }


}
