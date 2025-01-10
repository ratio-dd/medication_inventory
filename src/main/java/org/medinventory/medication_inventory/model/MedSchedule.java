package org.medinventory.medication_inventory.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "med_schedule")
public class MedSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ColumnDefault("nextval('med_schedule_schedule_id_seq')")
    @Column(name = "schedule_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "med_id", nullable = false)
    private Medication med;

    @Column(name = "dosage", nullable = false)
    private Float dosage;

    @Column(name = "time_of_day", nullable = false, length = Integer.MAX_VALUE)
    private String time_of_day;

    @Column(name = "memo", length = Integer.MAX_VALUE)
    private String memo;

    @OneToMany(mappedBy = "schedule")
    private Set<MedIntakeStatus> medIntakeStatuses = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Medication getMed() {
        return med;
    }

    public void setMed(Medication med) {
        this.med = med;
    }

    public Float getDosage() {
        return dosage;
    }

    public void setDosage(Float dosage) {
        this.dosage = dosage;
    }

    public String getTime_of_day() {
        return time_of_day;
    }

    public void setTime_of_day(String time_of_day) {
        this.time_of_day = time_of_day;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Set<MedIntakeStatus> getMedIntakeStatuses() {
        return medIntakeStatuses;
    }

    public void setMedIntakeStatuses(Set<MedIntakeStatus> medIntakeStatuses) {
        this.medIntakeStatuses = medIntakeStatuses;
    }

}