package hospital.management.sys;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PatientInfo extends JFrame {
    PatientInfo() {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(163, 214, 245));
        panel.setLayout(null);
        add(panel);

        JLabel header = new JLabel("PATIENT INFORMATION");
        header.setBounds(285,10, 380, 60);
        header.setFont(new Font("Tahoma",Font.BOLD,25));
        panel.add(header);

        JTable table = new JTable();
        table.setBounds(10,90,900,300);
        table.setBackground(new Color(102, 167, 197));
        table.setFont(new Font("Tahoma", Font.BOLD,12));
        panel.add(table);

        try {
            connection c = new connection();
            String query = "select * from patient_info";
            ResultSet resultSet = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label_1 = new JLabel("ID Type");
        label_1.setBounds(20,60,60,30);
        label_1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_1);

        JLabel label_2 = new JLabel("ID Number");
        label_2.setBounds(130,60,100,30);
        label_2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_2);

        JLabel label_3 = new JLabel("Name");
        label_3.setBounds(240,60,60,30);
        label_3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_3);

        JLabel label_4 = new JLabel("Gender");
        label_4.setBounds(350,60,60,30);
        label_4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_4);

        JLabel label_5 = new JLabel("Disease");
        label_5.setBounds(460,60,60,30);
        label_5.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_5);

        JLabel label_6 = new JLabel("Room No.");
        label_6.setBounds(575,60,100,30);
        label_6.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_6);

        JLabel label_7 = new JLabel("Time of Entry");
        label_7.setBounds(690,60,150,30);
        label_7.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_7);

        JLabel label_8 = new JLabel("Deposit");
        label_8.setBounds(800,60,60,30);
        label_8.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label_8);

        JButton button_1 = new JButton("Add New Patient");
        button_1.setBackground(new Color(240, 236, 235));
        button_1.setBounds(140,450,200,30);
        panel.add(button_1);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton button_2 = new JButton("Update Patient Details");
        button_2.setBackground(new Color(240, 236, 235));
        button_2.setBounds(350,450,200,30);
        panel.add(button_2);
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JButton button_3 = new JButton("Back");
        button_3.setBackground(new Color(240, 236, 235));
        button_3.setBounds(560,450,100,30);
        panel.add(button_3);
        button_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900,600);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String [] args) {
        new PatientInfo();
    }
}
