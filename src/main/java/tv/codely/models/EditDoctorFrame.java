package tv.codely.models;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditDoctorFrame extends JFrame {

    private JTextField idField;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField specialtyField;
    private JButton submitButton;
    private JButton cancelButton;

    public EditDoctorFrame() {
        setTitle("Edit Doctor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel idLabel = new JLabel("Doctor ID:");
        idLabel.setBounds(10, 20, 100, 25);
        panel.add(idLabel);

        idField = new JTextField(20);
        idField.setBounds(120, 20, 165, 25);
        panel.add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 60, 100, 25);
        panel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(120, 60, 165, 25);
        panel.add(nameField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(10, 100, 100, 25);
        panel.add(addressLabel);

        addressField = new JTextField(20);
        addressField.setBounds(120, 100, 165, 25);
        panel.add(addressField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(10, 140, 100, 25);
        panel.add(phoneLabel);

        phoneField = new JTextField(20);
        phoneField.setBounds(120, 140, 165, 25);
        panel.add(phoneField);

        JLabel specialtyLabel = new JLabel("Specialty:");
        specialtyLabel.setBounds(10, 180, 100, 25);
        panel.add(specialtyLabel);

        specialtyField = new JTextField(20);
        specialtyField.setBounds(120, 180, 165, 25);
        panel.add(specialtyField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 220, 100, 25);
        panel.add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 220, 100, 25);
        panel.add(cancelButton);

        add(panel);

        // Action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String name = nameField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();
                String specialty = specialtyField.getText();

                HealthcareSystem system = HealthcareSystem.getInstance();
                Doctor doctor = system.getDoctorById(id);

                if (doctor != null) {
                    doctor.setName(name);
                    doctor.setAddress(address);
                    doctor.setPhoneNumber(phone);
                    doctor.setSpecialty(specialty);

                    JOptionPane.showMessageDialog(null, "Doctor information updated successfully!");
                    dispose(); // Close the frame after updating
                } else {
                    JOptionPane.showMessageDialog(null, "Doctor ID not found!");
                }
            }
        });

        // Action listener for the cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the frame without making changes
            }
        });
        setVisible(true);
    }
}
