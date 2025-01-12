package org.medinventory.medication_inventory.medschedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MedScheduleRepository extends JpaRepository<MedSchedule, Integer>, JpaSpecificationExecutor<MedSchedule> {
}