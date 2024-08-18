
package tv.codely.utils;


import tv.codely.models.HealthcareSystem;

import java.util.Scanner;

public  class MainScreen {
    public boolean show = true;


    public void showMainScreen()
    {
        HealthcareSystem healthcareSystem = new HealthcareSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n");
        System.out.println("============= Welcome To Our Healthcare System =============");
        System.out.println("[1] Add Doctor                      [2] Add Patient");
        System.out.println("[3] Edit Doctor                     [4] Edit Patient");
        System.out.println("[5] Delete Doctor                   [6] Delete Patient");
        System.out.println("[7] Display All Doctors             [8] Display All Patients");
        System.out.println("[9] Display Emergency Patients      [10] Display Appointments");
        System.out.println("[11] Make Appointment               [0] Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                healthcareSystem.addDoctor();
                break;
            case 2:
                healthcareSystem.addPatient();
                break;
            case 3:
                healthcareSystem.editDoctor();
                break;
            case 4:
                healthcareSystem.editPatient();
                break;
            case 5:
                healthcareSystem.deleteDoctor();
                break;
            case 6:
                healthcareSystem.deletePatient();
                break;
            case 7:
                healthcareSystem.displayAllDoctors();
                break;
            case 8:
                healthcareSystem.displayAllPatients();
                break;
            case 9:
                healthcareSystem.displayEmergencyPatients();
                break;
            case 10:
                healthcareSystem.displayAppointments();
                break;
            case 11:
                healthcareSystem.addAppointment();
                break;
            case 0:
                System.out.println("Exiting...");
                show = false;
                return;
            default:
                System.out.println("Invalid option!");
        }
    }
}
