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
    private String timeOfDay;

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

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String time_of_day) {
        this.timeOfDay = time_of_day;
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

    protected MedSchedule() {
    }

    public MedSchedule(User user, Medication med, Float dosage, String time_of_day, String memo) {
        this.user = user;
        this.med = med;
        this.dosage = dosage;
        this.timeOfDay = time_of_day;
        this.memo = memo;
    }

    public static class Builder {
        private User user;
        private Medication med;
        private Float dosage;
        private String timeOfDay;
        private String memo;

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder med(Medication med) {
            this.med = med;
            return this;
        }

        public Builder dosage(Float dosage) {
            this.dosage = dosage;
            return this;
        }

        public Builder time_of_day(String timeOfDay) {
            this.timeOfDay = timeOfDay;
            return this;
        }

        public Builder memo(String memo) {
            this.memo = memo;
            return this;
        }

        public MedSchedule build() {
            return new MedSchedule(user, med, dosage, timeOfDay, memo);
        }

        public static Builder builder() {
            return new Builder();
        }

        protected Builder() {
        }
    }

}