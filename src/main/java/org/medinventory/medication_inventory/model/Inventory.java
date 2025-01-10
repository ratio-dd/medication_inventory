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
    private Short remaining_quantity;

    @Column(name = "location", length = Integer.MAX_VALUE)
    private String location;

    @Column(name = "unit_type", length = Integer.MAX_VALUE)
    private String unit_type;

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

    public Short getRemaining_quantity() {
        return remaining_quantity;
    }

    public void setRemaining_quantity(Short remaining_quantity) {
        this.remaining_quantity = remaining_quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUnit_type() {
        return unit_type;
    }

    public void setUnit_type(String unit_type) {
        this.unit_type = unit_type;
    }

}