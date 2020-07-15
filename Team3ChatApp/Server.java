package Team3ChatApp;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

	private int port;
	public List<PrintStream> clients;
	private ServerSocket server;

	public static void main(String[] args) throws IOException {
		new Server(8765).run();
	}

	public Server(int port) {
		this.port = port;
		this.clients = new ArrayList<PrintStream>();
	}

	public void run() throws IOException {
		server = new ServerSocket(port) {
			protected void finalize() throws IOException {
				this.close();
			}
		};
		System.out.println("Listening on port " + Integer.toString(port));

		while (true) {
			Socket client = server.accept();
			System.out.println("Connection established with client: " + client.getInetAddress().getHostAddress());
			
			this.clients.add(new PrintStream(client.getOutputStream()));
			
			new Thread(new ClientHandler(this, client.getInputStream())).start();
		}
	}

	public List<PrintStream> getClients() {
		return this.clients;
	}
	
	void broadcastMessages(String msg) {
		for (PrintStream client : this.clients) {
			client.println(msg);
		}
	}
}

class ClientHandler implements Runnable {

	private Server server;
	private InputStream client;

	public ClientHandler(Server server, InputStream client) {
		this.server = server;
		this.client = client;
	}

	@Override
	public void run() {
		String message;
		
		Scanner sc = new Scanner(this.client);
		while (sc.hasNextLine()) {
			message = sc.nextLine();
			
			if (message.contains("/users")) {
				System.out.println("Message /users: " + message);
				for (PrintStream client : server.clients) {
					server.broadcastMessages(client.toString());
				}
			} else {
				System.out.println("Message normal: " + message);
				server.broadcastMessages(message);
			}
		}
		sc.close();
	}
}