
package com.mycompany.poojava;

import java.sql.*;
import javax.swing.JOptionPane;

public class CConnection {
    Connection cn = null;
    Statement st = null;

    String user = "root";
    String password = "";
    String db = "PIAPOO";
    String ip = "localhost";
    String port = "3306"; 

    String url = "jdbc:mysql://" + ip + ":" + port + "/" + db + "?useSSL=false";

    public Statement establishConnection() {
        try {
            cn = DriverManager.getConnection(url, user, password);
            st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return st;
    }

    public Connection establishConnectionCN() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cambiar al controlador de MySQL
            cn = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return cn;
    }
}
