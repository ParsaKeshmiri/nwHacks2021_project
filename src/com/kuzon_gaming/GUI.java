package com.kuzon_gaming;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    ImageIcon logo = new ImageIcon("logo.png"); //application logo

    JButton male = new JButton("Male");
    JButton female = new JButton("Female");
    JButton exit = new JButton("Exit");

    JLabel title = new JLabel();
    JTextPane instructions = new JTextPane();
    JFrame frame = new JFrame();

    public GUI() {
        /* Title */
        title.setText("Quench Quest");
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 50));

        /* Instructions */
        instructions.setText("Please Enter The Following");



        frame.setTitle("Quench Quest");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setExtendedState(JFrame.ICONIFIED);
            }
        });
        frame.setSize(1280,720);
        frame.setResizable(true);
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
