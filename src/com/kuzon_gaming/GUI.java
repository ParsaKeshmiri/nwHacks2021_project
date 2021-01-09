package com.kuzon_gaming;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GUI implements ActionListener {

    ImageIcon logo = new ImageIcon("logo.png"); //application logo

    JButton male = new JButton("Male");
    JButton female = new JButton("Female");
    JButton exit = new JButton("Exit");

    JLabel title = new JLabel();

    JTextPane instructions = new JTextPane();
    JTextPane sex = new JTextPane();
    JTextPane weight = new JTextPane();

    JFrame frame = new JFrame();

    public GUI() {
        /* Title */
        title.setText("Quench Quest");
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 50));

        /* Instructions */
        Font font = new Font("Arial", Font.BOLD, 25);
        //instructions.setContentType("Arial");
        instructions.setText(("Tell us a bit about yourself"));
        instructions.setFont(font);
        instructions.setBackground(new Color(0x63c8ef));
        instructions.setForeground((Color.WHITE));
        instructions.setBounds(470, 133,613,61);

        instructions.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                instructions.setEditable(true);
                instructions.getCaret().setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                instructions.setEditable(false);
                instructions.getCaret().setVisible(false);
            }
        });



        frame.setTitle("Quench Quest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setExtendedState(JFrame.ICONIFIED);
            }
        });
        frame.setSize(1280,720);
        frame.setResizable(false);
        frame.add(instructions);
        frame.add(title);
        frame.setVisible(true);

        ImageIcon logo = new ImageIcon("logo.png");
        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(new Color (0x63c8ef));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
