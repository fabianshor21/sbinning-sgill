package function;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import route.*;
//
public class LoginFunc {
    //
	private File filename = new File("src/log/open-ports.log");
	private File filechat = new File("src/log/chat.log");    
	private File filetemp = new File("src/log/open-ports.log.tmp");
	private String line, message;    
    //
    public int execListener(JTextArea log_ta) {
        Server server = new Server(10000, 65000);
        server.start();
        this.showLobby(log_ta);
        return server.getPortNumber();
    }
    public void execResponmder(JTextArea roomid_ta, JTextArea username_ta, JTextArea lobbchat_ta) {
        Peer peer = new Peer();
        peer.respond(Integer.parseInt(roomid_ta.getText()), username_ta.getText());
    }
    public void showLobby(JTextArea log_ta) {
        try {        
            try {Thread.sleep(500);} catch (InterruptedException ex) {Logger.getLogger(LoginFunc.class.getName()).log(Level.SEVERE, null, ex);}
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
            log_ta.setText("");
			while ((line = br.readLine()) != null) {
                log_ta.append(" " + line + "\n");
            }
		} catch (IOException e){System.out.println("[SRVR] " + e);}        
    }
	public void removeRoom(JTextArea room_ta) {
		try {
			FileReader fr = new FileReader(filename);
            try (BufferedReader br = new BufferedReader(fr)) {
                FileWriter fw = new FileWriter(filetemp);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    while ((line = br.readLine()) != null) {
                        if (!line.equals("#" + room_ta.getText())) {
                            bw.write(line+"\n");
                            bw.flush();
                        }
                    }
                    bw.close();
                    br.close();
                    filename.delete();
                    filetemp.renameTo(filename);                    
                }
            }
		} catch (IOException e){System.out.println("[SRVR] " + e);}
	}
}
