package org.medinventory.medication_inventory.medintakestatus;

import jakarta.persistence.*;
import org.medinventory.medication_inventory.medschedule.MedSchedule;
import org.medinventory.medication_inventory.user.User;

import java.time.LocalTime;

@Entity
@Table(name = "med_intake_status")
public class MedIntakeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @ColumnDefault("nextval('med_intake_status_intake_id_seq')")
    @Column(name = "intake_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "schedule_id", nullable = false)
    private MedSchedule schedule;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "\"time\"", nullable = false)
    private LocalTime time;

    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @Column(name = "memo", nullable = false, length = Integer.MAX_VALUE)
    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MedSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(MedSchedule schedule) {
        this.schedule = schedule;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    protected MedIntakeStatus() {
    }

    public MedIntakeStatus(MedSchedule schedule, User user, LocalTime time, String status, String memo) {
        this.schedule = schedule;
        this.user = user;
        this.time = time;
        this.status = status;
        this.memo = memo;
    }

    public static class Builder {
        private MedSchedule schedule;
        private User user;
        private LocalTime time;
        private String status;
        private String memo;

        protected Builder() {
        }

        public Builder schedule(MedSchedule schedule) {
            this.schedule = schedule;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder time(LocalTime time) {
            this.time = time;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder memo(String memo) {
            this.memo = memo;
            return this;
        }

        public MedIntakeStatus build() {
            return new MedIntakeStatus(schedule, user, time, status, memo);
        }

        public static Builder builder() {
            return new Builder();
        }

        public String toString() {
            return "MedIntakeStatus.Builder(schedule=" + this.schedule + ", user=" + this.user + ", time=" + this.time + ", status=" + this.status + ", memo=" + this.memo + ")";
        }
    }
}