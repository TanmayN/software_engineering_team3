package tests_ChatApp;

import org.junit.jupiter.api.Test;

import Team3ChatApp.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.Socket;


public class TestSuite {
	
	@Test
	public void ServerStartTest() {
		Server server = new Team3ChatApp.Server(8765);
		Socket s = null;
		try {
			s = new Socket("127.0.0.1", 8765);
			assertNotNull(s);
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		server = null;
	}
	
	
	@Test
	public void ClientConnectionTest() {
		Server server = new Team3ChatApp.Server(8765);
		Client client = new Team3ChatApp.Client("127.0.0.1", 8765);
		
		assertEquals(true, client.isAlive());
		
		server = null;
		client = null;
	}
	
	@Test
	public void ClientConnectionFalseTest() {
		Server server = new Team3ChatApp.Server(9182);
		Client client = new Team3ChatApp.Client("127.0.0.1", 3211);
		
		assertEquals(client.isAlive(), false);
		
	}
	
	
}
