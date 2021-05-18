import route.*;
import window.*;
import java.util.Scanner;
//
public class Main {
    //
    private static char option;
    private static Server server;
    private static int port_number;
    private static String message;
    //
    public static void main(String[] args) {
        Login login_page_1 = new Login(); login_page_1.setVisible(true);
        Login login_page_2 = new Login(); login_page_2.setVisible(true);        
        Peer peer = new Peer();
        RoomHandler room = new RoomHandler();
        /*
        Scanner read = new Scanner(System.in);        
        System.out.println("1 | create room\n2 | join room\n---\n>> "); option = read.next().charAt(0);
        switch(option) {
            case '1':
                server = new Server(10000, 65000);
                server.start();
                System.out.println("thread in : " + server.getName() + " - " + server.getId());
                break;
            case '2':
                System.out.println("---"); room.showLobby(); System.out.println("---");
                System.out.print("join room : #"); port_number = read.nextInt();
                System.out.print("send exec : "); message = read.next();
                peer.respond(port_number, message);
                break;                
        }
        */
    }   
}
