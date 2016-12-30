package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class IOTest1 {
	public void fileTest() throws FileNotFoundException {
		InputStream f = new FileInputStream("test.txt");
	}
	

}
