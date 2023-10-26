package electricity.billing.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String password = "rocky123";
            String dbName = "ELECBILLSYS";
            //statement create
            c = DriverManager.getConnection(url+dbName, user, password);
            s =  c.createStatement();
            System.out.println("Connected Sucessfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
