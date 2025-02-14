package org.medinventory.medication_inventory.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Integer> , JpaSpecificationExecutor<User> {
  }