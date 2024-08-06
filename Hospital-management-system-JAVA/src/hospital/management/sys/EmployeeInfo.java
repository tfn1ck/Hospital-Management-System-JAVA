package hospital.management.sys;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeInfo extends JFrame {
    EmployeeInfo() {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(163, 214, 245));
        panel.setLayout(null);
        add(panel);

        JLabel header = new JLabel("ALL EMPLOYEE DETAILS");
        header.setBounds(350,-60,500,200);
        header.setFont(new Font("Tahoma",Font.BOLD,25));
        panel.add(header);

        JTable table = new JTable();
        table.setBounds(10,100,980,300);
        table.setBackground(new Color(102,167,197));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);

        try {
            connection c =new connection();
            String query = "select * from Employee_info;";
            ResultSet resultSet = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label_1 = new JLabel("Name");
        label_1.setBounds(20,60,60,30);
        label_1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_1);

        JLabel label_2 = new JLabel("Age");
        label_2.setBounds(160,60,60,30);
        label_2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_2);

        JLabel label_3 = new JLabel("Number");
        label_3.setBounds(300,60,100,30);
        label_3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_3);

        JLabel label_4 = new JLabel("Salary");
        label_4.setBounds(440,60,60,30);
        label_4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_4);

        JLabel label_5 = new JLabel("Email");
        label_5.setBounds(580,60,60,30);
        label_5.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_5);

        JLabel label_6 = new JLabel("Aadhar Number");
        label_6.setBounds(720,60,200,30);
        label_6.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_6);

        JLabel label_7 = new JLabel("Position");
        label_7.setBounds(860,60,100,30);
        label_7.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_7);

        JButton button_1 = new JButton("Add New Employee");
        button_1.setBackground(new Color(240, 236, 235));
        button_1.setBounds(200,450,200,30);
        panel.add(button_1);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });

        JButton button_2 = new JButton("Update Employee Details");
        button_2.setBackground(new Color(240, 236, 235));
        button_2.setBounds(430,450,200,30);
        panel.add(button_2);
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeUpdate();
            }
        });

        JButton button_3 = new JButton("Back");
        button_3.setBackground(new Color(240, 236, 235));
        button_3.setBounds(670,450,100,30);
        panel.add(button_3);
        button_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1000,600);
        setLocation(350,230);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String [] args) {
        new EmployeeInfo();
    }
}
