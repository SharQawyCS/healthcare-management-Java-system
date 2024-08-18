package tv.codely.models;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorOperations extends JFrame {

    public DoctorOperations() {
        // Set up the main frame for Doctor operations
        setTitle("Doctor Operations");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Create buttons for each operation
        JButton addDoctorBtn = new JButton("Add New Doctor");
        JButton editDoctorBtn = new JButton("Edit Doctor");
        JButton displayDoctorsBtn = new JButton("Display All Doctors");
        JButton deleteDoctorBtn = new JButton("Delete Doctor");

        // Add action listeners for each button
        addDoctorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDoctorFrame();
            }
        });

        editDoctorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditDoctorFrame();
            }
        });

        displayDoctorsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayDoctorsFrame();
            }
        });

        deleteDoctorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteDoctorFrame();
            }
        });

        // Add buttons to the frame
        add(addDoctorBtn);
        add(editDoctorBtn);
        add(displayDoctorsBtn);
        add(deleteDoctorBtn);

        // Set frame visibility
        setVisible(true);
    }
}
