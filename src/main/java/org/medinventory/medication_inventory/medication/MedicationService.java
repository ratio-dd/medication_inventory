package org.medinventory.medication_inventory.medication;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

//    public List<Medication> findMedicationByName(String name) {
//        return medicationRepository.findByCommonName(name);
//    }

    public Medication getMedicationById(Integer id) {
        return medicationRepository.findById(id).orElse(null);
    }

    public Medication saveMedication(Medication medication) {
        return medicationRepository.save(medication);
    }

    public Integer saveMedicationReturnId(Medication medication) {
        Medication savedMedication = medicationRepository.save(medication);
        return savedMedication.getId();
    }

    public void deleteMedicationById(Integer id) {
        medicationRepository.deleteById(id);
    }


}
   