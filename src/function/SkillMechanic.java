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
    public void showStatSkill(int p_next_post, int p_rem_post, JLabel skill_name_val, JTextArea skill_desc_val) {
        int post = p_next_post;        
        if (p_rem_post >= 0) {post = p_rem_post;}
        switch(post) {
            case 1: // atomic : damage 550 if Opponent HP > 80%
                skill_name_val.setText("ATOMIC RAIN");
                skill_desc_val.setText("Bomb them while you can. This massive weapon can only be activated when Opponent HP is above 80%\n--\nDamage : 550");            
                break;
            case 2: // mine
            case 7: // mine : reflect 320
                skill_name_val.setText("MINE-SWEEPER");
                skill_desc_val.setText("This mine ain't playing. It deals damage, so watch your step carefully around this block\n--\nReflect : 320");            
                break;            
            case 3: // chocolate bar : heal 250 + 25% Player HP Loss
                skill_name_val.setText("CHOCOLATE BAR");
                skill_desc_val.setText("Heath is your number one priority. It will even regen faster when your health is too low\n--\nHeal : 250 + (25% HP Loss)");            
                break;                            
        }
    }
    public JProgressBar activateSkill(int p_next_post, int p_rem_post, int idx_turn, String mode){
        int post = p_next_post;
        int idx_turn2 = 0;
        double h_loss, h_current;
        int rem;
        if (p_rem_post >= 0) {post = p_rem_post;}
        switch(post) {
            case 1: // atomic : damage 550 if Opponent HP > 80%
                this.action = "DAMAGE";
                p_healthbar = this.modeSetter(idx_turn, mode, action);
                if ((p_healthbar.getValue()) > (p_healthbar.getMaximum() * 0.8)) {
                    p_healthbar.setValue(p_healthbar.getValue()-550);                                    
                }
                break;                
            case 2: // mine
            case 7: // mine : reflect 320
                this.action = "DAMAGE";
                if (idx_turn == 0) {idx_turn = 1;} else {idx_turn = 0;}
                p_healthbar = this.modeSetter(idx_turn, mode, action);
                p_healthbar.setValue(p_healthbar.getValue()-320);                
                break;                
            case 3: // chocolate bar : heal 250 + 25% Player HP Loss
                this.action = "HEAL";
                p_healthbar = this.modeSetter(idx_turn, mode, action);
                h_loss = (p_healthbar.getMaximum() - p_healthbar.getValue()) * 0.25;
                if (p_healthbar.getValue()+250+(int)h_loss <= p_healthbar.getMaximum()) {
                    p_healthbar.setValue(p_healthbar.getValue()+250+(int)h_loss);                
                } else if (p_healthbar.getValue() < p_healthbar.getMaximum()){
                    rem = p_healthbar.getMaximum() - p_healthbar.getValue();
                    p_healthbar.setValue(p_healthbar.getValue()+rem);                
                }                                
                break;
            case 4:
            case 8: // fireworks : damage 75 + 12% Opponent HP # reflect 25
                this.action = "HEAL";
                p_healthbar = this.modeSetter(idx_turn, mode, action);
                p_healthbar.setValue(p_healthbar.getValue()-25);            
                this.action = "DAMAGE";                
                p_healthbar = this.modeSetter(idx_turn, mode, action);
                h_current = (p_healthbar.getValue()) * 0.12;           
                System.out.println(p_healthbar.getValue()+" > "+h_current); 
                p_healthbar.setValue(p_healthbar.getValue()-(75+(int)h_current));                            
                break;
            case 5:
            case 10: // cannon : damage 355 # reflect 75
                this.action = "HEAL";
                p_healthbar = this.modeSetter(idx_turn, mode, action);
                p_healthbar.setValue(p_healthbar.getValue()-75);                        
                this.action = "DAMAGE";
                p_healthbar = this.modeSetter(idx_turn, mode, action);
                p_healthbar.setValue(p_healthbar.getValue()-355);                            
                break;
            case 6:
            case 11: // sandal : damage 120 + 15% Opponent HP Loss
                this.action = "DAMAGE";                
                p_healthbar = this.modeSetter(idx_turn, mode, action);
                h_loss = (p_healthbar.getMaximum() - p_healthbar.getValue()) * 0.15;
                p_healthbar.setValue(p_healthbar.getValue()-(120+(int)h_loss));                                
                break;
            case 9: // robbery : damage 250 # heal 250
                this.action = "HEAL";
                p_healthbar = this.modeSetter(idx_turn, mode, action);
                if (p_healthbar.getValue()+250 <= p_healthbar.getMaximum()) {
                    p_healthbar.setValue(p_healthbar.getValue()+250);                
                } else if (p_healthbar.getValue() < p_healthbar.getMaximum()){
                    rem = p_healthbar.getMaximum() - p_healthbar.getValue();
                    p_healthbar.setValue(p_healthbar.getValue()+rem);                
                }                
                this.action = "DAMAGE";
                p_healthbar = this.modeSetter(idx_turn, mode, action);
                p_healthbar.setValue(p_healthbar.getValue()-250);                
                break;                
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
