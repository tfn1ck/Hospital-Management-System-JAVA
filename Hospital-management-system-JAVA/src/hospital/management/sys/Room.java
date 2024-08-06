package hospital.management.sys;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {
    Room() {

        JTable table;

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(102,167,197));
        panel.setLayout(null);
        add(panel);

        JLabel header = new JLabel("ROOMS");
        header.setBounds(400,11,260,60);
        header.setFont(new Font("Tahoma", Font.BOLD, 25));
        panel.add(header);

        table = new JTable();
        table.setBounds(200,150,500,300);
        table.setBackground(new Color(206,235,251));
        panel.add(table);

        try {
            connection c = new connection();
            String query = "select * from room";
            ResultSet resultSet = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label_1 = new JLabel("Room No.");
        label_1.setBounds(200,120,80,15);
        label_1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label_1);

        JLabel label_2 = new JLabel("Availability");
        label_2.setBounds(320,120,100,15);
        label_2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label_2);

        JLabel label_3 = new JLabel("Price");
        label_3.setBounds(450,120,80,15);
        label_3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label_3);

        JLabel label_4 = new JLabel("Room Type");
        label_4.setBounds(580,120,80,15);
        label_4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label_4);

        JButton button_1 = new JButton("Back");
        button_1.setBounds(380,480,120,30);
        button_1.setBackground(new Color(240,236,235));
        panel.add(button_1);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);
    }

    public static void main(String [] args) {
        new Room();
    }
}
