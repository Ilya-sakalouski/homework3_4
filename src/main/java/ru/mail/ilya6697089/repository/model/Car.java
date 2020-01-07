package ru.mail.ilya6697089.repository.model;

public class Car {


    private String name;
    private Integer age;
    private Boolean isActive;

    private Car(Builder builder) {
        name = builder.name;
        age = builder.age;
        isActive = builder.isActive;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                '}';
    }



    public static final class Builder {

        private String name;
        private Integer age;
        private Boolean isActive;

        private Builder() {}

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder isActive(Boolean val) {
            isActive = val;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }

}
