package route;
import java.sql.*;
import javax.swing.*;
//
public class DatabaseConn {
    //
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/distr_system?zeroDateTimeBehavior=CONVERT_TO_NULL&useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String pass = "irsyadndu1ABC";
    private String query;
    private Connection conn;
    private Statement stm;
    private ResultSet res;
    //
    public void Test(JTextArea log_ta) {
        try {
            Class.forName(this.driver);
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            stm = conn.createStatement();
            query = "SELECT * FROM ANGGOTA";
            res = stm.executeQuery(this.query);
            while(res.next()) {
               log_ta.append(" " + res.getString("NAME") + " (" + res.getString("NIM") + ")\n");
            }
            stm.close();
            conn.close();
        } catch(Exception e) {System.out.println(e);}
    }
}
