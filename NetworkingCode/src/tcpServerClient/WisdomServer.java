package tcpServerClient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WisdomServer {
	public static void main(String args[]) throws Exception {
		int portNumber = 50000;
		
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(portNumber);
		Wisdom w = new Wisdom();
		
		int count = 0;
		System.out.println("Wisdom Server is running");
		while (true) {
			Socket clientSocket = serverSocket.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket
					.getInputStream()));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(clientSocket
					.getOutputStream()));
			String name = reader.readLine();
			writer.println("Hello " + name);
			writer.println(w.getWisdom());
			writer.flush();
			clientSocket.close();
			count++;
			System.out.println("SERVER: Handled "+count+" client(s)");
		}
	}
}
