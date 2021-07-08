package function;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import window.*;
import route.*;
import javax.swing.*;

/**
 *
 * @author cookie
 */
public class SkillMechanic {
    public JProgressBar p1_healthbar, p2_healthbar;    
    public int idx_p_turn;
    public String username_p1, username_p2;
    private JProgressBar p_healthbar;
    private String action;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/sbinning_sgill?zeroDateTimeBehavior=CONVERT_TO_NULL&useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String pass = "irsyadndu1ABC";
    private String query6;
    private Connection conn6;
    private Statement stm6;
    private ResultSet res6;        
    //
    public JProgressBar activateSkill(int p_next_post, int p_rem_post, int idx_turn, String mode){
        int post = p_next_post;
        if (p_rem_post >= 0) {post = p_rem_post;}
        if (post > 0 && post <= 6) {
            this.action = "DAMAGE";
            p_healthbar = this.modeSetter(idx_turn, mode, action);
            p_healthbar.setValue(p_healthbar.getValue()-350);
        } else if (post > 6 && post <= 11)
        {
            this.action = "HEAL";
            p_healthbar = this.modeSetter(idx_turn, mode, action);
            if (p_healthbar.getValue()+50 <= p_healthbar.getMaximum()) {
                p_healthbar.setValue(p_healthbar.getValue()+50);                
            } else if (p_healthbar.getValue() < p_healthbar.getMaximum()){
                int rem = p_healthbar.getMaximum() - p_healthbar.getValue();
                p_healthbar.setValue(p_healthbar.getValue()+rem);                
            }
        }
        return this.p_healthbar;
    }
    public JProgressBar modeSetter(int idx_turn, String mode, String action) {
        switch(mode) {
            case "ROLLING":
                if (idx_turn == 0) {
                    if (action.equals("DAMAGE")) {this.p_healthbar = p2_healthbar;} 
                    if (action.equals("HEAL")) {this.p_healthbar = p1_healthbar;}                                    
                } else {
                    if (action.equals("DAMAGE")) {this.p_healthbar = p1_healthbar;} 
                    if (action.equals("HEAL")) {this.p_healthbar = p2_healthbar;}                                                        
                }
                break;
            case "WAITING":
                if (idx_turn == 0) {
                    if (action.equals("DAMAGE")) {this.p_healthbar = p1_healthbar;} 
                    if (action.equals("HEAL")) {this.p_healthbar = p2_healthbar;}                                    
                } else {
                    if (action.equals("DAMAGE")) {this.p_healthbar = p2_healthbar;} 
                    if (action.equals("HEAL")) {this.p_healthbar = p1_healthbar;}                                                        
                }
                break;                
        }
        return this.p_healthbar;
    }
    public void updateHealthBar(int health_value) {
        try {
            Class.forName(this.driver);
            conn6 = DriverManager.getConnection(this.url, this.user, this.pass);
            stm6 = conn6.createStatement();
            query6 = "UPDATE GAME_ROOM SET HEALTHBAR = '"+health_value+"' WHERE P1_USERNAME = '"+username_p1+"' AND P2_USERNAME = '"+username_p2+"' AND STATUS = 'RUNNING';";
            stm6.execute(this.query6);
            stm6.close();
            conn6.close();
        } catch(Exception e) {System.out.println(e);}                                
    }    
}
