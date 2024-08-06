package hospital.management.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeUpdate extends JFrame {
    EmployeeUpdate() {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(102, 167, 197));
        panel.setLayout(null);
        add(panel);

        JLabel label1 = new JLabel("Update Employee Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,140,25);
        panel.add(choice);

        try {
            connection c= new connection();
            ResultSet resultSet = c.s.executeQuery("select * from Employee_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Age :");
        label3.setBounds(25,129,150,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,129,140,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("Number  :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label4);

        JTextField textFieldINTIme = new JTextField();
        textFieldINTIme.setBounds(248,174,140,20);
        panel.add(textFieldINTIme);

        JLabel label5 = new JLabel("Salary :");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,216,140,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Email :");
        label6.setBounds(25,261,150,14);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,261,140,20);
        panel.add(textFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setBackground(new Color(240, 236, 235));
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from Employee_info where Name = '"+id+"'";
                try{
                    connection c = new connection();
                    ResultSet resultSet = c.s.executeQuery(q);
                    while (resultSet.next()){
                        textFieldR.setText(resultSet.getString("Age"));
                        textFieldINTIme.setText(resultSet.getString("Number"));
                        textFieldAmount.setText(resultSet.getString("Salary"));
                    }

                    ResultSet resultSet1 = c.s.executeQuery("select * from room where room_no = '"+textFieldR.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("Salary");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(56,378,89,23);
        update.setBackground(new Color(240, 236, 235));
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    connection c = new connection();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTIme.getText();
                    String amount = textFieldAmount.getText();
                    c.s.executeUpdate("update Employee_info set  = Deposit = '"+amount+"' where name = '"+q+"'" );
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(168,378,89,23);
        back.setBackground(new Color(240, 236, 235));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }

    public static void main(String [] args) {
        new EmployeeUpdate();
    }
}
