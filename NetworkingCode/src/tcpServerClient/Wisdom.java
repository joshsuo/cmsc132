package tcpServerClient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Wisdom {
	ArrayList<String> oneLiners = new ArrayList<String>();

	SecureRandom random = new SecureRandom();

	public Wisdom() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("one-liners.txt"));
		String s;
		
		while ((s = in.readLine()) != null) {
			oneLiners.add(s);
		}
		
		in.close();
	}

	public String getWisdom() {
		return oneLiners.get(random.nextInt(oneLiners.size()));
	}

}
