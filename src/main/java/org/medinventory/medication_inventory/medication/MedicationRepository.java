package org.medinventory.medication_inventory.medication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MedicationRepository
        extends JpaRepository<Medication, Integer>, JpaSpecificationExecutor<Medication> {
    List<Medication> findByCommonName(String name);
}