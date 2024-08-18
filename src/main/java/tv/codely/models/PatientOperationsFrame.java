package tv.codely.models;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientOperationsFrame extends JFrame {
    private JButton addPatientButton;
    private JButton editPatientButton;
    private JButton deletePatientButton;
    private JButton displayAllPatientsButton;
    private JButton displayEmergencyPatientsButton;

    public PatientOperationsFrame() {
        setTitle("Patient Operations");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addPatientButton = new JButton("Add New Patient");
        editPatientButton = new JButton("Edit Existing Patient");
        deletePatientButton = new JButton("Delete Patient");
        displayAllPatientsButton = new JButton("Display All Patients");
        displayEmergencyPatientsButton = new JButton("Display Emergency Patients");

        add(addPatientButton);
        add(editPatientButton);
        add(deletePatientButton);
        add(displayAllPatientsButton);
        add(displayEmergencyPatientsButton);

        // Add action listeners to each button
        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatientFrame().setVisible(true);
            }
        });

        editPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditPatientFrame().setVisible(true);
            }
        });

        deletePatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeletePatientFrame().setVisible(true);
            }
        });

        displayAllPatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayAllPatientsFrame().setVisible(true);
            }
        });

        displayEmergencyPatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayEmergencyPatientsFrame().setVisible(true);
            }
        });
    }
}
