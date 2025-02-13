package org.medinventory.medication_inventory.user;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Comment("user who use medicine")
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "age")
    private Short age;

    @Column(name = "gender", length = Integer.MAX_VALUE)
    private String gender;

    @Column(name = "memo", length = Integer.MAX_VALUE)
    private String memo;


    // Getters and Setters

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    protected User() {
    }

    public User(String name, Short age, String gender, String memo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.memo = memo;
    }

    public User(String name, Short age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static class Builder {
        private String name;
        private Short age;
        private String gender;
        private String memo;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Short age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder memo(String memo) {
            this.memo = memo;
            return this;
        }

        public User build() {
            return new User(name, age, gender, memo);
        }

        public String toString() {
            return "User.Builder(name=" + this.name + ", age=" + this.age + ", gender=" + this.gender + ", memo=" + this.memo + ")";
        }

        public static Builder builder() {
            return new Builder();
        }

    }
}
