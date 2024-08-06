package hospital.management.sys;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department() {

        JLabel header = new JLabel("Departments");
        header.setBounds(285,-80,300,200);
        header.setFont(new Font("tahoma",Font.BOLD,20));
        add(header);

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(163,214,245));
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,80,700,300);
        table.setBackground(new Color(163,214,245));
        table.setFont(new Font("serif",Font.BOLD,14));
        panel.add(table);

        try {
            connection c = new connection();
            String query = "select * from department";
            ResultSet resultSet = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label_1 = new JLabel("Department Name");
        label_1.setBounds(0,45,200,30);
        label_1.setFont(new Font("serif",Font.BOLD,17));
        panel.add(label_1);

        JLabel label_2 = new JLabel("Contact Number");
        label_2.setBounds(365,45,200,30);
        label_2.setFont(new Font("serif",Font.BOLD,17));
        panel.add(label_2);

        JButton button_1 = new JButton("Back");
        button_1.setBounds(265,410,130,30);
        button_1.setBackground(new Color(240,236,235));
        panel.add(button_1);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);

    }

    public static void main(String [] args) {
        new Department();
    }
}
