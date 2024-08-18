package tv.codely.models;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAppointmentFrame extends JFrame {
    private JTextField doctorIdField;
    private JTextField patientIdField;
    private JTextField dateField;
    private JButton addButton;

    public AddAppointmentFrame() {
        setTitle("Add New Appointment");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        doctorIdField = new JTextField(15);
        patientIdField = new JTextField(15);
        dateField = new JTextField(15);
        addButton = new JButton("Add Appointment");

        add(new JLabel("Doctor ID:"));
        add(doctorIdField);
        add(new JLabel("Patient ID:"));
        add(patientIdField);
        add(new JLabel("Date (YYYY-MM-DD):"));
        add(dateField);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorId = doctorIdField.getText();
                String patientId = patientIdField.getText();
                String date = dateField.getText();

                if (!doctorId.isEmpty() && !patientId.isEmpty() && !date.isEmpty()) {
                    Appointment appointment = new Appointment(doctorId, patientId, date);
                    HealthcareSystem.getInstance().addAppointment(appointment);
                    JOptionPane.showMessageDialog(AddAppointmentFrame.this, "Appointment added successfully!");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(AddAppointmentFrame.this, "All fields are required.");
                }
            }
        });
    }

    private void clearFields() {
        doctorIdField.setText("");
        patientIdField.setText("");
        dateField.setText("");
    }
}
