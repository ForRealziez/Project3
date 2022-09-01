package za.ac.cput.gui;
/*
     Project 3
     Author: Titilayo Nikelwa Ore-ofe Akinjole (220283982)
     Staff Login GUI
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;



public class StaffLoginGUI implements ActionListener{
    //Creating object of JFrame class
    JFrame frame2;

    //Objects

    JLabel headerLabel = new JLabel("Please enter email address and password to login");

    JLabel CPUTImage = new JLabel(new ImageIcon("CPUT.jpg"));

    JLabel emailLabel = new JLabel("Email Address: ");
    JTextField emailTextField = new JTextField();

    JLabel passwordLabel = new JLabel("Password: ");
    JPasswordField passwordField = new JPasswordField();

    JLabel newAccountLabel = new JLabel("If you don't have an account, click ");

    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JButton forgotPasswordButton = new JButton("Forgot password");

    private Font font1;
    private Font font2;
    //Constructor

    StaffLoginGUI(){
        createWindows();
        setLocationAndSizes();
        addComponentsToFrames();
    }
    public void createWindows(){
        //Properties of JFrame
        frame2 = new JFrame();
        frame2.setTitle("Staff Login Form");
        frame2.setBounds(40,40,420,800);
        frame2.getContentPane().setBackground(Color.decode("#17252A"));
        frame2.getContentPane().setLayout(null);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(true);

        registerButton.setForeground(Color.white);
        registerButton.setBackground(Color.decode("#3AAFA9"));

        font1 = new Font("Times New Roman", Font.BOLD | Font.ITALIC,15);
        font2 = new Font("Courier", Font.ITALIC,25);
    }

    public void setLocationAndSizes(){
        headerLabel.setBounds(20,130,400,70);
        headerLabel.setFont(font1);

        CPUTImage.setBounds(85,10,250,140);

        emailLabel.setBounds(20,170,100,70);
        emailTextField.setBounds(240,193,165,23);

        passwordLabel.setBounds(20,220,170,70);
        passwordField.setBounds(240,243,165,23);

        newAccountLabel.setBounds(20,360,250,70);

        loginButton.setBounds(70,320,100,35);
        registerButton.setBounds(237,377,100,35);
        forgotPasswordButton.setBounds(170,320,150,35);

    }

    public void addComponentsToFrames(){
        frame2.add(headerLabel);
        frame2.add(CPUTImage);
        frame2.add(emailLabel);
        frame2.add(emailTextField);
        frame2.add(passwordLabel);
        frame2.add(passwordField);
        frame2.add(newAccountLabel);
        frame2.add(loginButton);
        frame2.add(registerButton);
        frame2.add(forgotPasswordButton);

        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        forgotPasswordButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){

            switch (e.getActionCommand()) {

                case "Register" -> {

                    StaffRegisterGUI register = new StaffRegisterGUI();
                    register.setVisible(true);
                    register.show();

                    break;
                }

                case "Login" -> {
                    String email = emailTextField.getText();
                    String psd = passwordField.getText();

                    if (email.equals("staff@cput.com") && psd.equals("password")){

                    JOptionPane.showMessageDialog(null, "Login successful");
                }
                    else if (email.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please insert email address");
                    }
                    else if (psd.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please insert password");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "User not found, Please register");
                    }

                    break;

                }


            }


        }






    public static void main(String[] args) {
        new StaffLoginGUI();



    }


        }
