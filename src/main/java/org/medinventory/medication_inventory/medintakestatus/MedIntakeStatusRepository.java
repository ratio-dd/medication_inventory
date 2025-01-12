package org.medinventory.medication_inventory.medintakestatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedIntakeStatusRepository extends JpaRepository<MedIntakeStatus, Integer>, JpaSpecificationExecutor<MedIntakeStatus> {
}