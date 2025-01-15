package org.medinventory.medication_inventory;

import org.medinventory.medication_inventory.config.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CorsConfig.class)
public class MedicationInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicationInventoryApplication.class, args);
    }

}
