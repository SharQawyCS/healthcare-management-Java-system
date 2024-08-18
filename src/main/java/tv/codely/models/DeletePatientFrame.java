package tv.codely.models;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePatientFrame extends JFrame {
    private JTextField idField;
    private JButton deleteButton;

    public DeletePatientFrame() {
        setTitle("Delete Patient");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        idField = new JTextField("Enter ID to delete");
        deleteButton = new JButton("Delete Patient");

        add(idField);
        add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                HealthcareSystem.getInstance().deletePatient(id);
                JOptionPane.showMessageDialog(null, "Patient deleted successfully!");
                dispose();
            }
        });
    }
}
