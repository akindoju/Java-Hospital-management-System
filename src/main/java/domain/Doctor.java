package domain;

public class Doctor extends Person {
    private String specialization;

    public Doctor(
            String fullName,
            String gender,
            String specialization)
    {
        super(fullName, gender);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void displayInfo() {
        System.out.println("Doctor: " + getFullName() + " (" + getSpecialization() + ")" + " " +getGender());
        System.out.println("----------------------------");
        System.out.println("----------------------------");
    }
}