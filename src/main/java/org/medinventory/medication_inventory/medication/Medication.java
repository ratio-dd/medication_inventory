package org.medinventory.medication_inventory.medication;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;
import org.medinventory.medication_inventory.inventory.Inventory;
import org.medinventory.medication_inventory.medschedule.MedSchedule;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Comment("save medication metadata")
@Entity
@Table(name = "medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ColumnDefault("nextval('medication_med_id_seq')")
    @Column(name = "med_id", nullable = false)
    private Integer id;

    @Comment("This name is named by factory, like Tylenol Extra Strength")
    @Column(name = "product_name", length = Integer.MAX_VALUE)
    private String product_name;

    @Comment("This name represent active part of medicine")
    @Column(name = "generic_name", length = Integer.MAX_VALUE)
    private String generic_name;

    @Comment("How user call the medicine")
    @Column(name = "common_name", length = Integer.MAX_VALUE)
    private String commonName;

    @Column(name = "manufacturer", length = Integer.MAX_VALUE)
    private String manufacturer;

    @Comment("where do user buy the medication")
    @Column(name = "purchase_method")
    private String purchase_method;

    @Column(name = "specification", length = Integer.MAX_VALUE)
    private String specification;

    @Column(name = "dose")
    private Short dose;

    @Comment("what type of medicine.e.g.Tablet, Capsule, Syrup, Patch")
    @Column(name = "formulation", length = Integer.MAX_VALUE)
    private String formulation;

    @Comment("Key is to store whether is domestic or imported")
    @Column(name = "place_of_origin", length = Integer.MAX_VALUE)
    private String place_of_origin;

    @Column(name = "effects", length = Integer.MAX_VALUE)
    private String effects;

    @Column(name = "manufacture_date")
    private LocalDate manufacture_date;

    @Column(name = "expiry_date")
    private LocalDate expiry_date;

    @Column(name = "barcode")
    private Integer barcode;

    @Comment("for safety trace back usage")
    @Column(name = "trace_code", length = Integer.MAX_VALUE)
    private String trace_code;

    @Column(name = "batch_number")
    private Integer batch_number;

    @Column(name = "memo", length = Integer.MAX_VALUE)
    private String memo;

    @OneToMany(mappedBy = "med")
    private Set<MedSchedule> medSchedules = new LinkedHashSet<>();

    @OneToOne(mappedBy = "med")
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getGeneric_name() {
        return generic_name;
    }

    public void setGeneric_name(String generic_name) {
        this.generic_name = generic_name;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPurchase_method() {
        return purchase_method;
    }

    public void setPurchase_method(String purchase_method) {
        this.purchase_method = purchase_method;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Short getDose() {
        return dose;
    }

    public void setDose(Short dose) {
        this.dose = dose;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public String getPlace_of_origin() {
        return place_of_origin;
    }

    public void setPlace_of_origin(String place_of_origin) {
        this.place_of_origin = place_of_origin;
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects;
    }

    public LocalDate getManufacture_date() {
        return manufacture_date;
    }

    public void setManufacture_date(LocalDate manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public LocalDate getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(LocalDate expiry_date) {
        this.expiry_date = expiry_date;
    }

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public String getTrace_code() {
        return trace_code;
    }

    public void setTrace_code(String trace_code) {
        this.trace_code = trace_code;
    }

    public Integer getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(Integer batch_number) {
        this.batch_number = batch_number;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Set<MedSchedule> getMedSchedules() {
        return medSchedules;
    }

    public void setMedSchedules(Set<MedSchedule> medSchedules) {
        this.medSchedules = medSchedules;
    }

    protected Medication() {
    }

    public Medication(String product_name, String generic_name, String common_name, String manufacturer,
                      String purchase_method, String specification, Short dose, String formulation,
                      String place_of_origin, String effects, LocalDate manufacture_date, LocalDate expiry_date,
                      Integer barcode, String trace_code, Integer batch_number, String memo) {
        this.product_name = product_name;
        this.generic_name = generic_name;
        this.commonName = common_name;
        this.manufacturer = manufacturer;
        this.purchase_method = purchase_method;
        this.specification = specification;
        this.dose = dose;
        this.formulation = formulation;
        this.place_of_origin = place_of_origin;
        this.effects = effects;
        this.manufacture_date = manufacture_date;
        this.expiry_date = expiry_date;
        this.barcode = barcode;
        this.trace_code = trace_code;
        this.batch_number = batch_number;
        this.memo = memo;
    }

    public static class Builder {
        private String product_name;
        private String generic_name;
        private String common_name;
        private String manufacturer;
        private String purchase_method;
        private String specification;
        private Short dose;
        private String formulation;
        private String place_of_origin;
        private String effects;
        private LocalDate manufacture_date;
        private LocalDate expiry_date;
        private Integer barcode;
        private String trace_code;
        private Integer batch_number;
        private String memo;

        public Builder productName(String product_name) {
            this.product_name = product_name;
            return this;
        }

        public Builder genericName(String generic_name) {
            this.generic_name = generic_name;
            return this;
        }

        public Builder commonName(String common_name) {
            this.common_name = common_name;
            return this;
        }

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder purchaseMethod(String purchase_method) {
            this.purchase_method = purchase_method;
            return this;
        }

        public Builder specification(String specification) {
            this.specification = specification;
            return this;
        }

        public Builder dose(Short dose) {
            this.dose = dose;
            return this;
        }

        public Builder formulation(String formulation) {
            this.formulation = formulation;
            return this;
        }

        public Builder placeOfOrigin(String place_of_origin) {
            this.place_of_origin = place_of_origin;
            return this;
        }

        public Builder effects(String effects) {
            this.effects = effects;
            return this;
        }

        public Builder manufactureDate(LocalDate manufacture_date) {
            this.manufacture_date = manufacture_date;
            return this;
        }

        public Builder expiryDate(LocalDate expiry_date) {
            this.expiry_date = expiry_date;
            return this;
        }

        public Builder barcode(Integer barcode) {
            this.barcode = barcode;
            return this;
        }

        public Builder traceCode(String trace_code) {
            this.trace_code = trace_code;
            return this;
        }

        public Builder batchNumber(Integer batch_number) {
            this.batch_number = batch_number;
            return this;
        }

        public Builder memo(String memo) {
            this.memo = memo;
            return this;
        }

        public Medication build() {
            return new Medication(product_name, generic_name, common_name, manufacturer, purchase_method,
                    specification, dose, formulation, place_of_origin, effects, manufacture_date,
                    expiry_date, barcode, trace_code, batch_number, memo);
        }

        public static Builder builder() {
            return new Builder();
        }

    }
}