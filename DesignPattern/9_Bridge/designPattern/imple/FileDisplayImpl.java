package designPattern.imple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDisplayImpl implements DisplayImpl {

	private File file;
	private FileReader read;

	public FileDisplayImpl() {
		this.file = new File("C:\\Users\\merut\\Desktop\\study\\デザインパターン\\9_Bridge\\test.txt");
	}



	@Override
	public void rawOpen() {

		try {
			read = new FileReader(file);


		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rawPrint() {
		String string;
		BufferedReader line = new BufferedReader(read);
		try {
			while((string = line.readLine()) != null){
				System.out.println(">" + string);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		try{line.close();

		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rawClose() {
		System.out.println("============");


	}

}
