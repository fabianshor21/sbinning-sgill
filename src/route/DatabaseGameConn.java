package route;
import function.*;
import window.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author cookie
 */
public class DatabaseGameConn extends Thread {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/sbinning_sgill?zeroDateTimeBehavior=CONVERT_TO_NULL&useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String pass = "irsyadndu1ABC";
    private String query, query2, query3, query4, query5, query6;
    private Connection conn, conn2, conn3, conn4, conn5, conn6;
    private Statement stm, stm2, stm3, stm4, stm5, stm6;
    private ResultSet res, res2, res3, res4, res5, res6;    
    public String username_p1, username_p2, current_player, opp_player;
    public PlayerMechanic[] pm;    
    private SkillMechanic sm = new SkillMechanic();    
    public int opp_cur_turn = 0, opp_next_turn = 0, opp_rem_turn = 0, idx_turn, roll_dice;
    public JPanel[] block_map;
    public JLabel dice_val_lbl;    
    private boolean exit;
    //
    public void deleteGameRoom(String p1_username, String p2_username) {
        try {
            Class.forName(this.driver);
            conn6 = DriverManager.getConnection(this.url, this.user, this.pass);
            stm6 = conn6.createStatement();
            query6 = "DELETE FROM GAME_ROOM WHERE GAME_NO = '"+p1_username+"' OR GAME_NO = '"+p2_username+"';";                    
            stm6.execute(this.query6);
            stm6.close();
            conn6.close();
        } catch(Exception e) {System.out.println(e);}                                        
    }
    public void updatePlayerDetails(String username, double playtime, String win_status) {
        double get_playtime = 0.0;
        int get_rating = 0;
        int get_max_rating = 0;
        int get_win_lost = 0;
        try {
            Class.forName(this.driver);
            conn4 = DriverManager.getConnection(this.url, this.user, this.pass);
            stm4 = conn4.createStatement();
            query4 = "SELECT * FROM PLAYER WHERE USERNAME = '"+username+"';";
            res4 = stm4.executeQuery(this.query4);
            while(res4.next()) {
                get_playtime = res4.getDouble("PLAYTIME") + playtime;
                get_rating = res4.getInt("RATING");
                get_max_rating = res4.getInt("MAX_RATING");
                if (win_status.equals("WIN")) {
                    get_win_lost = res4.getInt("TOTAL_WIN") + 1;
                    get_rating = res4.getInt("RATING") + 23;
                    get_max_rating = res4.getInt("MAX_RATING");
                    if (get_rating >= get_max_rating) {
                        get_max_rating = get_rating;
                    }
                }
                else {
                    get_win_lost = res4.getInt("TOTAL_LOST") + 1;
                    get_rating = res4.getInt("RATING");
                    get_max_rating = res4.getInt("MAX_RATING");                                        
                    if (get_rating >= 150) {
                        get_rating = get_rating - 15;                        
                    }
                }
            }
            stm4.close();
            conn4.close();
        } catch(Exception e) {System.out.println(e);}                
        try {
            Class.forName(this.driver);
            conn5 = DriverManager.getConnection(this.url, this.user, this.pass);
            stm5 = conn5.createStatement();
            if (win_status.equals("WIN")) {
                    query5 = "UPDATE PLAYER SET TOTAL_WIN = "+get_win_lost+", RATING = "+get_rating+", MAX_RATING = "+get_max_rating+", PLAYTIME = "+get_playtime+" WHERE USERNAME = '"+username+"';";                    
            } else {
                    query5 = "UPDATE PLAYER SET TOTAL_LOST = "+get_win_lost+", RATING = "+get_rating+", MAX_RATING = "+get_max_rating+", PLAYTIME = "+get_playtime+" WHERE USERNAME = '"+username+"';";                    
            }
            stm5.execute(this.query5);
            stm5.close();
            conn5.close();
        } catch(Exception e) {System.out.println(e);}                                
    }
    public void updatePlayerPost(String username_p1, String username_p2, int post, int roll_dice){
        String game_no = "";
        String p_turn = "";
        try {
            Class.forName(this.driver);
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            stm = conn.createStatement();
            query = "SELECT * FROM GAME_ROOM WHERE P1_USERNAME = '"+username_p1+"' AND P2_USERNAME = '"+username_p2+"' AND STATUS = 'RUNNING';";
            res = stm.executeQuery(this.query);
            while(res.next()) {
                game_no = res.getString("GAME_NO");
                p_turn = res.getString("P_TURN");
            }
            stm.close();
            conn.close();
        } catch(Exception e) {System.out.println(e);}        
        try {
            Class.forName(this.driver);
            conn2 = DriverManager.getConnection(this.url, this.user, this.pass);
            stm2 = conn2.createStatement();
            System.out.println(post+" : "+p_turn);
            if (p_turn.equals(username_p1)) {
                    query2 = "UPDATE GAME_ROOM SET P1_POST = "+post+", P_TURN = '"+username_p2+"', ROLL_DICE = "+roll_dice+" WHERE GAME_NO = '"+game_no+"' AND STATUS = 'RUNNING';";                    
            } else {
                    query2 = "UPDATE GAME_ROOM SET P2_POST = "+post+", P_TURN = '"+username_p1+"', ROLL_DICE = "+roll_dice+" WHERE GAME_NO = '"+game_no+"' AND STATUS = 'RUNNING';";                    
            }
            stm2.execute(this.query2);
            stm2.close();
            conn2.close();
        } catch(Exception e) {System.out.println(e);}                        
    }
    public int getPlayerCurPost(String username_p1, String username_p2, String p_turn) {
        int p_cur_post = 0;
        try {
            Class.forName(this.driver);
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            stm = conn.createStatement();
            query = "SELECT * FROM GAME_ROOM WHERE P1_USERNAME = '"+username_p1+"' AND P2_USERNAME = '"+username_p2+"' AND STATUS = 'RUNNING';";
            res = stm.executeQuery(this.query);
            while(res.next()) {
                if (p_turn.equals(username_p1)) {p_cur_post = res.getInt("P1_POST");}
                else {p_cur_post = res.getInt("P2_POST");}
            }
            stm.close();
            conn.close();
        } catch(Exception e) {System.out.println(e);}   
        return p_cur_post;
    }
    public String getPlayerTurn(String username_p1, String username_p2) {
        String p_turn = "";
        try {
            Class.forName(this.driver);
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            stm = conn.createStatement();
            query = "SELECT * FROM GAME_ROOM WHERE P1_USERNAME = '"+username_p1+"' AND P2_USERNAME = '"+username_p2+"' AND STATUS = 'RUNNING';";
            res = stm.executeQuery(this.query);
            while(res.next()) {
                p_turn = res.getString("P_TURN");
            }
            stm.close();
            conn.close();
        } catch(Exception e) {System.out.println(e);}                 
        return p_turn;
    }    
    public void updatePlayerAction(String username_p1, String username_p2, String status) {
        try {
            Class.forName(this.driver);
            conn3 = DriverManager.getConnection(this.url, this.user, this.pass);
            stm3 = conn3.createStatement();
            query3 = "UPDATE GAME_ROOM SET P_ACTION = '"+status+"' WHERE P1_USERNAME = '"+username_p1+"' AND P2_USERNAME = '"+username_p2+"' AND STATUS = 'RUNNING';";
            stm3.execute(this.query3);
            stm3.close();
            conn3.close();
        } catch(Exception e) {System.out.println(e);}                                
    }    
    public void displayOppMovement(){
        BoardMechanic bm;
        if (this.current_player.equals(this.username_p1)) {this.opp_player = "P2_POST";}
        else {this.opp_player = "P1_POST";}
        while(true) {
            try {
                Class.forName(this.driver);
                conn = DriverManager.getConnection(this.url, this.user, this.pass);
                stm = conn.createStatement();
                query = "SELECT * FROM GAME_ROOM WHERE P1_USERNAME = '"+this.username_p1+"' AND P2_USERNAME = '"+this.username_p2+"' AND STATUS = 'RUNNING';";
                res = stm.executeQuery(this.query);                
                while(res.next()) {
                    String color;
                    if (res.getString("P_TURN").equals(pm[0].getUsername())) {color = pm[1].getColor(); idx_turn = 0;}
                    else {color = pm[0].getColor(); idx_turn = 1;}
                    if ((!res.getString("P_TURN").equals(this.current_player))) {this.opp_cur_turn = res.getInt(this.opp_player);}
                    else {
                        if (res.getString("P_ACTION").equals("WAITING")) {
                        //    System.out.println("status: "+res.getString("P_ACTION"));                        
                            this.opp_next_turn = this.opp_cur_turn + res.getInt("ROLL_DICE");
                        //    System.out.println(this.current_player+" >> P1:"+username_p1+" P2:"+username_p2+" TURN:"+res.getString("P_TURN")+" "+this.opp_cur_turn+" > "+this.opp_next_turn);
                            bm = new BoardMechanic();
                            if (this.opp_next_turn > 11) {
                                this.opp_rem_turn = this.opp_next_turn - 12;                                
                                this.opp_next_turn = 11;
                            } else {this.opp_rem_turn = -1;}
                            bm.setBlockMap(this.block_map);
                            this.pm[0].dice_btn.setEnabled(false); this.pm[1].dice_btn.setEnabled(false);
                            bm.setObjPlayer(pm);
                            if (idx_turn == 0) {bm.setIdxTurn(1);}
                            else {bm.setIdxTurn(0);}
                            bm.setIdxTurn(idx_turn);
                            bm.animateplayerMovement(opp_cur_turn, opp_next_turn, opp_rem_turn, color, pm);
                            this.updatePlayerAction(username_p1, username_p2, "ROLLING");
                            if (idx_turn == 0) {this.pm[0].border_turn.setVisible(true); this.pm[1].border_turn.setVisible(false);}
                            else {this.pm[1].border_turn.setVisible(true); this.pm[0].border_turn.setVisible(false);}                            
                            this.pm[0].dice_btn.setEnabled(true); this.pm[1].dice_btn.setEnabled(true);                            
                        }
                    }
                }
                stm.close();
                conn.close();
            } catch(Exception e) {System.out.println(e);}                             
        }
    }

    @Override
    public void run() {this.displayOppMovement();}
}
