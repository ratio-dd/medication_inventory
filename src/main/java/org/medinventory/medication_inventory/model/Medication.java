package org.medinventory.medication_inventory.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

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
    private String common_name;

    @Column(name = "manufacturer", length = Integer.MAX_VALUE)
    private String manufacturer;

    @Comment("where do user buy the medication")
    @Column(name = "purchase_method")
    private Integer purchase_method;

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

    public String getCommon_name() {
        return common_name;
    }

    public void setCommon_name(String common_name) {
        this.common_name = common_name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getPurchase_method() {
        return purchase_method;
    }

    public void setPurchase_method(Integer purchase_method) {
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

}