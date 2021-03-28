package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName = "test.exe";
		byte[] inputBytes = {0};
		long startTime, endTime;
		
		System.out.println(Paths.get(fileName));
		inputBytes = Files.readAllBytes(Paths.get(fileName));
		startTime = System.currentTimeMillis();
		StringBuffer outputStringBuffer = new StringBuffer();
		for(byte b : inputBytes) {
			outputStringBuffer.append((char) b);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time = " + (endTime - startTime));
	}

}
