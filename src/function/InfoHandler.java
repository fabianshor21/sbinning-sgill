package function;
import javax.swing.*;
public class InfoHandler {
    public void manageTip(JLabel warning_field_lbl, String msg) {
        warning_field_lbl.setVisible(true);
        warning_field_lbl.setToolTipText(msg);
    }
    public void manageTip(JLabel warning_field_lbl) {
        warning_field_lbl.setVisible(false);        
    }
    public int manageDialog(int button, int icon, String msg, String head) {
        int dialog = JOptionPane.showConfirmDialog(null, msg, head, button, icon);
        return dialog;
    }
    public void manageModeInfo(JLabel game_mode_status_val, JLabel game_mode_info_val, String modename, String msg) {
        game_mode_status_val.setText(modename);
        game_mode_info_val.setText(msg);
    }
    public String sendChallenge() {
        try {
            String opp_username = JOptionPane.showInputDialog(null,"Input the opponent's username","Request Challenge", JOptionPane.INFORMATION_MESSAGE);
            return opp_username;
        } catch (NullPointerException e) {return "";}
    }    
}
