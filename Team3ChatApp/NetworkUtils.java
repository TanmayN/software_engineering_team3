package Team3ChatApp;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class NetworkUtils {
	public static <T> Future<Boolean> portIsOpen(final ExecutorService es, final String ip, final int port, final int timeout) {
		  @SuppressWarnings("unchecked")
		Callable<T> callable = (Callable<T>) new Callable<Boolean>() {
		      @Override public Boolean call() {
		        try {
		          Socket socket = new Socket();
		          socket.connect(new InetSocketAddress(ip, port), timeout);
		          socket.close();
		          return true;
		        } catch (Exception ex) {
		          return false;
		        }
		      }
		   };
		@SuppressWarnings("unchecked")
		Future<Boolean> submit = (Future<Boolean>) es.submit(callable);
		return submit;
		}
	
	public int[] getRunningServers() {
		 final ExecutorService es = Executors.newFixedThreadPool(20);
		  final String ip = "127.0.0.1";
		  final int timeout = 200;
		  final ArrayList<Future<Boolean>> futures = new ArrayList<>();
		  for (int port = 1; port <= 65535; port++) {
		    futures.add(portIsOpen(es, ip, port, timeout));
		  }
		  int[] openPorts = new int[100];
		  
		  
		  int counter = 0;
		  int port = 0;
		  for (final Future<Boolean> f : futures) {
			    if (f.get()) {
			     counter++;
			      openPorts[counter] = 
			    }
			  }
		  
		  
		  
		  
		  
	}
}
