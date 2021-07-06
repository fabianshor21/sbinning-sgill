package function;
import java.awt.Color;
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
    private JProgressBar p_healthbar;
    private String action;
    //
    public void activateSkill(int p_next_post, int p_rem_post, int idx_turn, String mode){
        int post = p_next_post;
        if (p_rem_post >= 0) {post = p_rem_post;}
        if (post > 0 && post <= 6) {
            this.action = "DAMAGE";
            p_healthbar = this.modeSetter(idx_turn, mode, action);
            p_healthbar.setValue(p_healthbar.getValue()-250);
        } else if (post > 6 && post <= 11)
        {
            this.action = "HEAL";
            p_healthbar = this.modeSetter(idx_turn, mode, action);
            if (p_healthbar.getValue()+100 <= p_healthbar.getMaximum()) {
                p_healthbar.setValue(p_healthbar.getValue()+100);                
            } else if (p_healthbar.getValue() < p_healthbar.getMaximum()){
                int rem = p_healthbar.getMaximum() - p_healthbar.getValue();
                p_healthbar.setValue(p_healthbar.getValue()+rem);                
            }
        }
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
}
