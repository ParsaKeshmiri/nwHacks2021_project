package com.kuzon_gaming;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class GUI extends JFrame implements ActionListener, ChangeListener {

    ImageIcon logo = new ImageIcon("logo.png"); //application logo

    JFrame frame = new JFrame();

    JLabel title = new JLabel();
    JButton exit = new JButton("Exit");
    JTextPane instructions = new JTextPane();

    // Set up
    private boolean isMale;
    private boolean isFemale;
    JTextPane sex = new JTextPane();
    JToggleButton male = new JToggleButton("Male");
    JToggleButton female = new JToggleButton("Female");
    JTextPane weight = new JTextPane();
    JTextField weightIn = new JTextField();
    JTextPane lbs = new JTextPane();
    JButton submit = new JButton("Continue");
    private boolean isWeightEmpty;
    private boolean isButtonEnabled;


    public GUI() {
        /* Title */
        title.setText("Quench Quest");
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Valken", Font.BOLD, 50));


        /* Instructions */
        Font fontInstructions = new Font("Comic Sans MS", Font.BOLD, 25);
        instructions.setText("Tell us a bit about yourself");
        instructions.setFont(fontInstructions);
        instructions.setBackground(new Color(0x63c8ef));
        instructions.setForeground((Color.WHITE));
        instructions.setBounds(470, 133,613,40);

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

        Font fontUserInfo = new Font("Comic Sans MS", Font.BOLD, 18);

        /* Sex Input */
        sex.setText("Sex: ");
        sex.setFont(fontUserInfo);
        sex.setBackground(new Color(0x63c8ef));
        sex.setForeground((Color.WHITE));
        sex.setBounds(519, 230, 42,32);

        sex.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                sex.setEditable(true);
                sex.getCaret().setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                sex.setEditable(false);
                sex.getCaret().setVisible(false);
            }
        });

        /* Weight Input */
        weight.setText("Weight: ");
        weight.setFont(fontUserInfo);
        weight.setBackground(new Color(0x63c8ef));
        weight.setForeground((Color.WHITE));
        weight.setBounds(492, 290, 73, 32);

        weight.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                weight.setEditable(true);
                weight.getCaret().setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                weight.setEditable(false);
                weight.getCaret().setVisible(false);
            }
        });

        /* Weight Unit */
        lbs.setText("lbs"); //make slider between kgs and lbs
        lbs.setFont(fontUserInfo);
        lbs.setBackground(new Color(0x63c8ef));
        lbs.setForeground((Color.WHITE));
        lbs.setBounds(670, 290, 69, 32);

        lbs.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                lbs.setEditable(true);
                lbs.getCaret().setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                lbs.setEditable(false);
                lbs.getCaret().setVisible(false);
            }
        });

        /* Sex Buttons */
        male.setBounds(580,227,83,37);
        male.setFocusable(false);
        male.setBackground(new Color(0x63c3e3));
        male.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        male.setForeground(Color.white);
        male.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        male.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    isMale = true;
                    isFemale = false;
                }
        });



        female.setBounds(670,227,83,37);
        female.setFocusable(false);
        female.setBackground(new Color(0x63c3e3));
        female.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        female.setForeground(Color.white);
        female.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        female.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isFemale = true;
                isMale = false;
            }
        });


        /* Weight Text Field */
        weightIn.setBounds(580, 288, 83, 37);
        weightIn.setHorizontalAlignment(SwingConstants.RIGHT);
        Font weightInFont = new Font("Comic Sans MS", Font.PLAIN, 20);
        weightIn.setFont(weightInFont);

        /* Verify Weight Meets Conditions */
        weightIn.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }
            public void removeUpdate(DocumentEvent e) {
                changed();
            }
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            public void changed() {
                if (weightIn.getText().equals("")) {
                    isWeightEmpty = true;
                    isButtonEnabled = false;
                    System.out.println("wtf");
                } else {
                    isWeightEmpty = false;
                    if (isMale || isFemale)
                        isButtonEnabled = true;
                    else isButtonEnabled = false;
                }
            }
        });

        /* Submit Button */
        submit.setBounds(574, 380, 95, 37);
        submit.setFocusable(false);
        submit.setBackground(new Color(0x63c3e3));
        submit.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        submit.setForeground(Color.white);
        submit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isButtonEnabled) {
                    System.out.println("wtf you actually did it");
                }
            }
        });


        /* Frame */
        //TODO Add wave graphic to the bottom empty space
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
        frame.add(sex);
        frame.add(weight);
        frame.add(male);
        frame.add(female);
        frame.add(weightIn);
        frame.add(lbs);
        frame.add(submit);
        frame.add(title);
        frame.setVisible(true);

        ImageIcon logo = new ImageIcon("logo.png");
        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(new Color (0x63c8ef));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
