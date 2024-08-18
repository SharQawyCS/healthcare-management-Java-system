package tv.codely;

import tv.codely.models.AppointmentOperationsFrame;
import tv.codely.models.DoctorOperations;
import tv.codely.models.PatientOperationsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {
        // TODO THIS FOR CLI ONLY - uncomment it to DISABLE GUI
//        HealthcareSystem healthcareSystem = new HealthcareSystem();
//        MainScreen mainScreen = new MainScreen();
//        Scanner scanner = new Scanner(System.in);
//
//        while (mainScreen.show){
//            mainScreen.showMainScreen();
//        }

        // TODO GUI GUI GUI GUI GUI GUI GUI GUI GUI GUI GUI GUI GUI GUI GUI GUI GUI
        // Create the main frame
        JFrame mainFrame = new JFrame("Healthcare Management System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridLayout(3, 1));

        // Create buttons
        JButton doctorBtn = new JButton("Doctor Operations");
        JButton patientBtn = new JButton("Patient Operations");
        JButton appointmentBtn = new JButton("Appointments");

        // Add action listeners
        doctorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoctorOperations();
            }
        });

        patientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientOperationsFrame().setVisible(true);
            }
        });

        appointmentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AppointmentOperationsFrame().setVisible(true);
            }
        });

        // Add buttons to the frame
        mainFrame.add(doctorBtn);
        mainFrame.add(patientBtn);
        mainFrame.add(appointmentBtn);

        // Set frame visibility
        mainFrame.setVisible(true);
    }

    private static void openNewWindow(String message) {
        // Create a new frame for the button click
        JFrame newFrame = new JFrame("Operation");
        newFrame.setSize(300, 200);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add a label with the message
        JLabel label = new JLabel(message, SwingConstants.CENTER);
        newFrame.add(label);

        // Set frame visibility
        newFrame.setVisible(true);

    }
}
