package route;
import java.io.*;
import java.net.*;
//
public class Peer {
    //
    private int port_number;
    private String message;
    //
    public void respond(int port_number, String message) {
        try {
            this.port_number = port_number;
            this.message = message;
            try (
            Socket s = new Socket("localhost", this.port_number); 
            DataOutputStream stdout = new DataOutputStream(s.getOutputStream())) 
            {
                stdout.writeUTF(this.message);
                stdout.flush();
                stdout.close();
                s.close();
            }
        } catch(IOException e) {System.out.println("[PEER] " + e);}
    }
    public int getPortNumber() {return this.port_number;}
    public String getMessage() {return this.message;}
}
