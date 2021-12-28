import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ThreadTask implements Runnable {
	
	public final Socket clientSocket;
	public ThreadTask(Socket socket) {
		this.clientSocket = socket;
	}

	public void run() {
	     try{
	            Server.Serve(clientSocket);
	        }catch (Exception e){
	            e.printStackTrace(); 
	        }
	    
	}

	

}
