package tv.codely.models;

public class EmergencyPatient extends Patient {
    private String roomNumber;

    public EmergencyPatient(String id, String name, String address, String phoneNumber, String gender, String symptoms, String paymentMethod, String diagnosis, String roomNumber) {
        super(id, name, address, phoneNumber, gender, symptoms, paymentMethod, diagnosis, roomNumber);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "Room Number: " + roomNumber + "\n";
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "," + roomNumber;
    }

    public static EmergencyPatient fromFileString(String fileString) {
        String[] parts = fileString.split(",");
        return new EmergencyPatient(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
    }
}
