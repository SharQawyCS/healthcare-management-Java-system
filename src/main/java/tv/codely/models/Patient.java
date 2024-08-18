package tv.codely.models;

public class Patient extends Person {
    private String gender;
    private String symptoms;
    private String paymentMethod;
    private String diagnosis;
    private String room;

    public Patient(String id, String name, String address, String phoneNumber, String gender, String symptoms, String paymentMethod, String diagnosis) {
        super(id, name, address, phoneNumber);
        this.gender = gender;
        this.symptoms = symptoms;
        this.paymentMethod = paymentMethod;
        this.diagnosis = diagnosis;
        this.room = "NONE";
    }
    public Patient(String id, String name, String address, String phoneNumber, String gender, String symptoms, String paymentMethod, String diagnosis, String room) {
        super(id, name, address, phoneNumber);
        this.gender = gender;
        this.symptoms = symptoms;
        this.paymentMethod = paymentMethod;
        this.diagnosis = diagnosis;
        this.room = room;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Gender: " + gender + "\n" +
                "Symptoms: " + symptoms + "\n" +
                "Payment Method: " + paymentMethod + "\n" +
                "Diagnosis: " + diagnosis + "\n";
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "," + gender + "," + symptoms + "," + paymentMethod + "," + diagnosis;
    }

    public static Patient fromFileString(String fileString) {
        String[] parts = fileString.split(",");
        return new Patient(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
    }
}
