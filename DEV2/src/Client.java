import java.io.*; 
import java.net.*;
import java.util.*;

public class Client {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		try {
		Socket socket = new Socket("localhost", 2011);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String serverInput = in.readLine();
		System.out.println(serverInput);
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		System.out.println("choose a command : <List> , <Get> or <Quit> ");
		String command = sc.nextLine();
		out.println(command);
		String message = in.readLine();
		System.out.println(message);
        in.close();
        out.close();
        socket.close();

		
		
		
		} catch(Exception e) {
			System.out.println(e.toString());
			
		}
		
	}

}
