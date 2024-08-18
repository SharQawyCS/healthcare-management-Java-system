package tv.codely.models;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppointmentOperationsFrame extends JFrame {
    private JButton addAppointmentButton;
    private JButton displayAppointmentsButton;

    public AppointmentOperationsFrame() {
        setTitle("Appointment Operations");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addAppointmentButton = new JButton("Add New Appointment");
        displayAppointmentsButton = new JButton("Display All Appointments");

        add(addAppointmentButton);
        add(displayAppointmentsButton);

        // Add action listeners to each button
        addAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAppointmentFrame().setVisible(true);
            }
        });

        displayAppointmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayAppointmentsFrame().setVisible(true);
            }
        });
    }
}
