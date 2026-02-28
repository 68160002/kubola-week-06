import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lab06_5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("แกลเลอรีรูปภาพ");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // รายชื่อไฟล์รูป
        String[] images = {
                "D:/image.png",
                "D:/image2.png",
                "D:/image3.png"
        };

        for (String path : images) {
            // โหลดและย่อรูป
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(img));

            // เมื่อคลิกรูป
            label.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    showLargeImage(path);
                }
            });

            panel.add(label);
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    // แสดงรูปขนาดใหญ่
    private static void showLargeImage(String path) {
        JFrame imgFrame = new JFrame("รูปขนาดใหญ่");
        imgFrame.setSize(500, 500);

        ImageIcon icon = new ImageIcon(path);
        JLabel imgLabel = new JLabel(icon);

        imgFrame.add(new JScrollPane(imgLabel));
        imgFrame.setVisible(true);
    }


}
