package hospital.management.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160, 1525, 670);
        panel.setBackground(new Color(102, 167, 197));
        add(panel);

        JPanel top_panel = new JPanel();
        top_panel.setLayout(null);
        top_panel.setBounds(5, 5, 1525, 150);
        top_panel.setBackground(new Color(163, 214, 245));
        add(top_panel);

        JLabel header = new JLabel("Reception :)");
        header.setBounds(1100, 20, 500, 100);
        header.setFont(new Font("serif", Font.BOLD, 50));
        top_panel.add(header);

        JButton button_1 = new JButton("Add New Patient");
        button_1.setBounds(30, 15, 200, 30);
        button_1.setBackground(new Color(240, 236, 235));
        top_panel.add(button_1);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewPatient();
            }
        });

        JButton button_2 = new JButton("Rooms");
        button_2.setBounds(30, 60, 200, 30);
        button_2.setBackground(new Color(240, 236, 235));
        top_panel.add(button_2);
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton button_3 = new JButton("Departments");
        button_3.setBounds(30, 100, 200, 30);
        button_3.setBackground(new Color(240, 236, 235));
        top_panel.add(button_3);
        button_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton button_4 = new JButton("Employee Information");
        button_4.setBounds(270, 15, 200, 30);
        button_4.setBackground(new Color(240, 236, 235));
        top_panel.add(button_4);
        button_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeInfo();
            }
        });

        JButton button_5 = new JButton("Patient Information");
        button_5.setBounds(270, 60, 200, 30);
        button_5.setBackground(new Color(240, 236, 235));
        top_panel.add(button_5);
        button_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientInfo();
            }
        });

        JButton button_6 = new JButton("Patient Discharge");
        button_6.setBounds(270, 100, 200, 30);
        button_6.setBackground(new Color(240, 236, 235));
        top_panel.add(button_6);
        button_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientDischarge();
            }
        });

        JButton button_7 = new JButton("Update Patient Details");
        button_7.setBounds(510, 15, 200, 30);
        button_7.setBackground(new Color(240, 236, 235));
        top_panel.add(button_7);
        button_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientUpdate();
            }
        });

        JButton button_8 = new JButton("Ambulance");
        button_8.setBounds(510, 60, 200, 30);
        button_8.setBackground(new Color(240, 236, 235));
        top_panel.add(button_8);
        button_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });

        JButton button_9 = new JButton("Search Rooms");
        button_9.setBounds(510, 100, 200, 30);
        button_9.setBackground(new Color(240, 236, 235));
        top_panel.add(button_9);
        button_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });

        JButton button_10 = new JButton("Logout");
        button_10.setBounds(750, 100, 200, 30);
        button_10.setBackground(new Color(240, 236, 235));
        top_panel.add(button_10);
        button_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main();
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1950, 1080);
        getContentPane().setBackground(new Color(248, 228, 204));
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Reception();
    }

}
