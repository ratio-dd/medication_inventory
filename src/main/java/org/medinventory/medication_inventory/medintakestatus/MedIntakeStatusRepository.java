package org.medinventory.medication_inventory.medintakestatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface MedIntakeStatusRepository extends JpaRepository<MedIntakeStatus, Integer>, JpaSpecificationExecutor<MedIntakeStatus> {
    Optional<MedIntakeStatus> findBySchedule_Id(Integer scheduleId);

    Optional<MedIntakeStatus> findByUser_Id(Integer userId);
}