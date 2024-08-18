package tv.codely.models;

import javax.swing.*;
import java.awt.*;

public class DisplayDoctorsFrame extends JFrame {
    public DisplayDoctorsFrame() {
        setTitle("Display All Doctors");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        HealthcareSystem system = HealthcareSystem.getInstance();
        for (Doctor doctor : system.getAllDoctors()) {
            textArea.append(doctor.toString() + "\n");
        }

        setVisible(true);
    }
}
