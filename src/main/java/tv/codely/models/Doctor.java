package tv.codely.models;

public class Doctor extends Person {
    private String specialty;

    public Doctor(String id, String name, String address, String phoneNumber, String specialty) {
        super(id, name, address, phoneNumber);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Address: " + address + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Speciality: " + specialty + "\n" ;
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "," + specialty;
    }

    public static Doctor fromFileString(String fileString) {
        String[] parts = fileString.split(",");
        return new Doctor(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }
}
