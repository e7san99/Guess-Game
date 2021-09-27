package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel lgs, result, footer;
    private static ImageIcon imageIcon, scaledIcon;
    private static Image image,modify;
    private static JTextField textField;
    private static JButton button, reset;
    private static int number, enterValue;
    private static int count = 0;
    private static Random random;

    public static void main(String[] args) {
       panel = new JPanel();
       panel.setLayout(null);

       frame = new JFrame();
       frame.setTitle("Guess Game");
       frame.setSize(350,400);
       frame.add(panel);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       frame.setLocationRelativeTo(null);
       random = new Random();
       number = random.nextInt(10)+1;

        image();

        textfield();

        button();


        footer();

        frame.setVisible(true);
    } //End Main Class


    private static void image() {
        lgs = new JLabel(); //lgs = lets get started
        lgs.setBounds(55,20,220,150);
        panel.add(lgs);
        imageIcon = new ImageIcon("C:\\Users\\LENOVO\\IdeaProjects\\Guess Game\\src\\com\\company\\gg.png");
        image = imageIcon.getImage();
        modify = image.getScaledInstance(lgs.getWidth(), lgs.getHeight(), Image.SCALE_SMOOTH);
        scaledIcon = new ImageIcon(modify);
        lgs.setIcon(scaledIcon);
    }

    private static void textfield() {
        textField = new JTextField();
        textField.setBounds(110,220,100,50);
        textField.setFont(new Font("Tahoma",Font.ITALIC,20));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(textField);
    }

    private static void button() {
        button = new JButton("check");
        button.setBounds(120,300,80,20);
        button.addActionListener(e -> {

            try {
                enterValue = Integer.parseInt(textField.getText());
                if (enterValue > number)
                    JOptionPane.showMessageDialog(null, "Less than this Number");
                else if (enterValue < number)
                    JOptionPane.showMessageDialog(null, "More than this Number");
                if (enterValue == number) {
                    JOptionPane.showMessageDialog(null, "Congratulation.!");
                    reSet(random);
                    result("Success");
                    result.setFont(new Font("Tahoma", Font.ITALIC,20));
                    panel.add(result);
                    textField.setEnabled(false);
                    button.setEnabled(false);
                }
            }catch (Throwable ex) {
                JOptionPane.showMessageDialog(null, "Enter a Number");
            }
            count();
        });
        panel.add(button);
    }

    private static void reSet(Random random) {
        reset = new JButton("Reset");
        reset.setBounds(230,250,70,18);
        reset.addActionListener(e->{
            count=-1;
            count();
            number = random.nextInt(5)+1;
            textField.setEnabled(true);
            textField.setText(null);
            button.setEnabled(true);
            footer.setVisible(true);
            result.setText(null);
            reset.setVisible(false);
        });
        panel.add(reset);
    }

    private static void count() {
        count++;
        if (count==3 && enterValue !=number) {
            JOptionPane.showMessageDialog(null, "You're Failed");
            textField.setEnabled(false);
            button.setEnabled(false);
            reSet(random);
            result("Failed");
            result.setFont(new Font("Tahoma", Font.ITALIC,20));
            panel.add(result);
        }
        if (count==1) {
            footer.setVisible(false);
        }
    }

    private static void result(String text) {
        result = new JLabel(text);
        result.setBounds(125,185,80,20);
        panel.add(result);
    }

    private static void footer() {
        footer = new JLabel("Enter Number Between 1 to 10");
        footer.setBounds(70, 185, 200, 20);
        panel.add(footer);
    }

}