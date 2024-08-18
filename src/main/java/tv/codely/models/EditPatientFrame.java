package tv.codely.models;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPatientFrame extends JFrame {
    private JTextField searchIdField;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField genderField;
    private JTextField symptomsField;
    private JTextField paymentField;
    private JTextField diagnosisField;
    private JTextField roomField;
    private JButton searchButton;
    private JButton saveButton;

    public EditPatientFrame() {
        setTitle("Edit Existing Patient");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        searchIdField = new JTextField("Enter ID to search");
        nameField = new JTextField("Name");
        addressField = new JTextField("Address");
        phoneField = new JTextField("Phone");
        genderField = new JTextField("Gender");
        symptomsField = new JTextField("Symptoms");
        paymentField = new JTextField("Payment Method");
        diagnosisField = new JTextField("Diagnosis");
        roomField = new JTextField("Room Number (Emergency Patients)");

        searchButton = new JButton("Search");
        saveButton = new JButton("Save Changes");

        add(searchIdField);
        add(searchButton);
        add(nameField);
        add(addressField);
        add(phoneField);
        add(genderField);
        add(symptomsField);
        add(paymentField);
        add(diagnosisField);
        add(roomField);
        add(saveButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = searchIdField.getText();
                Patient patient = HealthcareSystem.getInstance().getPatientById(id);

                if (patient != null) {
                    nameField.setText(patient.getName());
                    addressField.setText(patient.getAddress());
                    phoneField.setText(patient.getPhoneNumber());
                    genderField.setText(patient.getGender());
                    symptomsField.setText(patient.getSymptoms());
                    paymentField.setText(patient.getPaymentMethod());
                    diagnosisField.setText(patient.getDiagnosis());

                    if (patient instanceof EmergencyPatient) {
                        roomField.setText(((EmergencyPatient) patient).getRoomNumber());
                    } else {
                        roomField.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Patient not found!");
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = searchIdField.getText();
                Patient patient = HealthcareSystem.getInstance().getPatientById(id);

                if (patient != null) {
                    patient.setName(nameField.getText());
                    patient.setAddress(addressField.getText());
                    patient.setPhoneNumber(phoneField.getText());
                    patient.setGender(genderField.getText());
                    patient.setSymptoms(symptomsField.getText());
                    patient.setPaymentMethod(paymentField.getText());
                    patient.setDiagnosis(diagnosisField.getText());

                    if (patient instanceof EmergencyPatient) {
                        ((EmergencyPatient) patient).setRoomNumber(roomField.getText());
                    }

                    JOptionPane.showMessageDialog(null, "Patient updated successfully!");
                    HealthcareSystem.getInstance().savePatients();  // Ensure the data is saved
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error updating patient!");
                }
            }
        });
    }
}
