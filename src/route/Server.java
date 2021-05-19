package route;
import java.io.*;
import java.net.*;
import function.*;
//
public class Server extends Thread{
    //
    private int port_number, range_min, range_max;
    private String message;
    private File filename = new File("src/log/open-ports.log");
    //
    public Server(int range_min, int range_max) {this.range_min = range_min; this.range_max = range_max;}
    public void listen() {
        this.port_number = (int)Math.floor(Math.random()*(this.range_max-this.range_min+1)+this.range_min);
        LoginFunc login_func = new LoginFunc();
        System.out.println("lobby port : #" + this.port_number);
        try {
            try (
            FileWriter fw = new FileWriter(this.filename, true); 
            BufferedWriter bw = new BufferedWriter(fw)) 
            {
                bw.write(this.getName() + "\tID-" + this.getId() + "\tRoom-#" + this.port_number + "\n");
                bw.flush();
                bw.close();
                fw.close();
            }
        } catch(IOException e) {System.out.println("[SRVR] " + e);}
        while(true) {
            try {
                try (ServerSocket port = new ServerSocket(this.port_number)) {
                    Socket s = port.accept();
                    DataInputStream stdin = new DataInputStream(s.getInputStream());
                    this.message = (String)stdin.readUTF();
                    System.out.println("message = " + this.message);
                    port.close();
                }
                if (this.message.equals("exit")) {
                    login_func.removeRoom(this.port_number);
                    break;
                }
            } catch(IOException e) {System.out.println("[SRVR] " + e);}
        }
    }
    public int getPortNumber() {return this.port_number;}
    public void run() {listen();}
}
