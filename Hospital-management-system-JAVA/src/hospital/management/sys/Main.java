package hospital.management.sys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton button_1, button_2;

    Main() {

        JLabel headingLabel = new JLabel("HOSPITAL MANAGEMENT SYSTEM");
        headingLabel.setBounds(150, 20, 500, 30);
        headingLabel.setFont(new Font("Serif", Font.BOLD, 25));
        add(headingLabel);

        JLabel name_Label = new JLabel("Username");
        name_Label.setBounds(200, 75, 100, 30);
        name_Label.setFont(new Font("Serif", Font.BOLD, 17));
        add(name_Label);

        JLabel password = new JLabel("Password");
        password.setBounds(200, 145, 100, 30);
        password.setFont(new Font("Serif", Font.BOLD, 17));
        add(password);

        textField = new JTextField();
        textField.setBounds(300, 76, 150, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(Color.WHITE);
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(300, 147, 150, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jPasswordField.setBackground(Color.WHITE);
        add(jPasswordField);

        button_1 = new JButton("Login");
        button_1.setBounds(200, 210, 120, 30);
        button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        button_1.addActionListener(this);
        add(button_1);

        button_2 = new JButton("Cancel");
        button_2.setBounds(350, 210, 120, 30);
        button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        button_2.addActionListener(this);
        add(button_2);

        getContentPane().setBackground(new Color(102,167,197));
        setSize(750, 300);
        setLocation(400, 270);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button_1) {
            try {
                connection c = new connection();
                Connection conn = c.c;

                String user = textField.getText();
                String pass = new String(jPasswordField.getPassword());

                String query = "SELECT * FROM login WHERE id = '" + user + "' AND pw = '" + pass + "'";
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);


                if (resultSet.next()) {
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == button_2) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
