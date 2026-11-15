import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JButton btnBook = new JButton("حجز موعد جديد");
    private JButton btnView = new JButton("عرض المواعيد السابقة");

    public MainFrame() {
        setTitle("نظام حجز المواعيد الطبية");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 10, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel lblWelcome = new JLabel("أهلاً بك في نظام الحجز", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 16));

        mainPanel.add(lblWelcome);
        mainPanel.add(btnBook);
        mainPanel.add(btnView);

        add(mainPanel);


        btnBook.addActionListener(e -> {
            new DoctorSelector().setVisible(true);
            this.dispose();
        });

        btnView.addActionListener(e -> {
            new AppointmentsViewer().setVisible(true);
            this.dispose();
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}