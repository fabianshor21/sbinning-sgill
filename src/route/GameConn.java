package route;
import java.sql.*;
import javax.swing.*;
import window.*;
import java.sql.*;
import javax.swing.*;
import window.*;
import function.*;
import java.util.concurrent.TimeUnit;

public class GameConn extends Thread {
    private InGame game;
    private String player1, player2, current_player;
    public void setPlayer1(String player1) {this.player1 = player1;}
    public void setPlayer2(String player2) {this.player2 = player2;}
    public void setCurrentPlayer(String current_player) {this.current_player = current_player;}
    public void runInGame() {
        game = new InGame();
        game.player1 = this.player1;
        game.player2 = this.player2;
        game.current_player = this.current_player;
        System.out.println(this.player1);
        System.out.println(this.player2);        
        game.setVisible(true);
        game.fetchInfo();
    }
    @Override
    public void run() {this.runInGame();}
}
