import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab06_4 {
    public static void main(String[] args) {

        // สร้างหน้าต่าง
        JFrame f = new JFrame("Button with Image");
        f.setSize(300, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);

        // โหลดรูปภาพ
        ImageIcon pic1 = new ImageIcon("D:/image.png");

        // ปรับขนาดรูปภาพ
        Image img = pic1.getImage();
        Image scaledImg = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        // สร้างปุ่มพร้อมรูปภาพ
        JButton b1 = new JButton(scaledIcon);

        // ตั้งค่าขนาดปุ่ม
        b1.setPreferredSize(new Dimension(150, 150));

        // เหตุการณ์เมื่อคลิกปุ่ม
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame bigFrame = new JFrame("Big Image");
                bigFrame.setSize(500, 500);
                bigFrame.setLocationRelativeTo(null);

                Image bigImg = pic1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
                ImageIcon bigIcon = new ImageIcon(bigImg);

                JLabel label = new JLabel(bigIcon);
                label.setHorizontalAlignment(JLabel.CENTER);

                bigFrame.add(label);
                bigFrame.setVisible(true);
            }
        });

        // จัด layout และเพิ่มปุ่ม
        f.setLayout(new FlowLayout());
        f.add(b1);

        // แสดงหน้าต่าง
        f.setVisible(true);
    }


}

