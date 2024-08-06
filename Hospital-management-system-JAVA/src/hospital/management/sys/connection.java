package hospital.management.sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class connection {

    public PreparedStatement statement;
    Connection c;
    Statement s;

    public connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "pbian12345");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}