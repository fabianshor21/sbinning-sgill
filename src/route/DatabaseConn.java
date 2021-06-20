package route;
import java.sql.*;
import javax.swing.*;
//
public class DatabaseConn {
    //
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/sbinning_sgill?zeroDateTimeBehavior=CONVERT_TO_NULL&useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String pass = "irsyadndu1ABC";
    private String query;
    private Connection conn;
    private Statement stm;
    private ResultSet res;
    //
    public char playerAvailabilty(JTextField username_in, JTextField password_in) {
        boolean checkData = false;
        char checkPass = ' ';
        try {
            Class.forName(this.driver);
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            stm = conn.createStatement();
            query = "SELECT * FROM PLAYER WHERE USERNAME = '"+username_in.getText().toUpperCase()+"'";
            res = stm.executeQuery(this.query);
            while(res.next()) {
                checkData = true;
                if (res.getString("PASSWORD").equals(password_in.getText().toUpperCase())) {
                    System.out.println("Bisa Login");
                } else {
                    System.out.println("Salah Password");
                    checkPass = 'F';
                }
            }
            if (!checkData) {
                System.out.println("Buat akun baru ?");
                checkPass = 'N';                
            }
            stm.close();
            conn.close();
        } catch(Exception e) {System.out.println(e);}
        return checkPass;
    }
    public void createNewPlayer(JTextField username_in, JTextField password_in) {
        try {
            Class.forName(this.driver);
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            stm = conn.createStatement();
            query = "INSERT INTO PLAYER VALUES ('"+username_in.getText().toUpperCase()+"','"+password_in.getText().toUpperCase()+"',0,0,0,0)";
            stm.execute(this.query);
            stm.close();
            conn.close();
        } catch(Exception e) {System.out.println(e);}        
    }
}
