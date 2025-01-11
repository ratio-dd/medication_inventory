package org.medinventory.medication_inventory.repository;

import org.medinventory.medication_inventory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Integer> , JpaSpecificationExecutor<User> {
  }