package org.medinventory.medication_inventory.inventory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping(path = "/{medId}/add")
    public ResponseEntity<Inventory> addInventoryToMedication(@PathVariable("medId") Integer medId, @RequestBody Inventory inventory) {
//        Inventory inventory1 = inventoryService.addInventoryToMedication(medId, inventory);
        return inventoryService.addInventoryToMedication(medId, inventory)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/get")
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping(path = "/get", params = "id")
    public ResponseEntity<Inventory> getInventoryById(@RequestParam("id") Integer id) {
        return inventoryService.getInventoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping(path = "/update")
    public ResponseEntity<Inventory> updateUsage(@RequestParam("inventoryID") Integer inventoryID,
                                                 @RequestParam("dose") Short dose) {
        return inventoryService.updateUsage(inventoryID, dose)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
