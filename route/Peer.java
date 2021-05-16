package route;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.time.*;
//
public class Peer {
	//
	private int pnumber;
	private String msg;
	//
	public void respond(int pnumber, String msg) {
		try {
			this.pnumber = pnumber;
			this.msg = msg;
			Socket s = new Socket("localhost", this.pnumber);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF(this.msg);
			dos.flush();
			dos.close();
			s.close();
		} catch (Exception e){System.out.println("[CLIENT] " + e);}
	}

	public int getPortNumber() {return this.pnumber;}
	public String getMessage() {return this.msg;}
}
