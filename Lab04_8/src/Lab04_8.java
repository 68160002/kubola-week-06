import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab04_8 {
    public static void main(String[] args) {

        JFrame f = new JFrame("BMI Calculator");
        f.setSize(400,220);
        f.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel kgLabel = new JLabel("Weight (kg):");
        JTextField kgField = new JTextField(10);

        JLabel cmLabel = new JLabel("Height (cm):");
        JTextField cmField = new JTextField(10);

        inputPanel.add(kgLabel);
        inputPanel.add(kgField);
        inputPanel.add(cmLabel);
        inputPanel.add(cmField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton calcBtn = new JButton("Calculate");
        buttonPanel.add(calcBtn);

        JPanel resultPanel = new JPanel(new GridLayout(2,1));
        JLabel bmiValue = new JLabel("", SwingConstants.CENTER);
        JLabel bmiStatus = new JLabel("", SwingConstants.CENTER);

        resultPanel.add(bmiValue);
        resultPanel.add(bmiStatus);

        // ===== Action =====
        calcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double kg = Double.parseDouble(kgField.getText());
                    double cm = Double.parseDouble(cmField.getText());

                    double bmi = kg / Math.pow(cm / 100, 2);
                    bmiValue.setText(String.format("Your BMI is %.2f", bmi));

                    String body;
                    if (bmi < 16) body = "Seriously underweight";
                    else if (bmi < 18) body = "Underweight";
                    else if (bmi < 24) body = "Normal weight";
                    else if (bmi < 29) body = "Overweight";
                    else if (bmi < 35) body = "Seriously overweight";
                    else body = "Gravely overweight";

                    bmiStatus.setText("You are " + body);

                } catch (NumberFormatException ex) {
                    bmiValue.setText("Please enter numbers only");
                    bmiStatus.setText("");
                }
            }
        });

        f.add(inputPanel, BorderLayout.NORTH);
        f.add(buttonPanel, BorderLayout.CENTER);
        f.add(resultPanel, BorderLayout.SOUTH);

        f.setVisible(true);
    }
}
