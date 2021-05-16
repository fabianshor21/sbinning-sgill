package route;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.time.*;
//
public class Server extends Thread {
	//
	private int pnumber, min, max;
	private String msg;
	private File filename = new File("log/open-ports.log");
	//
	public Server(int min, int max) {this.min = min; this.max = max;}
	public void listen() {
		this.pnumber = (int)Math.floor(Math.random()*(this.max-this.min+1)+this.min);
		RoomHandler room = new RoomHandler();
		Scanner read = new Scanner(System.in);
		System.out.println("lobby port : #" + this.pnumber + "\n---");
		try {
			FileWriter fw = new FileWriter(filename, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("#" + this.pnumber + "\n");
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {System.out.println("[SERVER] " + e);}
		while (true) {
			try {
				ServerSocket port = new ServerSocket(pnumber);
				Socket s = port.accept();
				DataInputStream dis = new DataInputStream(s.getInputStream());
				this.msg = (String)dis.readUTF();
				System.out.println("message = " + this.msg);
				port.close();
				if (this.msg.equals("exit")) {
					room.removeRoom(this.pnumber);
					break;
				}
			} catch (Exception e) {System.out.println("[SERVER] " + e);}
		}
	}
	public void run() {listen();}
}
