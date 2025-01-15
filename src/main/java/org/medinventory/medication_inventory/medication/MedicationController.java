package org.medinventory.medication_inventory.medication;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/medication")
public class MedicationController {
    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping(path = "/get")
    public List<Medication> getAllMedication() {
        return medicationService.getAllMedications();
    }

    @PostMapping(path = "/post")
    public Integer saveMedicationReturnId(@RequestBody Medication medication) {
        return medicationService.saveMedicationReturnId(medication);
    }

    @GetMapping(path = "/get", params = "id")
    public Medication getMedicationById(@RequestParam("id") Integer id) {
        return medicationService.getMedicationById(id);
    }

}
