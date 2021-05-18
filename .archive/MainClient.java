import route.*;
import page.*;
import java.util.Scanner;
//
public class MainClient {
	//
	public static void main(String[] args) {
		Lobby lobby = new Lobby();
		Peer peer = new Peer();
		RoomHandler room = new RoomHandler();
		Scanner read = new Scanner(System.in);
		System.out.print("1. create game\n2. join game\n---\n>> "); char opt = read.next().charAt(0);
		switch(opt) {
			case '1':
				Server server = new Server(10000, 65000);
				server.start();
				System.out.println("thread in : " + server.getName() + "(" + server.getId() + ")");
				break;
			case '2':
				System.out.println("---"); room.showLobby();
				System.out.println("---");
				System.out.print("join port : #"); int joinport = read.nextInt();
				System.out.print("send text : "); String msg = read.next();
				peer.respond(joinport, msg);
				break;
		}
	}
}
