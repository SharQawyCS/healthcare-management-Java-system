package tv.codely.models;
import tv.codely.utils.FileManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class HealthcareSystem {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Appointment> appointments;

    Scanner scanner = new Scanner(System.in);

    public HealthcareSystem() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        loadDoctors();
        loadPatients();
        loadAppointments();
    }


    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        saveDoctors();
    }
    //Checked: DONE, Tested:
    public void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter Address: ");
        String doctorAddress = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String doctorPhoneNumber = scanner.nextLine();
        System.out.print("Enter Specialty: ");
        String specialty = scanner.nextLine();
        Doctor doctor = new Doctor(doctorId, doctorName, doctorAddress, doctorPhoneNumber, specialty);
        addDoctor(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        savePatients();
    }

    public void addPatient(EmergencyPatient patient) {
        patients.add(patient);
        savePatients();
    }
    //Checked: DONE, Tested:
    public void addPatient() {
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter Address: ");
        String patientAddress = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String patientPhoneNumber = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Symptoms: ");
        String symptoms = scanner.nextLine();
        System.out.print("Enter Payment Method: ");
        String paymentMethod = scanner.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Is this an emergency patient? (Y/n): ");
        String isEmergency = scanner.nextLine();
        if (isEmergency.equalsIgnoreCase("Y")) {
            System.out.print("Enter Room Number: ");
            String roomNumber = scanner.nextLine();
//            EmergencyPatient emergencyPatient = new EmergencyPatient(patientId, patientName, patientAddress, patientPhoneNumber, gender, symptoms, paymentMethod, diagnosis, roomNumber);
//            addPatient(emergencyPatient);
            EmergencyPatient Empatient = new EmergencyPatient(patientId, patientName, patientAddress, patientPhoneNumber, gender, symptoms, paymentMethod, diagnosis, roomNumber);
            addPatient(Empatient);
        } else {
            Patient patient = new Patient(patientId, patientName, patientAddress, patientPhoneNumber, gender, symptoms, paymentMethod, diagnosis);
            addPatient(patient);
        }
    }


    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        saveAppointments();
    }

    //Checked: DONE, Tested:
    public void addAppointment() {
        System.out.print("Enter Doctor ID: ");
        String appointmentDoctorId = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        String appointmentPatientId = scanner.nextLine();
        System.out.print("Enter Date: ");
        String date = scanner.nextLine();
        Appointment appointment = new Appointment(appointmentDoctorId, appointmentPatientId, date);
        addAppointment(appointment);
    }

    public void editDoctor(String id, String name, String address, String phoneNumber, String specialty) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                doctor.setName(name);
                doctor.setAddress(address);
                doctor.setPhoneNumber(phoneNumber);
                doctor.setSpecialty(specialty);
                saveDoctors();
                return;
            }
        }
        System.out.println("Doctor not found!");
    }

    public Doctor getDoctorById(String id) {
        for (Doctor doctor : doctors) {  // Assuming `doctors` is a List<Doctor> in HealthcareSystem
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null; // Return null if no doctor with the given ID is found
    }

    public Patient getPatientById(String id) {
        for (Patient pat : patients) {  // Assuming `doctors` is a List<Doctor> in HealthcareSystem
            if (pat.getId().equals(id)) {
                return pat;
            }
        }
        return null; // Return null if no doctor with the given ID is found
    }

    //Checked: DONE, Tested:
    public void editDoctor(){
        System.out.print("Enter Doctor ID to edit: ");
        String editDoctorId = scanner.nextLine();
        System.out.print("Enter New Doctor Name: ");
        String editDoctorName = scanner.nextLine();
        System.out.print("Enter New Address: ");
        String editDoctorAddress = scanner.nextLine();
        System.out.print("Enter New Phone Number: ");
        String editDoctorPhoneNumber = scanner.nextLine();
        System.out.print("Enter New Specialty: ");
        String editSpecialty = scanner.nextLine();
        editDoctor(editDoctorId, editDoctorName, editDoctorAddress, editDoctorPhoneNumber, editSpecialty);
    }


    public void editPatient(String id, String name, String address, String phoneNumber, String gender, String symptoms, String paymentMethod, String diagnosis) {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                patient.setName(name);
                patient.setAddress(address);
                patient.setPhoneNumber(phoneNumber);
                patient.setGender(gender);
                patient.setSymptoms(symptoms);
                patient.setPaymentMethod(paymentMethod);
                patient.setDiagnosis(diagnosis);
                savePatients();
                return;
            }
        }
        System.out.println("Patient not found!");
    }
    //Checked: DONE, Tested:
    public void editPatient(){
        System.out.print("Enter Patient ID to edit: ");
        String editPatientId = scanner.nextLine();
        System.out.print("Enter New Patient Name: ");
        String editPatientName = scanner.nextLine();
        System.out.print("Enter New Address: ");
        String editPatientAddress = scanner.nextLine();
        System.out.print("Enter New Phone Number: ");
        String editPatientPhoneNumber = scanner.nextLine();
        System.out.print("Enter New Gender: ");
        String editGender = scanner.nextLine();
        System.out.print("Enter New Symptoms: ");
        String editSymptoms = scanner.nextLine();
        System.out.print("Enter New Payment Method: ");
        String editPaymentMethod = scanner.nextLine();
        System.out.print("Enter New Diagnosis: ");
        String editDiagnosis = scanner.nextLine();
        editPatient(editPatientId, editPatientName, editPatientAddress, editPatientPhoneNumber, editGender, editSymptoms, editPaymentMethod, editDiagnosis);
    }

    public boolean deleteDoctor(String id) {
        doctors.removeIf(doctor -> doctor.getId().equals(id));
        saveDoctors();
        return true;
    }
    //Checked: DONE, Tested:
    public void deleteDoctor(){
        System.out.print("Enter Doctor ID to delete: ");
        String deleteDoctorId = scanner.nextLine();
        deleteDoctor(deleteDoctorId);
    }

    public void deletePatient(String id) {
        patients.removeIf(patient -> patient.getId().equals(id));
        savePatients();
    }
    //Checked: DONE, Tested:
    public void deletePatient(){
        System.out.print("Enter Patient ID to delete: ");
        String deletePatientId = scanner.nextLine();
        deletePatient(deletePatientId);
    }

    //Checked: DONE, Tested:
    public void displayAllDoctors(){
        if(doctors.isEmpty()) {
            System.out.println("No Doctors found!");
        } else {
            for (Doctor doc : getAllDoctors()) {
                System.out.println(doc);
            }
        }
    }

    //Checked: DONE, Tested:
    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found!");
        } else {
            for (Patient patient : getAllPatients()) {
                System.out.println(patient);
            }
        }
    }

    //Checked: DONE, Tested:
    public void displayEmergencyPatients() {
        List<EmergencyPatient> emergencyPatients = getEmergencyPatients();
        if (emergencyPatients.isEmpty()) {
            System.out.println("No emergency patients found.");
        } else {
            for (EmergencyPatient emergencyPatient : emergencyPatients) {
                System.out.println(emergencyPatient);
            }
        }
    }

    //Checked: DONE, Tested:
    public void displayAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public List<EmergencyPatient> getEmergencyPatients() {
        List<EmergencyPatient> emergencyPatients = new ArrayList<>();

        for (Patient patient : patients) {
            if (patient instanceof EmergencyPatient) {
                EmergencyPatient emergencyPatient = (EmergencyPatient) patient;
                    emergencyPatients.add(emergencyPatient);
            }
        }

        return emergencyPatients;
    }



    public List<Appointment> getAppointments() {
        return appointments;
    }

    //SAVING DATA //SHARQA
    private void saveDoctors() {
        List<String> data = new ArrayList<>();
        for (Doctor doctor : doctors) {
            data.add(doctor.toFileString());
        }
        FileManager.saveToFile("doctors.txt", data);
    }

    void savePatients() {
        List<String> data = new ArrayList<>();
        for (Patient patient : patients) {
            data.add(patient.toFileString());
        }
        FileManager.saveToFile("patients.txt", data);
    }

    private void saveAppointments() {
        List<String> data = new ArrayList<>();
        for (Appointment appointment : appointments) {
            data.add(appointment.toFileString());
        }
        FileManager.saveToFile("appointments.txt", data);
    }

    private void loadDoctors() {
        List<String> data = FileManager.loadFromFile("doctors.txt");
        for (String line : data) {
            doctors.add(Doctor.fromFileString(line));
        }
    }

    private void loadPatients() {
        List<String> data = FileManager.loadFromFile("patients.txt");
        for (String line : data) {
            String[] parts = line.split(","); // Assuming comma-separated values

            if (parts.length == 9) {
                EmergencyPatient patient = EmergencyPatient.fromFileString(line);
                patients.add(patient);
            } else {
                Patient patient = Patient.fromFileString(line);
                patients.add(patient);
            }

        }
    }

    private void loadAppointments() {
        List<String> data = FileManager.loadFromFile("appointments.txt");
        for (String line : data) {
            appointments.add(Appointment.fromFileString(line));
        }
    }

    private static HealthcareSystem instance;

    public static HealthcareSystem getInstance() {
        if (instance == null) {
            instance = new HealthcareSystem();
        }
        return instance;
    }
}
