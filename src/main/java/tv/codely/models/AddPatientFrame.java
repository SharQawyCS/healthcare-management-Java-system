package tv.codely.models;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPatientFrame extends JFrame {
    private JTextField idField;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField genderField;
    private JTextField symptomsField;
    private JTextField paymentField;
    private JTextField diagnosisField;
    private JTextField roomField;
    private JButton saveButton;

    public AddPatientFrame() {
        setTitle("Add New Patient");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        idField = new JTextField("Enter ID");
        nameField = new JTextField("Enter Name");
        addressField = new JTextField("Enter Address");
        phoneField = new JTextField("Enter Phone Number");
        genderField = new JTextField("Enter Gender");
        symptomsField = new JTextField("Enter Symptoms");
        paymentField = new JTextField("Enter Payment Method");
        diagnosisField = new JTextField("Enter Diagnosis");
        roomField = new JTextField("Enter Room Number (Only for Emergency Patients)");

        saveButton = new JButton("Save Patient");

        add(idField);
        add(nameField);
        add(addressField);
        add(phoneField);
        add(genderField);
        add(symptomsField);
        add(paymentField);
        add(diagnosisField);
        add(roomField);
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();
                String gender = genderField.getText();
                String symptoms = symptomsField.getText();
                String payment = paymentField.getText();
                String diagnosis = diagnosisField.getText();
                String room = roomField.getText();

                Patient patient;
                if (room.isEmpty()) {
                    patient = new Patient(id, name, address, phone, gender, symptoms, payment, diagnosis);
                } else {
                    patient = new EmergencyPatient(id, name, address, phone, gender, symptoms, payment, diagnosis, room);
                }

                HealthcareSystem.getInstance().addPatient(patient);
                JOptionPane.showMessageDialog(null, "Patient Added Successfully!");
                dispose();
            }
        });
    }
}
