package org.medinventory.medication_inventory.repository;

import org.medinventory.medication_inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> , JpaSpecificationExecutor<Inventory> {
  }