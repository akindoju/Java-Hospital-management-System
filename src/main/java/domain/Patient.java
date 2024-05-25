package domain;

public class Patient extends Person {
    private String bloodGroup;
    private int age;


    public Patient(
            String fullName,
            String gender,
            int age,
            String bloodGroup)
    {
        super(fullName, gender);
        this.age = age;
        this.bloodGroup = bloodGroup;
    }

    public int getAge() {
        return age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public void displayInfo() {
        System.out.println("Patient: " + getFullName() + " (" + getAge() + " years old)" + " " + getGender());
        System.out.println("----------------------------");
        System.out.println("----------------------------");
    }
}