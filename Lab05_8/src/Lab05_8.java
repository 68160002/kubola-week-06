import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Lab05_8 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Chotika Thepsorn 68160002 n53");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As");
        JMenuItem exitItem = new JMenuItem("Exit");

        menuFile.add(newItem);
        menuFile.add(openItem);
        menuFile.add(saveItem);
        menuFile.add(saveAsItem);
        menuFile.add(exitItem);

        menuBar.add(menuFile);
        frame.setJMenuBar(menuBar);

        final File[] file = new File[1];

        newItem.addActionListener(e -> {
            textArea.setText("");
            file[0] = null;
        });

        openItem.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                file[0] = chooser.getSelectedFile();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file[0]));
                    textArea.setText("");
                    String line;
                    while ((line = br.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                    br.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Open file error");
                }
            }
        });

        saveItem.addActionListener(e -> {
            if (file[0] == null) {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    file[0] = chooser.getSelectedFile();
                }
            }
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file[0]));
                bw.write(textArea.getText());
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Save file error");
            }
        });

        saveAsItem.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                try {
                    file[0] = chooser.getSelectedFile();
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file[0]));
                    bw.write(textArea.getText());
                    bw.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Save As error");
                }
            }
        });

        exitItem.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}
