package EX1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		ServerSocket server =null;
		Socket client;
		try {
			server = new ServerSocket(1234);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while(true) {
			
			try {
				System.out.println("Waiting for connect request...");
				client = server.accept();
				System.out.println("Waiting for connect request...");
				
				String clientHost = client.getInetAddress().getHostAddress();
				int clientPort = client.getPort();
				System.out.println("Client host = " + clientHost + " Client port = " + clientPort);
				
				// Read data from the client
				InputStream in = client.getInputStream();
				Scanner clientInput = new Scanner(in);
				
				while(clientInput.hasNext()) {
					System.out.println(clientInput.next());
				}
				OutputStream out = client.getOutputStream();
				PrintWriter pt = new PrintWriter(out);
				pt.println("Hello!!");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
