package tcpServerClient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class WisdomClient {
	public static void main(String args[]) throws Exception {
		String host = "localhost";
		
		if (args.length > 0)
			host = args[0];
		InetAddress serverIP = InetAddress.getByName(host);
		int portNumber = 50000;

		Socket clientSocket = new Socket(serverIP, portNumber);
		BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket
				.getInputStream()));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(clientSocket
				.getOutputStream()));
		writer.println("Bill");
		writer.flush();
		String response = reader.readLine();
		System.out.println("CLIENT: "+response);
		response = reader.readLine();
		System.out.println("CLIENT: "+response);
		clientSocket.close();
	}
}