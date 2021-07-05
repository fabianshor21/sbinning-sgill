package function;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import window.*;
import route.*;
import javax.swing.*;

public class PlayerMechanic {
    private int p_cur_post;
    private String p_username, p_color;
    public JPanel border_turn;
    public JButton dice_btn;
    //
    public void setUsername(String p_username) {this.p_username = p_username;}
    public void setColor(String p_color) {this.p_color = p_color;}
    public void setCurPost(int p_cur_post) {this.p_cur_post = p_cur_post;} 
    //
    public String getUsername() {return this.p_username;}
    public String getColor() {return this.p_color;}
    public int getCurPost() {return this.p_cur_post;}     
}
