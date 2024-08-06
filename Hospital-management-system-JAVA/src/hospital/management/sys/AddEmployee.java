package hospital.management.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class AddEmployee extends JFrame {
    JComboBox<String> comboBox;
    JTextField textField_position,textField_aadhar,textField_email,textField_age,text_number, text_name, textField_salary, textField_deposit;
    JButton button_1, button_2;

    AddEmployee() {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(102,167,197));
        panel.setLayout(null);
        add(panel);

        JLabel header = new JLabel("EMPLOYEE FORM");
        header.setBounds(320,11,260,60);
        header.setFont(new Font("Tahoma", Font.BOLD, 25));
        panel.add(header);

        JLabel label_name = new JLabel("Name: ");
        label_name.setBounds(260,86,200,20);
        label_name.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_name);

        text_name = new JTextField();
        text_name.setBounds(471,86,150,20);
        panel.add(text_name);

        JLabel label_age = new JLabel("Age: ");
        label_age.setBounds(260,131,200,25);
        label_age.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_age);

        textField_age = new JTextField();
        textField_age.setBounds(471,131,150,20);
        panel.add(textField_age);

        JLabel label_number = new JLabel("Number: ");
        label_number.setBounds(260,171,200,25);
        label_number.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_number);

        text_number = new JTextField();
        text_number.setBounds(471,171,150,20);
        panel.add(text_number);

        JLabel label_sick = new JLabel("Salary: ");
        label_sick.setBounds(260,210,200,25);
        label_sick.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_sick);

        textField_salary = new JTextField();
        textField_salary.setBounds(471,210,150,20);
        panel.add(textField_salary);

        JLabel label_room = new JLabel("Email: ");
        label_room.setBounds(260,250,200,25);
        label_room.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_room);

        textField_email = new JTextField();
        textField_email.setBounds(471,250,150,20);
        panel.add(textField_email);

        JLabel label_time = new JLabel("Aadhar Number: ");
        label_time.setBounds(260,290,200,25);
        label_time.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_time);

        textField_aadhar = new JTextField();
        textField_aadhar.setBounds(471,290,150,20);
        panel.add(textField_aadhar);

        JLabel label_deposit = new JLabel("Position: ");
        label_deposit.setBounds(260,330,200,25);
        label_deposit.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_deposit);

        textField_position = new JTextField();
        textField_position.setBounds(471,330,150,20);
        panel.add(textField_position);

        button_1 = new JButton("Add Details");
        button_1.setBounds(260, 430, 120,30);
        button_1.setBackground(new Color(240,236,235));
        panel.add(button_1);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection conn = new connection();
                String s1 = text_name.getText();
                String s2 = textField_age.getText();
                String s3 = text_number.getText();
                String s4 = textField_salary.getText();
                String s5 = textField_email.getText();
                String s6 = textField_aadhar.getText();
                String s7 = textField_position.getText();

                try {
                    String query = "insert into Employee_info values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Data Added Successfully");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }

            }
        });

        button_2 = new JButton("Cancel");
        button_2.setBounds(471,430,120,30);
        button_2.setBackground(new Color(240,236,235));
        panel.add(button_2);
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeInfo();
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);
    }


    public static void main(String [] args) {
        new AddEmployee();
    }
}
