import java.io.*;
import java.net.*;
public class ThreadedServer {

	public static void main(String[] args) {
		try {
			ServerSocket serversocket = new ServerSocket(2011);
			while(true) {
				Socket Client = serversocket.accept();
				new Thread(new ThreadTask(Client)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
