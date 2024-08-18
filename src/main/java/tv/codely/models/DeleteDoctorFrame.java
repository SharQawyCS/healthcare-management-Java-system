package tv.codely.models;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDoctorFrame extends JFrame {
    private JTextField idField;
    private JButton deleteBtn;

    public DeleteDoctorFrame() {
        setTitle("Delete Doctor");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        idField = new JTextField();
        deleteBtn = new JButton("Delete");

        add(new JLabel("Doctor ID: "));
        add(idField);
        add(deleteBtn);

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HealthcareSystem system = HealthcareSystem.getInstance();
                if (system.deleteDoctor(idField.getText())) {
                    JOptionPane.showMessageDialog(null, "Doctor deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Doctor not found.");
                }
                dispose();
            }
        });

        setVisible(true);
    }
}
