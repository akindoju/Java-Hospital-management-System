import util.Common;
import domain.Patient;
import domain.Doctor;
import domain.Appointment;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    final private static ArrayList<Patient> patients = new ArrayList<>();
    final private static ArrayList<Doctor> doctors = new ArrayList<>();
    final private static ArrayList<Appointment> appointments = new ArrayList<>();
    final private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Common.showBanner();
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewDoctors();
                    break;
                case 5:
                    bookAppointment();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 7:
                    editPatient();
                    break;
                case 8:
                    editDoctor();
                    break;
                case 9:
                    editAppointment();
                    break;
                case 10:
                    deletePatient();
                    break;
                case 11:
                    deleteDoctor();
                    break;
                case 12:
                    deleteAppointment();
                    break;
                case 13:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nHospital Management System");
        System.out.println("1. Add Patient");
        System.out.println("2. View Patient");
        System.out.println("3. Add Doctor");
        System.out.println("4. View Doctor");
        System.out.println("5. Book Appointment");
        System.out.println("6. View Appointments");
        System.out.println("7. Edit Patient");
        System.out.println("8. Edit Doctor");
        System.out.println("9. Edit Appointment");
        System.out.println("10. Delete Patient");
        System.out.println("11. Delete Doctor");
        System.out.println("12. Delete Appointment");
        System.out.println("13. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addPatient() {

        System.out.println("-----------------------------------------");
        System.out.println("********** ENTER PATIENT DETAILS *********");
        System.out.println("-----------------------------------------");
        System.out.print("Enter patient's full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter patient's blood group: ");
        String bloodGroup = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter patient's age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        Patient patient = new Patient(fullName, gender, age, bloodGroup);
        patients.add(patient);
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("Patient added successfully.");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
    }
    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("No patient found.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        System.out.println();
        System.out.println("All Patient:");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        for (Patient patient : patients) {
            patient.displayInfo();
        }
    }

    private static void addDoctor() {
        System.out.print("Enter doctor's full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter doctor specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        Doctor doctor = new Doctor(fullName, gender, specialization);
        doctors.add(doctor);
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("Doctor added successfully.");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
    }
    private static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("No doctor found.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        System.out.println();
        System.out.println("All Doctors:");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        for (Doctor doctor : doctors) {
            doctor.displayInfo();
        }
    }


    private static void bookAppointment() {
        if (patients.isEmpty()) {
            System.out.println("No patients found. Please add a patient first.");
            return;
        }

        if (doctors.isEmpty()) {
            System.out.println("No doctors found. Please add a doctor first.");
            return;
        }

        System.out.println();
        System.out.println("Available Patients:");
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            System.out.println((i + 1) + ". " + patient.getFullName() + " (" + patient.getAge() + " years old)");
        }
        System.out.print("Select a patient by entering the corresponding number: ");
        int patientChoice;
        patientChoice = scanner.nextInt();
        scanner.nextLine();

        if (patientChoice < 1 || patientChoice > patients.size()) {
            System.out.println("Invalid patient choice.");
            return;
        }

        Patient selectedPatient = patients.get(patientChoice - 1);

        System.out.println();
        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            System.out.println((i + 1) + ". " + doctor.getFullName() + " (" + doctor.getSpecialization() + ")");
        }
        System.out.print("Select a doctor by entering the corresponding number: ");
        int doctorChoice = scanner.nextInt();
        scanner.nextLine();

        if (doctorChoice < 1 || doctorChoice > doctors.size()) {
            System.out.println("Invalid doctor choice.");
            return;
        }

        Doctor selectedDoctor = doctors.get(doctorChoice - 1);

        System.out.print("Enter appointment date (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        System.out.print("Enter appointment time (hh:mm): ");
        String time = scanner.nextLine();

        Appointment appointment = new Appointment(selectedPatient, selectedDoctor, date, time);
        appointments.add(appointment);
        System.out.println("Appointment booked successfully.");
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        System.out.println();
        System.out.println("Upcoming Appointments:");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        for (Appointment appointment : appointments) {
            Patient patient = appointment.getPatient();
            Doctor doctor = appointment.getDoctor();
            String date = appointment.getDate();
            String time = appointment.getTime();
            System.out.println("Patient: " + patient.getFullName() + " (" + patient.getAge() + " years old)");
            System.out.println("Doctor: " + doctor.getFullName() + " (" + doctor.getSpecialization() + ")");
            System.out.println("Date: " + date + " Time: " + time);
            System.out.println("----------------------------");
            System.out.println("----------------------------");
        }
    }

    private static void editPatient() {
        if (patients.isEmpty()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("No patients found.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        System.out.println("Available Patients:");
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            System.out.println((i + 1) + ". " + patient.getFullName() + " (" + patient.getAge() + " years old)");
        }
        System.out.print("Select a patient to edit by entering the corresponding number: ");
        int patientChoice = scanner.nextInt();
        scanner.nextLine();

        if (patientChoice < 1 || patientChoice > patients.size()) {
            System.out.println("Invalid patient choice.");
            return;
        }

        Patient selectedPatient = patients.get(patientChoice - 1);
        System.out.print("Enter new patient name (or press Enter to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            selectedPatient.setFullName(newName);
        }

        System.out.print("Enter new patient age (or press Enter to keep current): ");
        String newAgeInput = scanner.nextLine();
        if (!newAgeInput.isEmpty()) {
            int newAge = Integer.parseInt(newAgeInput);
            selectedPatient.setAge(newAge);
        }

        System.out.println("Patient updated successfully.");

        System.out.print("Enter new patient blood group (or press Enter to keep current): ");
        String newBloodGroup = scanner.nextLine();
        if (!newBloodGroup.isEmpty()) {
            selectedPatient.setBloodGroup(newBloodGroup);
        }
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("Patient updated successfully.");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
    }

    private static void editDoctor() {
        if (doctors.isEmpty()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("No doctors found.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            System.out.println((i + 1) + ". " + doctor.getFullName() + " (" + doctor.getSpecialization() + ")");
        }
        System.out.print("Select a doctor to edit by entering the corresponding number: ");
        int doctorChoice = scanner.nextInt();
        scanner.nextLine();

        if (doctorChoice < 1 || doctorChoice > doctors.size()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("Invalid doctor choice.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        Doctor selectedDoctor = doctors.get(doctorChoice - 1);
        System.out.print("Enter new doctor name (or press Enter to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            selectedDoctor.setFullName(newName);
        }

        System.out.print("Enter new doctor specialization (or press Enter to keep current): ");
        String newSpecialization = scanner.nextLine();
        if (!newSpecialization.isEmpty()) {
            selectedDoctor.setSpecialization(newSpecialization);
        }
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("Doctor updated successfully.");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
    }

    private static void editAppointment() {
        if (appointments.isEmpty()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("No appointments found.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        viewAppointments();
        System.out.print("Select an appointment to edit by entering the corresponding number: ");
        int appointmentChoice = scanner.nextInt();
        scanner.nextLine();

        if (appointmentChoice < 1 || appointmentChoice > appointments.size()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("Invalid appointment choice.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        Appointment selectedAppointment = appointments.get(appointmentChoice - 1);

        System.out.println("Available Patients:");
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            System.out.println((i + 1) + ". " + patient.getFullName() + " (" + patient.getAge() + " years old)");
        }
        System.out.print("Select a new patient by entering the corresponding number (or press Enter to keep current): ");
        String newPatientInput = scanner.nextLine();
        if (!newPatientInput.isEmpty()) {
            int newPatientChoice = Integer.parseInt(newPatientInput);
            if (newPatientChoice < 1 || newPatientChoice > patients.size()) {
                System.out.println("Invalid patient choice.");
            } else {
                Patient newPatient = patients.get(newPatientChoice - 1);
                selectedAppointment.setPatient(newPatient);
            }
        }

        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            System.out.println((i + 1) + ". " + doctor.getFullName() + " (" + doctor.getSpecialization() + ")");
        }
        System.out.print("Select a new doctor by entering the corresponding number (or press Enter to keep current): ");
        String newDoctorInput = scanner.nextLine();
        if (!newDoctorInput.isEmpty()) {
            int newDoctorChoice = Integer.parseInt(newDoctorInput);
            if (newDoctorChoice < 1 || newDoctorChoice > doctors.size()) {
                System.out.println("Invalid doctor choice.");
            } else {
                Doctor newDoctor = doctors.get(newDoctorChoice - 1);
                selectedAppointment.setDoctor(newDoctor);
            }
        }

        System.out.print("Enter new appointment date (yyyy-mm-dd) (or press Enter to keep current): ");
        String newDate = scanner.nextLine();
        if (!newDate.isEmpty()) {
            selectedAppointment.setDate(newDate);
        }

        System.out.print("Enter new appointment time (hh:mm) (or press Enter to keep current): ");
        String newTime = scanner.nextLine();
        if (!newTime.isEmpty()) {
            selectedAppointment.setTime(newTime);
        }

        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("Appointment updated successfully.");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
    }

    private static void deletePatient() {
        if (patients.isEmpty()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("No patients found.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        System.out.println("Available Patients:");
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            System.out.println((i + 1) + ". " + patient.getFullName() + " (" + patient.getAge() + " years old)");
        }
        System.out.print("Select a patient to delete by entering the corresponding number: ");
        int patientChoice;
        patientChoice = scanner.nextInt();
        scanner.nextLine();

        if (patientChoice < 1 || patientChoice > patients.size()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("Invalid patient choice.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        Patient selectedPatient = patients.get(patientChoice - 1);
        patients.remove(selectedPatient);
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("Patient deleted successfully.");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
    }

    private static void deleteDoctor() {
        if (doctors.isEmpty()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("No doctors found.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        System.out.println("Available Doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            System.out.println((i + 1) + ". " + doctor.getFullName() + " (" + doctor.getSpecialization() + ")");
        }
        System.out.print("Select a doctor to delete by entering the corresponding number: ");
        int doctorChoice;
        doctorChoice = scanner.nextInt();
        scanner.nextLine();

        if (doctorChoice < 1 || doctorChoice > doctors.size()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("Invalid doctor choice.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        Doctor selectedDoctor = doctors.get(doctorChoice - 1);
        doctors.remove(selectedDoctor);
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("Doctor deleted successfully.");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
    }

    private static void deleteAppointment() {
        if (appointments.isEmpty()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("No appointments found.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        viewAppointments();
        System.out.print("Select an appointment to delete by entering the corresponding number: ");
        int appointmentChoice;
        appointmentChoice = scanner.nextInt();
        scanner.nextLine();

        if (appointmentChoice < 1 || appointmentChoice > appointments.size()) {
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            System.out.println("Invalid appointment choice.");
            System.out.println("----------------------------");
            System.out.println("----------------------------");
            return;
        }

        Appointment selectedAppointment = appointments.get(appointmentChoice - 1);
        appointments.remove(selectedAppointment);
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        System.out.println("Appointment deleted successfully.");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
    }
}