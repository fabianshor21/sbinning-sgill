package function;
import javax.swing.*;
public class ToolTip {
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
}
