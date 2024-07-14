package org.example;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static org.example.CirclesComponent.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();


//        JPanel inputPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel();
        JTextField circleNumbersField = new JTextField(3);
        JButton drawButton = new JButton("Draw");

//        inputPanel.add(circleNumbersField,BorderLayout.WEST);
//        inputPanel.add(drawButton,BorderLayout.EAST);
        inputPanel.add(circleNumbersField);
        inputPanel.add(drawButton);

        CirclesComponent circlesComponent = new CirclesComponent();
        circlesComponent.setCirclesCount(1);

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int circlesCount = 0;
                try {
                    circlesCount = Integer.parseInt(circleNumbersField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                           "Circles count is not a valid number",
                            "Invalid input data",
                            JOptionPane.ERROR_MESSAGE);
                    circleNumbersField.setText("");
                    return;
                }

                System.out.println(circlesCount);
                circlesComponent.setCirclesCount(circlesCount);
            }
        });

        frame.add(inputPanel, BorderLayout.SOUTH);
        frame.add(circlesComponent,BorderLayout.CENTER);

//        frame.setSize(500,600);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        System.out.println("Started GUI!");
    }
}