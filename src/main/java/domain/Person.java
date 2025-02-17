package domain;

public abstract class Person {
    private String fullName;
    private String gender;

    public Person (String fullName, String gender) {
        this.fullName = fullName;
        this.gender = gender;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public abstract void displayInfo();
}