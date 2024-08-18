package tv.codely.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenGUI extends JFrame {

    private JPanel contentPanel;
    private final Color MainBackgroundColor = new Color(70, 130, 180);


    public MainScreenGUI() {
        // Set up the frame
        setTitle("Healthcare Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header with background color
        JLabel headerLabel = new JLabel("Healthcare Management System", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        headerLabel.setOpaque(true);  // Allows background color to be set
        headerLabel.setBackground(MainBackgroundColor);  // Set your preferred background color
        headerLabel.setForeground(Color.WHITE);  // Set the text color to white
        add(headerLabel, BorderLayout.NORTH);

        // Navigation panel with buttons
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(4, 1, 10, 10));
        navPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        navPanel.setBackground(MainBackgroundColor);

        JButton doctorOperationsBtn = new JButton("Doctor Operations");
        styleButton(doctorOperationsBtn);

        JButton patientOperationsBtn = new JButton("Patient Operations");
        styleButton(patientOperationsBtn);

        JButton appointmentsBtn = new JButton("Appointments");
        styleButton(appointmentsBtn);

        JButton exitBtn = new JButton("Exit...");
        styleButton(exitBtn);



        navPanel.add(doctorOperationsBtn);
        navPanel.add(patientOperationsBtn);
        navPanel.add(appointmentsBtn);
        navPanel.add(exitBtn);

        add(navPanel, BorderLayout.WEST);

        // Content panel where the functionality will be displayed
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(contentPanel, BorderLayout.CENTER);

        // Button actions
        doctorOperationsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDoctorOperations();
            }
        });

        patientOperationsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPatientOperations();
            }
        });

        appointmentsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAppointments();
            }
        });

        exitBtn.addActionListener(e -> {
            int response = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to exit?",
                "Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });


        // Make the frame visible
        setVisible(true);
    }

    private void showDoctorOperations() {
        contentPanel.removeAll();

        // Header for Doctor Operations
        JLabel header = new JLabel("Doctor Operations", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        contentPanel.add(header, BorderLayout.NORTH);

        // Panel for Doctor Operations buttons
        JPanel doctorPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton addDoctorBtn = new JButton("Add New Doctor");
        JButton editDoctorBtn = new JButton("Edit Doctor");
        JButton displayDoctorsBtn = new JButton("Display All Doctors");
        JButton deleteDoctorBtn = new JButton("Delete Doctor");

        doctorPanel.add(addDoctorBtn);
        doctorPanel.add(editDoctorBtn);
        doctorPanel.add(displayDoctorsBtn);
        doctorPanel.add(deleteDoctorBtn);

        contentPanel.add(doctorPanel, BorderLayout.CENTER);

        contentPanel.revalidate();
        contentPanel.repaint();

        // Implement action listeners for each button (these should be connected to actual functionality)
        addDoctorBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Add Doctor functionality."));
        editDoctorBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Edit Doctor functionality."));
        displayDoctorsBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Display Doctors functionality."));
        deleteDoctorBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Delete Doctor functionality."));
    }

    private void showPatientOperations() {
        contentPanel.removeAll();

        // Header for Patient Operations
        JLabel header = new JLabel("Patient Operations", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        contentPanel.add(header, BorderLayout.NORTH);

        // Panel for Patient Operations buttons
        JPanel patientPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton addPatientBtn = new JButton("Add New Patient");
        JButton editPatientBtn = new JButton("Edit Patient");
        JButton displayPatientsBtn = new JButton("Display All Patients");
        JButton deletePatientBtn = new JButton("Delete Patient");

        patientPanel.add(addPatientBtn);
        patientPanel.add(editPatientBtn);
        patientPanel.add(displayPatientsBtn);
        patientPanel.add(deletePatientBtn);

        contentPanel.add(patientPanel, BorderLayout.CENTER);

        contentPanel.revalidate();
        contentPanel.repaint();

        // Implement action listeners for each button (these should be connected to actual functionality)
        addPatientBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Add Patient functionality."));
        editPatientBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Edit Patient functionality."));
        displayPatientsBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Display Patients functionality."));
        deletePatientBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Delete Patient functionality."));
    }

    private void showAppointments() {
        contentPanel.removeAll();

        // Header for Appointments
        JLabel header = new JLabel("Appointments", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        contentPanel.add(header, BorderLayout.NORTH);

        // Panel for Appointments buttons
        JPanel appointmentPanel = new JPanel(new GridLayout(2, 1, 10, 10));

        JButton addAppointmentBtn = new JButton("Add New Appointment");
        JButton displayAppointmentsBtn = new JButton("Display All Appointments");

        appointmentPanel.add(addAppointmentBtn);
        appointmentPanel.add(displayAppointmentsBtn);

        contentPanel.add(appointmentPanel, BorderLayout.CENTER);

        contentPanel.revalidate();
        contentPanel.repaint();

        // Implement action listeners for each button (these should be connected to actual functionality)
        addAppointmentBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Add Appointment functionality."));
        displayAppointmentsBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Display Appointments functionality."));
    }

    // Function to apply common styles to buttons
    private void styleButton(JButton button) {
        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.GRAY); // Change to gray on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 122, 255)); // Original color
            }
        });
    }

    public static void main(String[] args) {
        new MainScreenGUI();
    }
}
