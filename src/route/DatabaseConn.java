package route;
import java.sql.*;
import javax.swing.*;
import window.*;
import function.*;
import java.util.concurrent.TimeUnit;
//
public class DatabaseConn extends Thread {
    //
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/sbinning_sgill?zeroDateTimeBehavior=CONVERT_TO_NULL&useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String pass = "irsyadndu1ABC";
    private String query, query2, query3, query4, query5;
    private Connection conn, conn2, conn3, conn4, conn5;
    private Statement stm, stm2, stm3, stm4, stm5;
    private ResultSet res, res2, res3, res4, res5;
    private Login login = new Login();
    private JTextArea chat_room_ta;
    private JLabel username_head_val;
    private String latest_chat_time = "";
    private boolean finish_load = false;        
    private InfoHandler info = new InfoHandler();
    private InGame game_1 = new InGame();
    private InGame game_2 = new InGame();
    private Lobby lobby;
    private GameConn gamecon = new GameConn();
    
    //
    public void setLobby(Lobby lobby) {this.lobby = lobby;}
    public void setUsernameVal(JLabel username_head_val) {this.username_head_val = username_head_val;}
    public void setChatRoomTa(JTextArea chat_room_ta) {this.chat_room_ta = chat_room_ta;}
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
                    checkPass = 'T';                    
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
            query = "INSERT INTO PLAYER VALUES ('"+username_in.getText().toUpperCase()+"','"+password_in.getText().toUpperCase()+"',0,0,1000,1000,0,0,0)";
            stm.execute(this.query);
            stm.close();
            conn.close();
        } catch(Exception e) {System.out.println(e);}        
    }
    public void showPlayerInfo(JLabel username_head_val, JLabel winrate_val, JLabel fastbreak_val, JLabel turnovers_val, JLabel total_race_val, JLabel max_rank_val, JLabel current_rank_val, JLabel elo_rating_val, JLabel playtime_val, String username) {
        try {
            System.out.println("username : "+username);
            Class.forName(this.driver);
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            stm = conn.createStatement();
            query = "SELECT * FROM PLAYER WHERE USERNAME = '"+username+"'";
            res = stm.executeQuery(this.query);
            while(res.next()) {
                username_head_val.setText(res.getString("USERNAME"));
                double total_win = res.getDouble("TOTAL_WIN");
                double total_lose = res.getDouble("TOTAL_LOST");
                double total_race = total_win + total_lose;
                double winrate = 0.0;
                if (total_race > 0) {winrate = (total_win / total_race)*100;}

                System.out.println(total_win+" "+total_lose+" "+total_race+" "+winrate);
                total_race_val.setText(((int)total_race)+"");
                winrate_val.setText(winrate+"");
                fastbreak_val.setText(res.getDouble("FASTBREAK")+"");
                turnovers_val.setText(res.getDouble("TURNOVERS")+"");
                max_rank_val.setText(this.selectPlayerRank(res.getInt("MAX_RATING")));
                current_rank_val.setText(this.selectPlayerRank(res.getInt("RATING")));
                elo_rating_val.setText(res.getInt("RATING")+"");
                playtime_val.setText(res.getInt("PLAYTIME")+" minutes");
                //- kelarin info player
            }
            stm.close();
            conn.close();
        } catch(Exception e) {System.out.println(e);}               
    }
    public String selectPlayerRank(double rating) {
        if (rating >= 0 && rating < 1500) {return "NOVICES";}
        else if (rating >= 1500 && rating < 2000) {return "CAND. MASTER";}
        else if (rating >= 2000 && rating < 2500) {return "INTER. MASTER";}
        else {return "GRANDMASTER";}
    }
    public void appendChatLobby(JTextField chat_in, JLabel username_head_val) {
        try {
       //    TimeUnit.SECONDS.sleep(0);                      
            Class.forName(this.driver);
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            stm = conn.createStatement();
            query = "INSERT INTO CHAT_ROOM VALUES (CURDATE(),CURTIME(),'"+username_head_val.getText()+"','CHAT','"+chat_in.getText().replace("'", "")+"');";
            stm.execute(this.query);
            stm.close();
            conn.close();
        } catch(Exception e) {System.out.println(e);}                
    }
    public void initChatLobby(JTextArea chatroom_ta, JLabel username_head_val) {
        try {
            Class.forName(this.driver);
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            stm = conn.createStatement();
            query = "SELECT P.USERNAME, P.RATING, CR.CUR_TIME, CR.TYPE, CR.CHAT FROM CHAT_ROOM CR INNER JOIN PLAYER P ON CR.USERNAME = P.USERNAME WHERE CR.CUR_DATE = CURDATE() ORDER BY CUR_TIME;";
            res = stm.executeQuery(this.query);
            while(res.next()) {
                if (res.getString("TYPE").equals("CHAT")) {                
                    chatroom_ta.append(res.getString("CUR_TIME").substring(0, 5)+" - ");                                
                    if (username_head_val.getText().equals(res.getString("USERNAME"))) {chatroom_ta.append("You");}
                    else {chatroom_ta.append(res.getString("USERNAME"));}
                    chatroom_ta.append(" ("+res.getString("RATING")+")\n");
                    chatroom_ta.append(res.getString("CHAT")+"\n---\n"); 
               //     chatroom_ta.append("_______________________________\n");
                    chatroom_ta.setCaretPosition(chatroom_ta.getDocument().getLength());
                    this.latest_chat_time = res.getString("CUR_TIME");                
                } else {
                    this.latest_chat_time = res.getString("CUR_TIME");                                    
                }
            }
            stm.close();
            conn.close();
        } catch(Exception e) {System.out.println(e);}                                       
    }
    public void showChatLobby(JTextArea chatroom_ta, JLabel username_head_val) {
        while(true) {
            try {
                String opp_username;
                Class.forName(this.driver);
                conn = DriverManager.getConnection(this.url, this.user, this.pass);
                stm = conn.createStatement();
                query = "SELECT P.USERNAME, P.RATING, CR.CUR_TIME, CR.TYPE, CR.CHAT FROM CHAT_ROOM CR INNER JOIN PLAYER P ON CR.USERNAME = P.USERNAME WHERE CR.CUR_DATE = CURDATE() ORDER BY CUR_TIME;";
                res = stm.executeQuery(this.query);
                while(res.next()) {
                    if (this.latest_chat_time.compareTo(res.getString("CUR_TIME")) < 0) {
                        if (res.getString("TYPE").equals("CHAT")) {
                            chatroom_ta.append(res.getString("CUR_TIME").substring(0, 5)+" - ");                                
                            if (username_head_val.getText().equals(res.getString("USERNAME"))) {chatroom_ta.append("You");}
                            else {chatroom_ta.append(res.getString("USERNAME"));}
                            chatroom_ta.append(" ("+res.getString("RATING")+")\n");
                            chatroom_ta.append(res.getString("CHAT")+"\n---\n"); 
                   //        chatroom_ta.append("_______________________________\n");
                            chatroom_ta.setCaretPosition(chatroom_ta.getDocument().getLength());                        
                            this.latest_chat_time = res.getString("CUR_TIME");
                        }
                        else if (!this.finish_load && res.getString("TYPE").equals("REQUEST")){
                            // requester
                            if (username_head_val.getText().equals(res.getString("USERNAME"))) {
                            chatroom_ta.append(res.getString("CUR_TIME").substring(0, 5)+" - SYSTEM\n");                                                                                            
                                chatroom_ta.append("You've challanged "+res.getString("CHAT")+" !\n");
                                chatroom_ta.append("Waiting for your opponent ...\n---\n");
                            } else if (username_head_val.getText().equals(res.getString("CHAT"))) {
                                chatroom_ta.append(res.getString("CUR_TIME").substring(0, 5)+" - SYSTEM\n");                                                                                            
                                chatroom_ta.append(res.getString("USERNAME")+"'ve challanged you !\n");
                                chatroom_ta.append("Waiting for your action ...\n---\n");    
                                chatroom_ta.setCaretPosition(chatroom_ta.getDocument().getLength());                                                                                    
                                String msg = "<html>Accept challange from \n"+res.getString("USERNAME")+" ?";
                                String head = "Respond Challange";
                                int dialog = info.manageDialog(JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, msg, head);
                                if (dialog == JOptionPane.YES_OPTION) {
                                    opp_username = res.getString("USERNAME");                                    
                                    System.out.println("IN-GAME");
                                    try {
                                        Class.forName(this.driver);
                                        conn2 = DriverManager.getConnection(this.url, this.user, this.pass);                
                                        stm2 = conn2.createStatement();                
                                        query2 = "INSERT INTO CHAT_ROOM VALUES (CURDATE(),CURTIME(),'"+username_head_val.getText()+"','ACCEPT','"+opp_username+"');";
                                        stm2.execute(this.query2);
                                        stm2.close();
                                        conn2.close();
                                    } catch(Exception e) {System.out.println(e.toString());}
                                }
                            }
                            chatroom_ta.setCaretPosition(chatroom_ta.getDocument().getLength());                                                    
                            this.latest_chat_time = res.getString("CUR_TIME");                            
                        } else if (res.getString("TYPE").equals("ACCEPT")) {
                            chatroom_ta.append(res.getString("USERNAME")+" vs "+res.getString("CHAT")+" !\n---\n");                                                        
                            chatroom_ta.setCaretPosition(chatroom_ta.getDocument().getLength());                                                    
                            opp_username = res.getString("CHAT");                                                                                            
                            if (username_head_val.getText().equals(res.getString("USERNAME"))) {
                                try {
                                    TimeUnit.SECONDS.sleep(1);
                                    Class.forName(this.driver);
                                    conn3 = DriverManager.getConnection(this.url, this.user, this.pass);                
                                    stm3 = conn3.createStatement();                
                                    query3 = "INSERT INTO CHAT_ROOM VALUES (CURDATE(),CURTIME(),'"+username_head_val.getText()+"','INGAME','"+opp_username+"');";
                                    stm3.execute(this.query3);
                                    stm3.close();
                                    conn3.close();
                                    TimeUnit.SECONDS.sleep(1);          
                                } catch(Exception e) {System.out.println(e.toString());}              
                            }              
                            if (username_head_val.getText().equals(res.getString("USERNAME")) || username_head_val.getText().equals(res.getString("CHAT"))) {
                                gamecon.setPlayer1(res.getString("CHAT"));
                                gamecon.setPlayer2(res.getString("USERNAME")); 
                                gamecon.setCurrentPlayer(username_head_val.getText());
                                if (username_head_val.getText().equals(res.getString("USERNAME"))) {
                                    try {
                                        Class.forName(this.driver);
                                        conn4 = DriverManager.getConnection(this.url, this.user, this.pass);                
                                        stm4 = conn4.createStatement();                
                                        query4 = "INSERT INTO GAME_ROOM VALUES ('"+res.getString("CHAT")+"', '"+res.getString("CHAT")+"','"+res.getString("USERNAME")+"',0,0,0,'RUNNING','"+res.getString("CHAT")+"','ROLLING');";
                                        stm4.execute(this.query4);
                                        stm4.close();
                                        conn4.close();
                                    } catch(Exception e) {System.out.println(e.toString());}                                    
                                }                                              
                                gamecon.start();                                                                
                            }/*
                            try {
                                TimeUnit.SECONDS.sleep(1);                                
                                Class.forName(this.driver);
                                conn5 = DriverManager.getConnection(this.url, this.user, this.pass);                
                                stm5 = conn5.createStatement();                
                                query5 = "INSERT INTO CHAT_ROOM VALUES (CURDATE(),CURTIME(),'"+res.getString("CHAT")+"','CHAT','ONGOING ...');";
                                stm5.execute(this.query5);
                                stm5.close();
                                conn5.close();
                            } catch(Exception e) {System.out.println(e.toString());}    
                            */
                            this.latest_chat_time = res.getString("CUR_TIME");                                                        
                        } else {
                            this.finish_load = true;
                            this.latest_chat_time = res.getString("CUR_TIME");                            
                        }
                    }
                }
                stm.close();
                conn.close();
            } catch(Exception e) {System.out.println(e);}                               
        }
    }
    public void manageReqChallenge(JLabel username_head_val, String opp_username) {
        boolean check_player = false;
        try {            
            Class.forName(this.driver);
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            stm = conn.createStatement();
            query = "SELECT * FROM PLAYER WHERE USERNAME = '"+opp_username+"';";
            res = stm.executeQuery(this.query);
            while(res.next()) {check_player = true;}
            stm.close();
            conn.close();            
            //
            if (check_player) {
                System.out.println("Challenging ... "+opp_username);
                try {
                    Class.forName(this.driver);
                    conn = DriverManager.getConnection(this.url, this.user, this.pass);                
                    stm = conn.createStatement();                
                    query = "INSERT INTO CHAT_ROOM VALUES (CURDATE(),CURTIME(),'"+username_head_val.getText()+"','REQUEST','"+opp_username+"');";
                    stm.execute(this.query);
                    stm.close();
                    conn.close();                
                } catch(Exception e) {System.out.println(e);}
            }
        } catch(Exception e) {System.out.println(e);}                        
    }
    @Override
    public void run() {this.showChatLobby(this.chat_room_ta, this.username_head_val);}
}
