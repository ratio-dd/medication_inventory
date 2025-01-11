package org.medinventory.medication_inventory.repository;

import org.medinventory.medication_inventory.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedicationRepository extends JpaRepository<Medication, Integer> , JpaSpecificationExecutor<Medication> {
  }