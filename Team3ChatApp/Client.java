package Team3ChatApp;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private String host;
	private int port;
	private String nickname;

	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client("127.0.0.1", 1234).run();
	}

	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void run() throws UnknownHostException, IOException {
		Socket client = new Socket(host, port);
		System.out.println("Connected!");

		new Thread(new ReceivedMessagesHandler(client.getInputStream())).start();

		Scanner sc = new Scanner(System.in);
		System.out.print("Nickname: ");
		nickname = sc.nextLine();

		System.out.println("Text: ");
		PrintStream output = new PrintStream(client.getOutputStream());
		while (sc.hasNextLine()) {
			output.println(nickname + ": " + sc.nextLine());
		}
		
		output.close();
		sc.close();
		client.close();
	}
	
	public Boolean isAlive() {
		return true;
	}
	
}

class ReceivedMessagesHandler implements Runnable {

	private InputStream server;

	public ReceivedMessagesHandler(InputStream server) {
		this.server = server;
	}

	@Override
	public void run() {
		Scanner s = new Scanner(server);
		while (s.hasNextLine()) {
			System.out.println(s.nextLine());
		}
		s.close();
	}
}