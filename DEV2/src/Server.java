import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	public static void main(String[] args)throws Exception {

		ServerSocket serversocket = new ServerSocket(2011);
		
		while (true) {
		    Socket socket = serversocket.accept();
			Serve(socket);
			socket.close();
			}
	}
		public static void Serve(Socket socket) {
			try {
			    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println("Server Listening on Port: " + 2011);
			    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			    String Command = in.readLine();
			    String cmdTab [] = new String [2];
			    cmdTab = Command.split(" ");
			    if(cmdTab[0].equals("List")) {
			        File Rep = new File (cmdTab[1]);
			        if(Rep.exists()) {
			        	String send = " the file's list in " + cmdTab[1] + "repository is : ";
			        	for(int i = 0; i < Rep.list().length; i++) {
			        		send = send +  " - " +  Rep.list()[i];
			        		}
			        	out.println(send);
			        }else {
			        	out.println("ERROR : directory does not exist");
			        }

			    }else if(cmdTab[0].equals("Get")) {
			            File file = new File(cmdTab[1]);
			        	if(file.exists()) {
			                Scanner fileReader = new Scanner(file);
			        		String send = "the file's content is: ";	
			        		while(fileReader.hasNextLine()){ 
			                       send = send + fileReader.nextLine();
			                    }
			        		out.println(send);
			        		
			        	} else {
			        		out.println("ERROR : File does not exist");
			        	}
			        }
			        else if(cmdTab[0].equals("Quit") ) {
			        	out.println("session closed");
			        }
			        else {
			        	out.println("error");
			        } 
	                in.close();
	                out.close();
	               
				} catch(Exception e) {
			          System.out.println(e.toString());
		}
	}

}
