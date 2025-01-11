package org.medinventory.medication_inventory.repository;

import org.medinventory.medication_inventory.model.MedSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedScheduleRepository extends JpaRepository<MedSchedule, Integer>, JpaSpecificationExecutor<MedSchedule> {
}