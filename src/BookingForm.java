import javax.swing.*;
import java.awt.*;import javax.swing.*;
import java.awt.*;import javax.swing.*;
import java.awt.*;import javax.swing.*;
import java.awt.*;import javax.swing.*;
import java.awt.*;import javax.swing.*;
import java.awt.*;import javax.swing.*;
import java.awt.*;import javax.swing.*;
import java.awt.*;import javax.swing.*;
import java.awt.*;import javax.swing.*;
import java.awt.*;import javax.swing.*;
import java.awt.*;import javax.swing.*;
import java.awt.*;import javax.swing.*;
import java.awt.*;
public class BookingForm extends JFrame {
    private JTextField nameField = new JTextField();
    private JTextField timeField = new JTextField();
    private String doctorName;

    public BookingForm(String doctorName) {
        this.doctorName = doctorName;
        setTitle("بيانات الحجز - د. " + doctorName);
        setSize(350, 400);
        setLocationRelativeTo(null);

        JPanel formPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        formPanel.add(new JLabel("اسم المريض:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("الوقت المناسب:"));
        formPanel.add(timeField);

        JButton btnConfirm = new JButton("تأكيد الحجز الآن");
        btnConfirm.setBackground(new Color(70, 130, 180)); // لون أزرق هادئ
        btnConfirm.setForeground(Color.WHITE);
        formPanel.add(new JLabel("")); // مسافة
        formPanel.add(btnConfirm);

        add(formPanel);

        btnConfirm.addActionListener(e -> {
            String pName = nameField.getText();
            String pTime = timeField.getText();

            if (pName.isEmpty() || pTime.isEmpty()) {
                JOptionPane.showMessageDialog(this, "يرجى ملء جميع الحقول", "تنبيه", JOptionPane.WARNING_MESSAGE);
            } else {
                String record = "المريض: " + pName + " | الطبيب: " + doctorName + " | الوقت: " + pTime;
                GlobalData.appointmentsList.add(record);
                JOptionPane.showMessageDialog(this, "تم الحجز بنجاح!");
                new MainFrame().setVisible(true);
                this.dispose();
            }
        });
    }
}