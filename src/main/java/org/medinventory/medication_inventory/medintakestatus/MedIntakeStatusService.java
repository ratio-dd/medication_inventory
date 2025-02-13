package org.medinventory.medication_inventory.medintakestatus;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedIntakeStatusService {

    private final MedIntakeStatusRepository medIntakeStatusRepository;

    public MedIntakeStatusService(MedIntakeStatusRepository medIntakeStatusRepository) {
        this.medIntakeStatusRepository = medIntakeStatusRepository;
    }

    public MedIntakeStatus saveMedIntakeStatus(MedIntakeStatus medIntakeStatus) {
        return medIntakeStatusRepository.save(medIntakeStatus);
    }


    public void deleteMedIntakeStatusById(Integer id) {
        medIntakeStatusRepository.deleteById(id);
    }

    public MedIntakeStatus updateMedIntakeStatus(Integer id, MedIntakeStatus medIntakeStatus) {
        MedIntakeStatus existingMedIntakeStatus = medIntakeStatusRepository.findById(id).orElse(null);
        if (existingMedIntakeStatus != null) {
            existingMedIntakeStatus.setSchedule(medIntakeStatus.getSchedule());
            existingMedIntakeStatus.setUser(medIntakeStatus.getUser());
            existingMedIntakeStatus.setTime(medIntakeStatus.getTime());
            existingMedIntakeStatus.setStatus(medIntakeStatus.getStatus());
            existingMedIntakeStatus.setMemo(medIntakeStatus.getMemo());
            return medIntakeStatusRepository.save(existingMedIntakeStatus);
        }
        return null;
    }

    public Optional<MedIntakeStatus> getMedIntakeStatusById(Integer id) {
        return medIntakeStatusRepository.findById(id);
    }

    public Optional<MedIntakeStatus> getMedIntakeStatusByScheduleId(Integer scheduleId) {
        return medIntakeStatusRepository.findBySchedule_Id(scheduleId);
    }

    public Optional<MedIntakeStatus> getMedIntakeStatusByUserId(Integer userId) {
        return medIntakeStatusRepository.findByUser_Id(userId);
    }

    public List<MedIntakeStatus> getAllMedIntakeStatus() {
        return medIntakeStatusRepository.findAll();
    }
}
