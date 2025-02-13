package org.medinventory.medication_inventory.medintakestatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/medintakestatus")
public class MedIntakeStatusController {
    private final MedIntakeStatusService medIntakeStatusService;
    public MedIntakeStatusController(MedIntakeStatusService medIntakeStatusService) {
        this.medIntakeStatusService = medIntakeStatusService;
    }

    @GetMapping(path = "/get", params = "id")
    public ResponseEntity<MedIntakeStatus> getMedIntakeStatusById(@RequestParam("id") Integer id) {
        return medIntakeStatusService.getMedIntakeStatusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/get", params = "scheduleId")
    public ResponseEntity<MedIntakeStatus> getMedIntakeStatusByScheduleId(@RequestParam("scheduleId") Integer scheduleId) {
        return medIntakeStatusService.getMedIntakeStatusByScheduleId(scheduleId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/get", params = "userId")
    public ResponseEntity<MedIntakeStatus> getMedIntakeStatusByUserId(@RequestParam("userId") Integer userId) {
        return medIntakeStatusService.getMedIntakeStatusByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}