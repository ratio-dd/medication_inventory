package org.medinventory.medication_inventory.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> , JpaSpecificationExecutor<Inventory> {
  }