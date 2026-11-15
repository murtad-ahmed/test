import javax.swing.*;
import java.awt.*;

public class AppointmentsViewer extends JFrame {
    public AppointmentsViewer() {
        setTitle("جدول المواعيد المحجوزة");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        StringBuilder content = new StringBuilder("--- سجل الحجوزات الحالي ---\n\n");
        for (String appointment : GlobalData.appointmentsList) {
            content.append(appointment).append("\n--------------------------\n");
        }
        displayArea.setText(content.toString());

        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnBack = new JButton("العودة للرئيسية");
        btnBack.addActionListener(e -> {
            new MainFrame().setVisible(true);
            this.dispose();
        });
        add(btnBack, BorderLayout.SOUTH);
    }
}