package org.medinventory.medication_inventory.medication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MedicationConfig {

    @Bean
    CommandLineRunner commandLineRunner(MedicationRepository repository) {
        return args -> {
            repository.save(new Medication.Builder()
                    .productName("雷诺考特布地奈德鼻喷雾剂")
                    .genericName("布地奈德")
                    .commonName("过敏鼻喷")
                    .manufacturer("上海强生制药有限公司")
                    .purchaseMethod("药房")
                    .specification("specification")
                    .dose(1)
                    .formulation("formulation")
                    .placeOfOrigin("进口")
                    .effects("effects")
                    .manufactureDate(LocalDate.of(2024, 3, 19))
                    .expiryDate(LocalDate.of(2026, 8, 1))
                    .build()
            );
        };
    }
}
