package route;
import java.sql.*;
import javax.swing.*;
import window.*;
import function.*;
import java.util.concurrent.TimeUnit;

public class GameConn extends Thread {
    private InGame game;
    private String username, opp_username;
    public void setUsername(String username) {this.username = username;}
    public void setOppUsername(String opp_username) {this.opp_username = opp_username;}
    public void runInGame() {
        game = new InGame();
        game.setVisible(true);
        game.setJLabel1(this.username);
        game.setJLabel2(opp_username);
    }
    @Override
    public void run() {this.runInGame();}
}
