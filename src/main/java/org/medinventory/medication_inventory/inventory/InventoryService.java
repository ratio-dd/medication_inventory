package org.medinventory.medication_inventory.inventory;

import org.medinventory.medication_inventory.medication.Medication;
import org.medinventory.medication_inventory.medication.MedicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final MedicationRepository medicationRepository;

    public InventoryService(InventoryRepository inventoryRepository, MedicationRepository medicationRepository) {
        this.inventoryRepository = inventoryRepository;
        this.medicationRepository = medicationRepository;
    }

    public Optional<Inventory> getInventoryById(Integer id) {
        return this.inventoryRepository.findByMed_Id(id);
    }

    //TODO: Check if need to rewrite the function
    public Optional<Inventory> addInventoryToMedication(Integer medId, Inventory inventory) {
        return medicationRepository.findById(medId).map(med -> {
            inventory.setMed(med);
            return inventoryRepository.save(inventory);
        });
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> updateUsage(Integer inventoryID, Short dose) {
        return inventoryRepository.findById(inventoryID).map(inventory -> {
            inventory.setRemainingQuantity((short) (inventory.getRemainingQuantity() - dose));
            return inventoryRepository.save(inventory);
        });
    }
}
