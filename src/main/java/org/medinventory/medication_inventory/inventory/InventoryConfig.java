package org.medinventory.medication_inventory.inventory;

import org.medinventory.medication_inventory.medication.Medication;
import org.medinventory.medication_inventory.medication.MedicationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;

public class InventoryConfig {

    @Bean
    @Order(2)
    CommandLineRunner commandLineRunner(InventoryRepository inventoryRepo, MedicationRepository medicationRepo) {
        return args -> {

            Medication medication = medicationRepo.findById(1)
                    .orElseThrow(() -> new RuntimeException("Medication not found"));

            inventoryRepo.save(new Inventory.Builder()
                    .med(medication)
                    .location("书房桌子")
                    .remainingQuantity((short) 100)
                    .unitType("喷")
                    .build());
        };
    }
}
