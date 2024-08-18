package tv.codely.models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDoctorFrame extends JFrame {
    private JTextField nameField, idField, addressField, phoneField, specialtyField;
    private JButton submitBtn;

    public AddDoctorFrame() {
        setTitle("Add New Doctor");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        // Input fields
        idField = new JTextField();
        nameField = new JTextField();
        addressField = new JTextField();
        phoneField = new JTextField();
        specialtyField = new JTextField();

        // Labels
        add(new JLabel("ID: "));
        add(idField);
        add(new JLabel("Name: "));
        add(nameField);
        add(new JLabel("Address: "));
        add(addressField);
        add(new JLabel("Phone: "));
        add(phoneField);
        add(new JLabel("Specialty: "));
        add(specialtyField);

        // Submit button
        submitBtn = new JButton("Add Doctor");
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add doctor to the system
                HealthcareSystem system = HealthcareSystem.getInstance();
                system.addDoctor(new Doctor(idField.getText(), nameField.getText(), addressField.getText(), phoneField.getText(), specialtyField.getText()));
                JOptionPane.showMessageDialog(null, "Doctor added successfully!");
                dispose();
            }
        });
        add(submitBtn);

        setVisible(true);
    }
}
