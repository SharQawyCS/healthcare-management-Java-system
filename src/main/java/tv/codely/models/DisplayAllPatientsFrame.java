package tv.codely.models;

import javax.swing.*;
import java.awt.*;

public class DisplayAllPatientsFrame extends JFrame {
    private JTextArea textArea;

    public DisplayAllPatientsFrame() {
        setTitle("All Patients");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        StringBuilder sb = new StringBuilder();
        for (Patient patient : HealthcareSystem.getInstance().getAllPatients()) {
            sb.append(patient.toString()).append("\n\n");
        }

        textArea.setText(sb.toString());
    }
}
