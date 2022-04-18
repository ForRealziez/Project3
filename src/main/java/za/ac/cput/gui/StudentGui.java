package za.ac.cput.gui;

/*
 * StudentGui.java
 * author Chante Lewis : 216118395
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ListIterator;
import za.ac.cput.domain.Student;

public class StudentGui extends JFrame implements ActionListener {

    //STUDENT GUI
    private JFrame studentFrame;
    private JPanel panelStudentNorth, panelStudentSouth,panelStudentWest,panelStudentCenter;
    private JLabel lblWelcomeStudent,lblStudentID,lblFullname, lblSurname, lblEmail, lblPassword, lblCourse;;
    private JTextField txtStudentID,txtFullname, txtSurname, txtEmail;
    private JPasswordField txtPassword;
    private JComboBox cmbCourse;
    private JButton btnSave, btnUpdate, btnNext, btnBack;
    private Font ft1 = new Font("Arial", Font.BOLD, 20);
    //*******************************************************

    private ArrayList<Student> studentRecords;
    private ListIterator<Student> ListIterator;
    int size;

    public StudentGui() {

        // STUDENT GUI
        studentFrame = new JFrame("Student Details");
        studentFrame.setPreferredSize(new Dimension(400, 300));
        panelStudentNorth= new JPanel();
        panelStudentSouth = new JPanel();
        panelStudentWest = new JPanel();
        panelStudentCenter = new JPanel();
        lblWelcomeStudent = new JLabel("Welcome to Student Details",JLabel.CENTER);
        lblWelcomeStudent.setFont(ft1);
        lblStudentID = new JLabel(" Student ID: ");
        lblFullname = new JLabel(" Full Name: ");
        lblSurname = new JLabel(" Surname: ");
        lblEmail = new JLabel(" Email: ");
        lblPassword = new JLabel(" Password: ");
        lblCourse = new JLabel(" Course: ");
        txtStudentID = new JTextField();
        txtFullname = new JTextField();
        txtSurname = new JTextField();
        txtEmail = new JTextField();
        txtPassword = new JPasswordField();
        String listOfCourses[] = {"ITC", "Business", "Education", "Photograpy", "Engineering"};
        cmbCourse = new JComboBox(listOfCourses);
        cmbCourse.setPreferredSize(new Dimension(10,10));
        btnSave = new JButton("SAVE");
        btnUpdate = new JButton("UPDATE");
        btnNext= new JButton("NEXT");
        btnBack = new JButton("BACK");
        btnBack.setOpaque(true);
        //********************************************************

        studentRecords = new ArrayList();
        size = 0;
        studentRecords.add(new Student("123456","Chante","Lewis","clewis@gmail.com","1234",1));
        studentRecords.add(new Student("654321","Mina","Moo","mmoo@yahoo.com","0000",2));

    }

    public void runStudentGui() {
        //STUDENT GUI
        studentFrame.add(panelStudentNorth, BorderLayout.NORTH);
        studentFrame.add(panelStudentSouth, BorderLayout.SOUTH);
        studentFrame.add(panelStudentWest, BorderLayout.WEST);
        studentFrame.add(panelStudentCenter, BorderLayout.CENTER);
        panelStudentNorth.setLayout(new GridLayout(2, 1));
        panelStudentCenter.setLayout(new GridLayout(6, 1));
        panelStudentWest.setLayout(new GridLayout(6, 1));
        panelStudentSouth.setLayout(new GridLayout(2, 1));
        panelStudentNorth.add(lblWelcomeStudent);
        panelStudentWest.add(lblStudentID);
        panelStudentWest.add(lblFullname);
        panelStudentWest.add(lblSurname);
        panelStudentWest.add(lblEmail);
        panelStudentWest.add(lblPassword);
        panelStudentWest.add(lblCourse);
        panelStudentCenter.add(txtStudentID);
        panelStudentCenter.add(txtFullname);
        panelStudentCenter.add(txtSurname);
        panelStudentCenter.add(txtEmail);
        panelStudentCenter.add(txtPassword);
        panelStudentCenter.add(cmbCourse);
        panelStudentSouth.add(btnSave);
        panelStudentSouth.add(btnUpdate);
        panelStudentSouth.add(btnNext);
        panelStudentSouth.add(btnBack);
        btnSave.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnNext.addActionListener(this);
        btnBack.addActionListener(this);
        studentFrame.pack();
        studentFrame.show();
        studentFrame.setLocationRelativeTo(null);
        studentFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);}
        });

        //Access Student Class
        //***************************************************
        Student work;

        ListIterator = studentRecords.listIterator();

        work = ListIterator.next();
        txtFullname.setText(work.getFullname());
        txtSurname.setText(work.getSurname());
        txtEmail.setText(work.getEmail());
        txtPassword.setText(work.getPassword());
        cmbCourse.setSelectedIndex(work.getCourse());
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack) {
            cmbCourse.setSelectedIndex(0);
            txtFullname.setText("");
            txtSurname.setText("");
            txtEmail.setText("");
            txtPassword.setText("");
        }

//-------------------------------------------------------------------
//Code for Next Button
//-------------------------------------------------------------------
        switch (e.getActionCommand()) {
            case "NEXT" -> {
                size= studentRecords.size();
                if(((txtFullname.getText().equals("")) || (txtSurname.getText().equals(""))|| (txtEmail.getText().equals("")) || (txtPassword.getPassword().equals("")) || cmbCourse.getSelectedItem().equals(-1)))

                {
                    JOptionPane.showMessageDialog(null, "There empty fields.");
                }
                else if(ListIterator.hasNext()){
                    Student work;
                    work = ListIterator.next();
                    txtFullname.setText(work.getFullname());
                    txtSurname.setText(work.getSurname());
                    txtEmail.setText(work.getEmail());
                    txtPassword.setText(work.getPassword());
                    cmbCourse.setSelectedIndex(work.getCourse());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "You are on the last record.");
                }
            }

//-----------------------------------------------------------------------
//Code for Update Button
//-----------------------------------------------------------------------
            case "UPDATE" -> {
                if(((txtFullname.getText().equals("")) || (txtSurname.getText().equals(""))||(txtEmail.getText().equals("")) || (txtPassword.getPassword().equals(""))|| cmbCourse.getSelectedItem().equals(-1)))
                {
                    JOptionPane.showMessageDialog(null, "There are empty fields.");
                }
                else
                {
                    String fullname= txtFullname.getText();
                    String surname=txtSurname.getText();
                    String email= txtEmail.getText();
                    String password = txtPassword.getText();
                    int course = cmbCourse.getSelectedIndex();


                    for(Student student:studentRecords){
                        if(surname == null ? student.getSurname() == null : surname.equals((student.getSurname()))){
                            student.setFullname(fullname);
                            student.setEmail(email);
                            student.setPassword(password);
                            student.setCourse(course);
                            JOptionPane.showMessageDialog(null, "Record updated.");
                            break;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Surname cannot be changed.");
                            break;
                        }
                    }
                }
            }
        }

    }


    public static void main(String[] args) {

        new StudentGui().runStudentGui();

    }

}