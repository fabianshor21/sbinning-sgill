package route;
import java.io.*;
//
public class RoomHandler {
	//
	private File filename = new File("src/log/open-ports.log");
	private File filetemp = new File("src/log/open-ports.log.tmp");
	private String line;
	//
	public void removeRoom(int port) {
		try {
			FileReader fr = new FileReader(filename);
            try (BufferedReader br = new BufferedReader(fr)) {
                FileWriter fw = new FileWriter(filetemp);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    while ((line = br.readLine()) != null) {
                        if (!line.equals("#"+port)) {
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

	public void showLobby() {
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {System.out.println(line);}
		} catch (IOException e){System.out.println("[SRVR] " + e);}
	}
}
