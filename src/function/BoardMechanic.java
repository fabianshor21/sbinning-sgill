package function;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import window.*;
import route.*;
import javax.swing.*;

public class BoardMechanic extends Thread{
    private JLabel dice_val_lbl;
    private final int min_dice = 1;
    private final int max_dice = 6;
    private JPanel[] block_map;
    private int dice_res;
    private int p_cur_post = 0, p_next_post = 0, p_rem_post, idx_p_turn, roll_dice;
    private String p1_username, p2_username, p_turn;
    private PlayerMechanic[] pm = new PlayerMechanic[2];        
    private DatabaseGameConn dbg = new DatabaseGameConn();
    //
    public void setObjPlayer(PlayerMechanic[] pm) {this.pm = pm;}
    public void setPlayerTurn(String p_turn) {this.p_turn = p_turn;}
    public void setDiceVal(JLabel dice_val_lbl) {this.dice_val_lbl = dice_val_lbl;}
    public void setBlockMap(JPanel[] block_map) {this.block_map = block_map;}
    public void setPlayerPost(int p_cur_post, int p_next_post, int p_rem_post, int roll_dice) {this.p_cur_post = p_cur_post; this.p_next_post = p_next_post; this.p_rem_post = p_rem_post; this.roll_dice = roll_dice;}
    //
    public int rollDice() {
        this.dice_res = (int)Math.floor(Math.random()*(this.max_dice-this.min_dice+1)+this.min_dice);
        this.dice_val_lbl.setText(this.dice_res+"");
        return (this.dice_res + this.p_next_post);
    }
    public void animateplayerMovement() {
        p1_username = pm[0].getUsername();
        p2_username = pm[1].getUsername();
        this.p_turn = dbg.getPlayerTurn(p1_username, p2_username);
        if (p_turn.equals(pm[0].getUsername())) {idx_p_turn = 0;}
        if (p_turn.equals(pm[1].getUsername())) {idx_p_turn = 1;}        
        boolean opp_ahead = false;        
        System.out.println("remainder : " + this.p_rem_post);
        for (int i = 0; i < this.block_map.length; i++) {
            if (i > this.p_cur_post && i <= this.p_next_post) {
                try {                    
                    if (i > 0) {
                        Thread.sleep(500);
                        if (!opp_ahead) {
                            /*
                            if (this.block_map[i].getBackground().getRGB() == Color.WHITE.getRGB()) {
                                this.block_map[i].setBackground(Color.decode(this.pm[idx_p_turn].getColor()));    
                                System.out.println("depan bukan musuh");
                            } else {
                                if (this.block_map[i-1].getBackground().getRGB() == this.block_map[i].getBackground().getRGB()) {
                                    this.block_map[i-1].setBackground(Color.WHITE);
                                    System.out.println("belakang ga ada musuh");                                
                                }                                
                                continue;
                            } */
                            if (this.block_map[i].getBackground().getRGB() != Color.WHITE.getRGB() && i != this.p_next_post) {
                                this.block_map[i-1].setBackground(Color.WHITE);
                                continue;
                            } else {
                                this.block_map[i].setBackground(Color.decode(this.pm[idx_p_turn].getColor()));                                
                            }
                            this.block_map[i].setBackground(Color.decode(this.pm[idx_p_turn].getColor()));                                                    
                            if (this.block_map[i-1].getBackground().getRGB() == this.block_map[i].getBackground().getRGB()) {
                                this.block_map[i-1].setBackground(Color.WHITE);
                                System.out.println("belakang ga ada musuh");                                
                            }
                            this.p_cur_post = i;
                        } else {
                            this.block_map[i-1].setBackground(Color.WHITE);                                                    
                            opp_ahead = false;
                        }
                        if (i < this.block_map.length-1) {
                            if (this.block_map[i+1].getBackground().getRGB() != Color.WHITE.getRGB()) {
                                if ((i+1) == this.p_next_post){ //&& this.p_rem_post < 0) {
                                    this.block_map[i].setBackground(Color.decode(this.pm[idx_p_turn].getColor()));                                                            
                                    System.out.println("timpa musuh, remainder : " + this.p_rem_post);                                                                        
                                } else {
                                    System.out.println("blok depan musuh, kita skip");
                                    opp_ahead = true;
                                }
                            }
                        }      
                    }
                } catch (InterruptedException ex) {Logger.getLogger(BoardMechanic.class.getName()).log(Level.SEVERE, null, ex);}                            
            }
        }
        if (this.p_rem_post == 0) {
            try {            
            //    this.block_map[10].setBackground(Color.WHITE);                            
            //    this.block_map[11].setBackground(Color.decode(this.pm[idx_p_turn].getColor()));                                        
                Thread.sleep(500);
                this.block_map[0].setBackground(Color.decode(this.pm[idx_p_turn].getColor()));                                        
                if (this.block_map[11].getBackground().getRGB() == this.block_map[0].getBackground().getRGB()) {
                    this.block_map[11].setBackground(Color.WHITE);
                    System.out.println("belakang ga ada musuh");                                
                }                
            //    this.block_map[11].setBackground(Color.WHITE);                            
            //    this.block_map[0].setBackground(Color.decode(this.pm[idx_p_turn].getColor()));                        
                this.p_cur_post = 0;                                                        
            } catch (InterruptedException ex) {
                Logger.getLogger(BoardMechanic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (this.p_rem_post > 0) {
            this.p_cur_post = 0;
            this.p_next_post = 0;
            opp_ahead = false;
            for (int i = 0; i < this.block_map.length; i++) {
                if (i >= this.p_cur_post && i <= this.p_rem_post) {
                    try {                    
                        if (i == 0) {
                            Thread.sleep(500);
                            this.block_map[11].setBackground(Color.WHITE);                            
                            this.block_map[0].setBackground(Color.decode(this.pm[idx_p_turn].getColor()));                        
                            this.p_cur_post = i;                            
                        } else {
                            Thread.sleep(500);
                            if (!opp_ahead) {
                                /*
                                if (this.block_map[i].getBackground().getRGB() == Color.WHITE.getRGB()) {
                                    this.block_map[i].setBackground(Color.decode(this.pm[idx_p_turn].getColor()));    
                                    System.out.println("depan bukan musuh");
                                } else {
                                    if (this.block_map[i-1].getBackground().getRGB() == this.block_map[i].getBackground().getRGB()) {
                                        this.block_map[i-1].setBackground(Color.WHITE);
                                        System.out.println("belakang ga ada musuh");                                
                                    }                                
                                    continue;
                                } */
                                if (this.block_map[i].getBackground().getRGB() != Color.WHITE.getRGB() && i != this.p_rem_post) {
                                    this.block_map[i-1].setBackground(Color.WHITE);
                                    continue;
                                } else {
                                    this.block_map[i].setBackground(Color.decode(this.pm[idx_p_turn].getColor()));                                
                                }
                                this.block_map[i].setBackground(Color.decode(this.pm[idx_p_turn].getColor()));                                                    
                                if (this.block_map[i-1].getBackground().getRGB() == this.block_map[i].getBackground().getRGB()) {
                                    this.block_map[i-1].setBackground(Color.WHITE);
                                    System.out.println("belakang ga ada musuh");                                
                                }
                                this.p_cur_post = i;
                            } else {
                                this.block_map[i-1].setBackground(Color.WHITE);                                                    
                                opp_ahead = false;
                            }
                            if (i < this.block_map.length-1) {
                                if (this.block_map[i+1].getBackground().getRGB() != Color.WHITE.getRGB()) {
                                    if ((i+1) == this.p_rem_post){ //&& this.p_rem_post < 0) {
                                        this.block_map[i].setBackground(Color.decode(this.pm[idx_p_turn].getColor()));                                                            
                                        System.out.println("timpa musuh, remainder : " + this.p_rem_post);                                                                        
                                    } else {
                                        System.out.println("blok depan musuh, kita skip");
                                        opp_ahead = true;
                                    }
                                }
                            }      
                        }
                    } catch (InterruptedException ex) {Logger.getLogger(BoardMechanic.class.getName()).log(Level.SEVERE, null, ex);}                            
                    System.out.println("");                    
                }
            }            
        }
        System.out.println(this.p_next_post);
        dbg.updatePlayerPost(p1_username, p2_username, this.p_cur_post, this.roll_dice);
        dbg.updatePlayerAction(p1_username, p2_username, "WAITING");
        this.dice_val_lbl.setText("--");
        this.pm[idx_p_turn].border_turn.setVisible(false);
        if (idx_p_turn == 0) {this.pm[1].border_turn.setVisible(true);}
        else {this.pm[0].border_turn.setVisible(true);}
    }
    public void animateplayerMovement(int opp_cur_post, int opp_next_post, int opp_rem_post, String color, PlayerMechanic[] pm) {
        System.out.println("remainder : " + this.p_rem_post);
        // icat ilangin yg ga perlu
        /*
        p1_username = pm[0].getUsername();
        p2_username = pm[1].getUsername();        
        this.p_turn = dbg.getPlayerTurn(p1_username, p2_username);
        if (p_turn.equals(pm[0].getUsername())) {idx_p_turn = 0;}
        if (p_turn.equals(pm[1].getUsername())) {idx_p_turn = 1;}
        */
        boolean opp_ahead = false;                
        //System.out.println(p1_username+" "+p2_username+" masuk turn "+idx_p_turn);        
        for (int i = 0; i < this.block_map.length; i++) {
            if (i > opp_cur_post && i <= opp_next_post) {
                try {                    
                    if (i > 0) {
                    //    Thread.sleep(500);
                    //    this.block_map[i].setBackground(Color.decode(color));                        
                    //    this.block_map[i-1].setBackground(Color.WHITE);
                    //    opp_cur_post = i;
                        
                        Thread.sleep(500);
                        if (!opp_ahead) {
                            if (this.block_map[i].getBackground().getRGB() != Color.WHITE.getRGB() && i != opp_next_post) {
                                this.block_map[i-1].setBackground(Color.WHITE);
                                continue;
                            } else {
                                this.block_map[i].setBackground(Color.decode(color));                                
                            }
                            this.block_map[i].setBackground(Color.decode(color));                                                    
                            if (this.block_map[i-1].getBackground().getRGB() == this.block_map[i].getBackground().getRGB()) {
                                this.block_map[i-1].setBackground(Color.WHITE);
                                System.out.println("belakang ga ada musuh");                                
                            }
                            opp_cur_post = i;
                        } else {
                            this.block_map[i-1].setBackground(Color.WHITE);                                                    
                            opp_ahead = false;
                        }
                        if (i < this.block_map.length-1) {
                            if (this.block_map[i+1].getBackground().getRGB() != Color.WHITE.getRGB()) {
                                if ((i+1) == opp_next_post){ //&& this.p_rem_post < 0) {
                                    this.block_map[i].setBackground(Color.decode(color));                                                            
                                    System.out.println("timpa musuh, remainder : " + opp_rem_post);                                                                        
                                } else {
                                    System.out.println("blok depan musuh, kita skip");
                                    opp_ahead = true;
                                }
                            }
                        }      
                    }
                //    System.out.println(p1_username+" "+p2_username+" masuk turn "+idx_p_turn);                            
                } catch (InterruptedException ex) {Logger.getLogger(BoardMechanic.class.getName()).log(Level.SEVERE, null, ex); System.out.println("err");}                            
            }
        }
        if (opp_rem_post == 0) {
            try {            
                Thread.sleep(500);
                this.block_map[0].setBackground(Color.decode(color));                                        
                if (this.block_map[11].getBackground().getRGB() == this.block_map[0].getBackground().getRGB()) {
                    this.block_map[11].setBackground(Color.WHITE);
                    System.out.println("belakang ga ada musuh");                                
                }                
                opp_cur_post = 0;                                                        
            } catch (InterruptedException ex) {
                Logger.getLogger(BoardMechanic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        if (opp_rem_post > 0) {
            opp_cur_post = 0;
            opp_next_post = 0;            
            opp_ahead = false;
            for (int i = 0; i < this.block_map.length; i++) {
                if (i >= opp_cur_post && i <= opp_rem_post) {
                    try {                    
                        if (i == 0) {
                            Thread.sleep(500);
                            this.block_map[11].setBackground(Color.WHITE);                            
                            this.block_map[0].setBackground(Color.decode(color));                        
                            opp_cur_post = i;                            
                        } else {
                            Thread.sleep(500);
                            if (!opp_ahead) {
                                if (this.block_map[i].getBackground().getRGB() != Color.WHITE.getRGB() && i != opp_rem_post) {
                                    this.block_map[i-1].setBackground(Color.WHITE);
                                    continue;
                                } else {
                                    this.block_map[i].setBackground(Color.decode(color));                                
                                }
                                this.block_map[i].setBackground(Color.decode(color));                                                    
                                if (this.block_map[i-1].getBackground().getRGB() == this.block_map[i].getBackground().getRGB()) {
                                    this.block_map[i-1].setBackground(Color.WHITE);
                                    System.out.println("belakang ga ada musuh");                                
                                }
                                opp_cur_post = i;
                            } else {
                                this.block_map[i-1].setBackground(Color.WHITE);                                                    
                                opp_ahead = false;
                            }
                            if (i < this.block_map.length-1) {
                                if (this.block_map[i+1].getBackground().getRGB() != Color.WHITE.getRGB()) {
                                    if ((i+1) == opp_rem_post){ //&& this.p_rem_post < 0) {
                                        this.block_map[i].setBackground(Color.decode(color));                                                            
                                        System.out.println("timpa musuh, remainder : " + opp_rem_post);                                                                        
                                    } else {
                                        System.out.println("blok depan musuh, kita skip");
                                        opp_ahead = true;
                                    }
                                }
                            }      
                        }
                    } catch (InterruptedException ex) {Logger.getLogger(BoardMechanic.class.getName()).log(Level.SEVERE, null, ex);}                            
                }
            }            
        }
        System.out.println(this.p_next_post);
    }    
    @Override
    public void run() {this.animateplayerMovement();}
}
// start post - end post