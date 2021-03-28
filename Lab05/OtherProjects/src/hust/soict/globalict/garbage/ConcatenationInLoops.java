package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConcatenationInLoops {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName = "C:/Users/ADMIN/OneDrive/code/Coffee-Shop/build/tests/system_ut/system_sign_in_ut.exe";
		byte[] inputBytes = {0};
		long startTime, endTime;
		
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
