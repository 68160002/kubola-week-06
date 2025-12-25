import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Lab04_7 {
    public static void main (String[] args){
        JFrame f = new JFrame("Easy Math Quiz 68160002");
        f.setSize(350,150);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        Random rand = new Random();

        int[] num1 = {rand.nextInt(21)};
        int[] num2 = {rand.nextInt(21)};
        char[] ops = {'+', '-', '*'};
        char[] op = {ops[rand.nextInt(ops.length)]};

        int[] count = {1};
        int[] score = {0};

        JLabel n1 = new JLabel(String.valueOf(num1[0]));
        JLabel opp = new JLabel(String.valueOf(op[0]));
        JLabel n2 = new JLabel(String.valueOf(num2[0]));
        JLabel equal = new JLabel("=");
        JTextField ans = new JTextField(5);

        JButton check = new JButton("Check Answer");
        JLabel result = new JLabel("Question 1 / 10");

        check.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userans = Integer.parseInt(ans.getText());
                    int correct = 0;

                    switch (op[0]) {
                        case '+':
                            correct = num1[0] + num2[0];
                            break;
                        case '-':
                            correct = num1[0] - num2[0];
                            break;
                        case '*':
                            correct = num1[0] * num2[0];
                            break;
                    }

                    if (userans == correct) {
                        score[0]++;
                    }

                    if (count[0] == 10) {
                        result.setText("Score: " + score[0] + " / 10");
                        check.setEnabled(false);
                        return;
                    }

                    count[0]++;
                    num1[0] = rand.nextInt(21);
                    num2[0] = rand.nextInt(21);
                    op[0] = ops[rand.nextInt(ops.length)];

                    n1.setText(String.valueOf(num1[0]));
                    n2.setText(String.valueOf(num2[0]));
                    opp.setText(String.valueOf(op[0]));
                    ans.setText("");

                    result.setText("Question " + count[0] + " / 10");

                } catch (NumberFormatException ex) {
                    result.setText("Enter Number Only!");
                }
            }
        });

        p1.add(n1);
        p1.add(opp);
        p1.add(n2);
        p1.add(equal);
        p1.add(ans);
        p1.add(check);
        p2.add(result);

        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.CENTER);
        f.setVisible(true);
    }
}

