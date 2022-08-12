package textfiles;

import java.io.FileReader;
import java.io.*;

public class FileReaderEx {
	public static void main(String[] args) {
		FileReader fileReader = null;
		
		try {
			/* Try with an invalid filename */
			fileReader = new FileReader("fileReader.txt");
			int c;
			while ((c = fileReader.read()) != -1) {
				System.out.print((char) c);
			}
			fileReader.close();
		} catch (IOException e) {
			/* Notice use of System.err */
			System.err.println(e.getMessage());
		}
	}
}