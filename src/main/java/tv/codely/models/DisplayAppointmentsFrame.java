package tv.codely.models;

import javax.swing.*;
import java.util.List;

public class DisplayAppointmentsFrame extends JFrame {
    private JTextArea appointmentsArea;

    public DisplayAppointmentsFrame() {
        setTitle("Display All Appointments");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        appointmentsArea = new JTextArea(15, 30);
        appointmentsArea.setEditable(false);
        add(new JScrollPane(appointmentsArea));

        displayAppointments();
    }

    private void displayAppointments() {
        List<Appointment> appointments = HealthcareSystem.getInstance().getAppointments();
        if (appointments.isEmpty()) {
            appointmentsArea.setText("No appointments available.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Appointment appointment : appointments) {
                sb.append("Doctor ID: ").append(appointment.getDoctorId()).append("\n");
                sb.append("Patient ID: ").append(appointment.getPatientId()).append("\n");
                sb.append("Date: ").append(appointment.getDate()).append("\n\n");
            }
            appointmentsArea.setText(sb.toString());
        }
    }
}
