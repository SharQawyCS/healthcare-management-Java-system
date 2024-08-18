package tv.codely.models;

public class Appointment {
    private String doctorId;
    private String patientId;
    private String date;

    public Appointment(String doctorId, String patientId, String date) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment Details:\n" +
                "Doctor ID: " + doctorId + "\n" +
                "Patient ID: " + patientId + "\n" +
                "Date: " + date + "\n";
    }

    public String toFileString() {
        return doctorId + "," + patientId + "," + date;
    }

    public static Appointment fromFileString(String fileString) {
        String[] parts = fileString.split(",");
        return new Appointment(parts[0], parts[1], parts[2]);
    }
}
