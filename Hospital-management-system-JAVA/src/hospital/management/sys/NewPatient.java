package hospital.management.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewPatient extends JFrame {

    JComboBox<String> comboBox;
    JTextField textField_number, text_name, textField_sick, textField_deposit;
    JRadioButton radio_1, radio_2;
    Choice choice;
    JLabel date;
    JButton button_1, button_2;

    NewPatient() {

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(102,167,197));
        panel.setLayout(null);
        add(panel);

        JLabel header = new JLabel("PATIENT FORM");
        header.setBounds(320,11,260,60);
        header.setFont(new Font("Tahoma", Font.BOLD, 25));
        panel.add(header);

        JLabel label_ID = new JLabel("ID: ");
        label_ID.setBounds(260,86,200,15);
        label_ID.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_ID);

        comboBox = new JComboBox<>(new String[]{"Aadhar Card", "Voter ID", "Driving License", "PAN Card"});
        comboBox.setBounds(471,86,150, 20);
        comboBox.setBackground(new Color(248,228,204));
        panel.add(comboBox);

        JLabel label_number = new JLabel("Number: ");
        label_number.setBounds(260,131,200,15);
        label_number.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_number);

        textField_number = new JTextField();
        textField_number.setBounds(471,131,150,20);
        panel.add(textField_number);

        JLabel label_name = new JLabel("Name: ");
        label_name.setBounds(260,171,200,15);
        label_name.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_name);

        text_name = new JTextField();
        text_name.setBounds(471,171,150,20);
        panel.add(text_name);

        JLabel label_gender = new JLabel("Select Gender: ");
        label_gender.setBounds(260,210,200,15);
        label_gender.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_gender);

        radio_1 = new JRadioButton("Male");
        radio_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        radio_1.setBackground(new Color(102,167,197));
        radio_1.setBounds(471,210,80,15);
        panel.add(radio_1);

        radio_2 = new JRadioButton("Female");
        radio_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        radio_2.setBackground(new Color(102,167,197));
        radio_2.setBounds(551,210,80,15);
        panel.add(radio_2);

        ButtonGroup group = new ButtonGroup();
        group.add(radio_1);
        group.add(radio_2);

        JLabel label_sick = new JLabel("Problem: ");
        label_sick.setBounds(260,250,200,15);
        label_sick.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_sick);

        textField_sick = new JTextField();
        textField_sick.setBounds(471,250,150,20);
        panel.add(textField_sick);

        JLabel label_room = new JLabel("Room no.: ");
        label_room.setBounds(260,290,200,15);
        label_room.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_room);

        choice = new Choice();
        try {
            connection c = new connection();
            ResultSet resultSet = c.s.executeQuery("select * from room");
            while(resultSet.next()) {
                choice.add(resultSet.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        choice.setBounds(471,290,150,20);
        choice.setFont(new Font("Tahoma", Font.PLAIN, 14));
        choice.setBackground(new Color(248,228,204));
        panel.add(choice);

        JLabel label_time = new JLabel("Entry Time: ");
        label_time.setBounds(260,330,200,15);
        label_time.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_time);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(471,330,250,16);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(date);

        JLabel label_deposit = new JLabel("Deposit Amount: ");
        label_deposit.setBounds(260,370,200,15);
        label_deposit.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(label_deposit);

        textField_deposit = new JTextField();
        textField_deposit.setBounds(471,370,150,20);
        panel.add(textField_deposit);

        button_1 = new JButton("Add Details");
        button_1.setBounds(260, 430, 120,30);
        button_1.setBackground(new Color(240,236,235));
        panel.add(button_1);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection conn = new connection();
                String radioBTN = null;
                if (radio_1.isSelected()) {
                    radioBTN = "Male";
                } else if (radio_2.isSelected()) {
                    radioBTN = "Female";
                }
                String s1 = (String) comboBox.getSelectedItem();
                String s2 = textField_number.getText();
                String s3 = text_name.getText();
                String s4 = radioBTN;
                String s5 = textField_sick.getText();
                String s6 = choice.getSelectedItem();
                String s7 = date.getText();
                String s8 = textField_deposit.getText();

                try {
                    String query = "insert into patient_info values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                    String query_1 = "update room set Avaibility = 'Occupied' where room_no = " + s6;
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query_1);
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
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NewPatient();
    }
}
