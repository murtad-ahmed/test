import javax.swing.*;
import java.awt.*;

public class DoctorSelector extends JFrame {
    public DoctorSelector() {
        setTitle("اختر الطبيب المتخصص");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("قائمة الأطباء المتاحين", SwingConstants.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        JPanel docPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        docPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JButton doc1 = new JButton("دكتور رعد");
        JButton doc2 = new JButton("دكتور مقتدى");

        docPanel.add(doc1);
        docPanel.add(doc2);
        add(docPanel, BorderLayout.CENTER);


        doc1.addActionListener(e -> openBookingForm("د.مقتدى"));
        doc2.addActionListener(e -> openBookingForm("د.رضا"));
    }

    private void openBookingForm(String name) {
        new BookingForm(name).setVisible(true);
        this.dispose();
    }
}