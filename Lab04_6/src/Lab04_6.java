import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Lab04_6 {
    public static void main (String[] args){
        JFrame f = new JFrame("Easy Math Quiz 68160002");
        f.setSize(350,150);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        Random rand = new Random();
        int num1 = rand.nextInt(21);
        int num2 = rand.nextInt(21);
        char[] ops = {'+', '-', '*'};
        char op = ops[rand.nextInt(ops.length)];

        JLabel n1 = new JLabel(String.valueOf(num1));
        JLabel opp = new JLabel(String.valueOf(op));

        JLabel n2 = new JLabel(String.valueOf(num2));
        JLabel equal = new JLabel("=");
        JTextField ans = new JTextField(5);

        JButton check = new JButton("Check Answer");
        JLabel result = new JLabel();
        check.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int userans = Integer.parseInt(ans.getText());
                    int correct = 0;
                    switch (op) {
                        case '+':
                            opp.setText("+");
                            correct = num1 + num2;
                            break;
                        case '-':
                            opp.setText("-");
                            correct = num1 - num2;
                            break;
                        case '*':
                            opp.setText("*");
                            correct = num1 * num2;
                            break;
                    }

                    if(userans == correct){
                        result.setText("Correct Answer :D");
                    } else {
                        result.setText("Wrong Answer :(");
                    }
                } catch (NumberFormatException exception){
                    result.setText("Enter Number Only >:(");
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
        f.add(p2,BorderLayout.CENTER);
        f.setVisible(true);
    }
}

