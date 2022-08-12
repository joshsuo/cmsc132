package toyWebServer;

/* From browser you can retrieve data as follows */
/* http://localhost:8080/testudo.jpg */
/* http://localhost:8080/quotes.txt  */
/* http://localhost:8080/exercise.pdf */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.util.regex.*;

public class WebServer {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(8080);
		Pattern pattern = Pattern.compile("GET /(.+) (HTTP/1.0|HTTP/1.1)");

		while (true) {
			System.out.println("Web Server Running");
			Socket s = ss.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			String request = in.readLine();
			System.out.println("Request received: " + request);

			Matcher matcher = pattern.matcher(request);
			matcher.find();
			String fileName = matcher.group(1);
			File file = new File("htdocs/" + fileName);
			String contentType = URLConnection.getFileNameMap().getContentTypeFor(file.toString());
			System.out.println("Content type detected: " + contentType);

			/* Adding the file contents */
			try {
				/* Opening the file */
				FileInputStream fileInputStream = new FileInputStream(file);

				/* Writing the header */
				out.print("HTTP/1.1 200 OK" + "\n");
				out.print("Content-Length: " + file.length() + "\n");
				out.print("Content-Type: " + contentType + "\n");
				out.print("\n");
				out.flush();
				int byteOfData = fileInputStream.read();
				while (byteOfData != -1) {
					s.getOutputStream().write(byteOfData);
					byteOfData = fileInputStream.read();
				}
				out.flush();
				out.close();
				fileInputStream.close();

			} catch (FileNotFoundException e) {
				out.println("HTTP/1.1 404 Not Found");
				out.println("Content-Type: text/html\n");
				out.println();
				out.println("<h1>Invalid Request</h1>");
				out.close();
			}
		}
	}
}