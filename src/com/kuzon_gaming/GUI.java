package com.kuzon_gaming;

import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.TimerTask;

public class GUI extends JFrame implements ActionListener, ChangeListener {

    ImageIcon logo = new ImageIcon("logo.png"); //application logo

    JFrame frame = new JFrame();

    JLabel title = new JLabel();
    JButton exit = new JButton("Exit");
    JTextPane sipCounter = new JTextPane();
    JTextPane levelDisplay = new JTextPane();

    // Set up for initial screen
    JTextPane instructions = new JTextPane();
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
    private int weightInPounds;

    // Set up for second screen
    JTextPane reminder = new JTextPane();
    JTextPane clock = new JTextPane();
    JTextPane hoursDisplay = new JTextPane();
    JTextPane minutesDisplay = new JTextPane();
    JTextPane secondsDisplay = new JTextPane();


    // Set up for third screen
    JTextPane timeToDrink = new JTextPane();
    JButton drankConfirmation = new JButton("I Drank");
    ImageIcon glass = new ImageIcon("glass.png");
    JLabel picture;


    private GameInstance player;


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
        lbs.setText("lbs");
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

                } else {
                    isWeightEmpty = false;
                    if (isMale || isFemale)
                        isButtonEnabled = true;
                    else isButtonEnabled = false;
                }
            }
        });

        /* Exit Button */
        exit.setBounds(1116, 600, 83, 37);
        exit.setFocusable(false);
        exit.setBackground(new Color(0x63c3e3));
        exit.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        exit.setForeground(Color.white);
        exit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
                    try {
                        weightInPounds = Integer.valueOf(weightIn.getText());
                    } catch (NumberFormatException d) {
                    }
                    player = new GameInstance(isMale, weightInPounds);

                    instructions.setVisible(false);
                    instructions.setEnabled(false);
                    sex.setVisible(false);
                    sex.setEnabled(false);
                    weight.setVisible(false);
                    weight.setEnabled(false);
                    male.setVisible(false);
                    male.setEnabled(false);
                    female.setVisible(false);
                    female.setEnabled(false);
                    weightIn.setVisible(false);
                    weightIn.setEnabled(false);
                    lbs.setVisible(false);
                    lbs.setEnabled(false);
                    submit.setVisible(false);
                    submit.setEnabled(false);

                    gameGUI();

                }
            }
        });


        /* Frame */
        //TODO Add wave graphic to the bottom empty space
        frame.setTitle("Quench Quest");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setExtendedState(JFrame.ICONIFIED);
            }
        });

        frame.setSize(1280,720);
        frame.setResizable(false);

        frame.add(sipCounter);
        frame.add(levelDisplay);
        frame.add(drankConfirmation);
        frame.add(timeToDrink);
        frame.add(reminder);
        frame.add(clock);
        frame.add(hoursDisplay);
        frame.add(minutesDisplay);
        frame.add(secondsDisplay);
        frame.add(instructions);
        frame.add(sex);
        frame.add(weight);
        frame.add(male);
        frame.add(female);
        frame.add(weightIn);
        frame.add(lbs);
        frame.add(submit);
        frame.add(exit);
        frame.add(title);
        frame.setVisible(true);

        ImageIcon logo = new ImageIcon("C:\\Users\\parsa\\IdeaProjects\\nwHacks2021\\src\\logo.png");
        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(new Color (0x63c8ef));

        ImageIcon img = new ImageIcon("C:\\Users\\parsa\\IdeaProjects\\nwHacks2021\\src\\glass.png");
        picture = new JLabel(img, JLabel.CENTER);
        frame.add(picture);

        picture.setVisible(false);
        picture.setEnabled(false);
    }

    int timeRemaining;
    int seconds;
    int minutes;
    int hours;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);
    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            timeRemaining -= 1;
            hours = (timeRemaining/3600);
            minutes = (timeRemaining/60) % 60;
            seconds = (timeRemaining) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            clock.setText(hours_string+" : "+minutes_string+" : "+seconds_string);

            if (seconds == 0 && minutes == 0 && hours == 0) {
                timer.stop();
                drinkGUI();
            }
        }

    });

    private void gameGUI() {

        hoursDisplay.setEnabled(true);
        hoursDisplay.setVisible(true);
        minutesDisplay.setEnabled(true);
        minutesDisplay.setVisible(true);
        secondsDisplay.setEnabled(true);
        secondsDisplay.setVisible(true);
        reminder.setEnabled(true);
        reminder.setVisible(true);
        clock.setEnabled(true);
        clock.setVisible(true);
        sipCounter.setEnabled(true);
        sipCounter.setVisible(true);
        levelDisplay.setEnabled(true);
        levelDisplay.setVisible(true);

        sipCounter.setText("Total sips: " + player.totalSips);
        sipCounter.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        sipCounter.setBackground(new Color(0x63c8ef));
        sipCounter.setForeground((Color.WHITE));
        sipCounter.setBounds(10, 10,187,42);

        sipCounter.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                sipCounter.setEditable(true);
                sipCounter.getCaret().setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                sipCounter.setEditable(false);
                sipCounter.getCaret().setVisible(false);
            }
        });

        levelDisplay.setText("Level " + player.level + " - " + player.title);
        levelDisplay.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        levelDisplay.setBackground(new Color(0x63c8ef));
        levelDisplay.setForeground((Color.WHITE));
        levelDisplay.setBounds(10, 45, 445,42);

        levelDisplay.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                levelDisplay.setEditable(true);
                levelDisplay.getCaret().setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                levelDisplay.setEditable(false);
                levelDisplay.getCaret().setVisible(false);
            }
        });

        reminder.setText("Remember to drink water in...");
        reminder.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        reminder.setBackground(new Color(0x63c8ef));
        reminder.setForeground((Color.WHITE));
        reminder.setBounds(460, 133,613,40);

        reminder.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                reminder.setEditable(true);
                reminder.getCaret().setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                reminder.setEditable(false);
                reminder.getCaret().setVisible(false);
            }
        });

        hoursDisplay.setText("Hours");
        hoursDisplay.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        hoursDisplay.setBackground(new Color(0x63c8ef));
        hoursDisplay.setForeground((Color.WHITE));
        hoursDisplay.setBounds(352, 375, 100, 30);

        hoursDisplay.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                hoursDisplay.setEditable(true);
                hoursDisplay.getCaret().setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                hoursDisplay.setEditable(false);
                hoursDisplay.getCaret().setVisible(false);
            }
        });

        minutesDisplay.setText("Minutes");
        minutesDisplay.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        minutesDisplay.setBackground(new Color(0x63c8ef));
        minutesDisplay.setForeground((Color.WHITE));
        minutesDisplay.setBounds(592, 375, 115, 30);

        minutesDisplay.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                minutesDisplay.setEditable(true);
                minutesDisplay.getCaret().setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                minutesDisplay.setEditable(false);
                minutesDisplay.getCaret().setVisible(false);
            }
        });

        secondsDisplay.setText("Seconds");
        secondsDisplay.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        secondsDisplay.setBackground(new Color(0x63c8ef));
        secondsDisplay.setForeground((Color.WHITE));
        secondsDisplay.setBounds(838, 375, 115, 30);

        secondsDisplay.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                secondsDisplay.setEditable(true);
                secondsDisplay.getCaret().setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                secondsDisplay.setEditable(false);
                secondsDisplay.getCaret().setVisible(false);
            }
        });

        timeRemaining = player.drinkingIntervalSeconds;

        hours = (timeRemaining/3600);
        minutes = (timeRemaining/60) % 60;
        seconds = (timeRemaining) % 60;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        clock.setText(hours_string+" : "+minutes_string+" : "+seconds_string);

        clock.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
        clock.setBackground(new Color(0x63c8ef));
        clock.setForeground((Color.WHITE));
        clock.setBounds(330, 240,800,125);

        clock.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                clock.setEditable(false);
                clock.getCaret().setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                clock.setEditable(false);
                clock.getCaret().setVisible(false);
            }
        });

        timer.start();

    }

    private void drinkGUI() {
        clock.setVisible(false);
        clock.setEnabled(false);
        reminder.setVisible(false);
        reminder.setEnabled(false);
        hoursDisplay.setVisible(false);
        hoursDisplay.setEnabled(false);
        minutesDisplay.setVisible(false);
        minutesDisplay.setEnabled(false);
        secondsDisplay.setVisible(false);
        secondsDisplay.setEnabled(false);

        timeToDrink.setEnabled(true);
        timeToDrink.setVisible(true);
        drankConfirmation.setEnabled(true);
        drankConfirmation.setVisible(true);
        picture.setVisible(true);
        picture.setEnabled(true);

        timeToDrink.setText("Time to Drink!");
        timeToDrink.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 40));
        timeToDrink.setBackground(new Color(0x63c8ef));
        timeToDrink.setForeground((Color.WHITE));
        timeToDrink.setBounds(486, 510,400,60);

        timeToDrink.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                timeToDrink.setEditable(false);
                timeToDrink.getCaret().setVisible(false);
            }

            @Override
            public void focusGained(FocusEvent e) {
                timeToDrink.setEditable(false);
                timeToDrink.getCaret().setVisible(false);
            }
        });

        drankConfirmation.setBounds(576,593,120,45);
        drankConfirmation.setFocusable(false);
        drankConfirmation.setBackground(new Color(0x63c3e3));
        drankConfirmation.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        drankConfirmation.setForeground(Color.white);
        drankConfirmation.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

        drankConfirmation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drankConfirmation.setVisible(false);
                drankConfirmation.setEnabled(false);
                timeToDrink.setVisible(false);
                timeToDrink.setEnabled(false);
                picture.setVisible(false);
                picture.setEnabled(false);
                reminder.setEnabled(true);
                reminder.setVisible(true);
                clock.setEnabled(true);
                clock.setVisible(true);
                hoursDisplay.setEnabled(true);
                hoursDisplay.setVisible(true);
                minutesDisplay.setEnabled(true);
                minutesDisplay.setVisible(true);
                secondsDisplay.setEnabled(true);
                secondsDisplay.setVisible(true);
                player.sipWater();
                gameGUI();
            }
        });

        /*setSize(400,400);
        setLayout(new FlowLayout());*/

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
