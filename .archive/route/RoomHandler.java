package route;
import java.io.*;
import java.net.*;
import java.util.Scanner;
//
public class RoomHandler {
	//
	private File filename = new File("log/open-ports.log");
	private File filetemp = new File("log/open-ports.log.tmp");
	private String line;
	//
	public void removeRoom(int port) {
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(filetemp);
			BufferedWriter bw = new BufferedWriter(fw);
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
		} catch (Exception e){System.out.println("[SERVER] " + e);}
	}

	public void showLobby() {
		try {
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null) {System.out.println(line);}
		} catch (IOException e){System.out.println("[SERVER] " + e);}
	}
}
