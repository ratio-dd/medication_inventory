package org.medinventory.medication_inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ColumnDefault("nextval('inventory_inventory_id_seq')")
    @Column(name = "inventory_id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "med_id", nullable = false)
    private Medication med;

    @Column(name = "remaining_quantity")
    private Short remainingQuantity;

    @Column(name = "location", length = Integer.MAX_VALUE)
    private String location;

    @Column(name = "unit_type", length = Integer.MAX_VALUE)
    private String unitType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Medication getMed() {
        return med;
    }

    public void setMed(Medication med) {
        this.med = med;
    }

    public Short getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Short remaining_quantity) {
        this.remainingQuantity = remaining_quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unit_type) {
        this.unitType = unit_type;
    }

    protected Inventory() {
    }

    public Inventory(Medication med, Short remaining_quantity, String location, String unit_type) {
        this.med = med;
        this.remainingQuantity = remaining_quantity;
        this.location = location;
        this.unitType = unit_type;
    }
    public static class Builder {
        private Medication med;
        private Short remainingQuantity;
        private String location;
        private String unitType;
        public Builder med(Medication med) {
            this.med = med;
            return this;
        }
        public Builder remainingQuantity(Short remainingQuantity) {
            this.remainingQuantity = remainingQuantity;
            return this;
        }
        public Builder location(String location) {
            this.location = location;
            return this;
        }
        public Builder unitType(String unitType) {
            this.unitType = unitType;
            return this;
        }
        public Inventory build() {
            return new Inventory(med, remainingQuantity, location, unitType);
        }
        public static Builder builder() {
            return new Builder();
        }

    }
}