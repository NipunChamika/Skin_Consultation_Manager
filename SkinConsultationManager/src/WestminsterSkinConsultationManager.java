import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    private static final int MAX_DOCTORS = 10;
    private static final String FILE_NAME = "consultation_centre.dat";

    private static List<Doctor> doctors;

    public WestminsterSkinConsultationManager() {
        doctors = new ArrayList<>();
    }
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu
            System.out.println("--- Skin Consultation Centre ---");
            System.out.println("1. Add a new doctor");
            System.out.println("2. Delete a doctor");
            System.out.println("3. Print the list of doctors");
            System.out.println("4. Save information to a file");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addDoctor(scanner);
                    break;
                case 2:
                    deleteDoctor(scanner);
                    break;
                case 3:
                    printDoctors();
                    break;
                case 4:
                    saveInformation();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    private static void addDoctor(Scanner scanner) {
        if (doctors.size() == MAX_DOCTORS) {
            System.out.println("Cannot add more doctors. Maximum number of doctors reached.");
            return;
        }

        System.out.print("Enter doctor's name: ");
        String name = scanner.next();

        System.out.print("Enter doctor's surname: ");
        String surname = scanner.next();

        System.out.print("Enter doctor's date of birth: ");
        String dateOfBirth = scanner.next();

        System.out.print("Enter doctor's mobile number: ");
        String mobileNumber = scanner.next();

        System.out.print("Enter doctor's medical licence number: ");
        String medicalLicenceNumber = scanner.next();

        System.out.print("Enter doctor's specialization: ");
        String specialization = scanner.next();

        Doctor doctor = new Doctor(name, surname, dateOfBirth, mobileNumber, medicalLicenceNumber, specialization);
        doctors.add(doctor);

        System.out.println("Doctor added successfully.");
    }

    private static void deleteDoctor(Scanner scanner) {
        System.out.print("Enter doctor's medical licence number: ");
        String medicalLicenceNumber = scanner.next();

        int index = -1;
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getMedicalLicenceNumber().equals(medicalLicenceNumber)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Doctor not found.");
        } else {
            Doctor doctor = doctors.get(index);
            doctors.remove(index);
            System.out.println("Doctor deleted successfully:");
            System.out.println("Name: " + doctor.getName() + " " + doctor.getSurname());
            System.out.println("Date of birth: " + doctor.getDateOfBirth());
            System.out.println("Mobile number: " + doctor.getMobileNumber());
            System.out.println("Medical licence number: " + doctor.getMedicalLicenceNumber());
            System.out.println("Specialization: " + doctor.getSpecialization());
            System.out.println("Total doctors: " + doctors.size());
        }
    }

    private static void printDoctors() {
        Collections.sort(doctors, (doctor1, doctor2) -> doctor1.getSurname().compareTo(doctor2.getSurname()));

        System.out.println("--- List of Doctors ---");
        for (Doctor doctor : doctors) {
            System.out.println("Name: " + doctor.getName() + " " + doctor.getSurname());
            System.out.println("Date of birth: " + doctor.getDateOfBirth());
            System.out.println("Mobile number: " + doctor.getMobileNumber());
            System.out.println("Medical licence number: " + doctor.getMedicalLicenceNumber());
            System.out.println("Specialization: " + doctor.getSpecialization());
        }
    }

    private static void saveInformation() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(doctors);
            System.out.println("Information saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readInformation() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            doctors = (List<Doctor>) ois.readObject();
            System.out.println("Information read successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void AddDoctor(Scanner scanner) {
        if (doctors.size() == MAX_DOCTORS) {
            System.out.println("Cannot add more doctors. Maximum number of doctors reached.");
            return;
        }

        System.out.print("Enter doctor's name: ");
        String name = scanner.next();

        System.out.print("Enter doctor's surname: ");
        String surname = scanner.next();

        System.out.print("Enter doctor's date of birth: ");
        String dateOfBirth = scanner.next();

        System.out.print("Enter doctor's mobile number: ");
        String mobileNumber = scanner.next();

        System.out.print("Enter doctor's medical licence number: ");
        String medicalLicenceNumber = scanner.next();

        System.out.print("Enter doctor's specialization: ");
        String specialization = scanner.next();

        Doctor doctor = new Doctor(name, surname, dateOfBirth, mobileNumber, medicalLicenceNumber, specialization);
        doctors.add(doctor);

        System.out.println("Doctor added successfully.");
    }

    @Override
    public void DeleteDoctor() {

    }

    @Override
    public void PrintListOfDoctors() {

    }

    @Override
    public void SaveFile() {

    }

    @Override
    public void ReadFile() {

    }
}