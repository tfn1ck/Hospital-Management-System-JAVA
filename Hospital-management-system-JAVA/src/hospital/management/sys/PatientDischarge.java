package hospital.management.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class PatientDischarge extends JFrame {
    PatientDischarge() {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(102, 167, 197));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK OUT");
        label.setBounds(100,20,200,20);
        label.setFont(new Font("serif",Font.BOLD,20));
        panel.add(label);

        JLabel label_1 = new JLabel("Customer ID");
        label_1.setBounds(30,80,100,20);
        label_1.setFont(new Font("serif",Font.BOLD,14));
        panel.add(label_1);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try {
            connection c = new connection();
            ResultSet resultSet = c.s.executeQuery("select * from patient_info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Number"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label_3 = new JLabel("Room Number");
        label_3.setBounds(30,130,100,20);
        label_3.setFont(new Font("serif",Font.BOLD,14));
        panel.add(label_3);

        JLabel Room_no = new JLabel();
        Room_no.setBounds(200,130,100,20);
        Room_no.setFont(new Font("serif",Font.BOLD,14));
        panel.add(Room_no);

        JLabel label_4 = new JLabel("In Time");
        label_4.setBounds(30,180,100,20);
        label_4.setFont(new Font("serif",Font.BOLD,14));
        panel.add(label_4);

        JLabel in_time = new JLabel();
        in_time.setBounds(200,180,300,20);
        in_time.setFont(new Font("serif",Font.BOLD,14));
        panel.add(in_time);

        JLabel label_5 = new JLabel("Out Time");
        label_5.setBounds(30,230,300,20);
        label_5.setFont(new Font("serif",Font.BOLD,14));
        panel.add(label_5);

        Date date = new Date();
        JLabel out_time = new JLabel(""+date);
        out_time.setBounds(200,230,300,20);
        out_time.setFont(new Font("serif",Font.BOLD,14));
        panel.add(out_time);

        JButton discharge_btn = new JButton("Discharge");
        discharge_btn.setBounds(30,300,120,30);
        discharge_btn.setBackground(new Color(240, 236, 235));
        panel.add(discharge_btn);
        discharge_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection c = new connection();
                try {
                    c.s.executeUpdate("delete from patient_info where Number = '"+choice.getSelectedItem()+"'");
                    c.s.executeUpdate("update room set Avaibility = 'Available' where room_no = '"+Room_no.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Discharge Successful");
                    setVisible(false);
                }catch (Exception Ex) {
                    Ex.printStackTrace();
                }

            }
        });

        JButton check_btn = new JButton("Check");
        check_btn.setBounds(170,300,120,30);
        check_btn.setBackground(new Color(240, 236, 235));
        panel.add(check_btn);
        check_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection c = new connection();
                try {
                    ResultSet resultSet = c.s.executeQuery("select * from patient_info where Number = '"+choice.getSelectedItem()+"'");
                    while (resultSet.next()) {
                        Room_no.setText(resultSet.getString("Room_Number"));
                        in_time.setText(resultSet.getString("Time"));
                    }
                }catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton back_btn = new JButton("Back");
        back_btn.setBounds(300,300,120,30);
        back_btn.setBackground(new Color(240, 236, 235));
        panel.add(back_btn);
        back_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,200);
        setVisible(true);
    }

    public static void main(String  [] args) {
        new PatientDischarge();
    }
}
