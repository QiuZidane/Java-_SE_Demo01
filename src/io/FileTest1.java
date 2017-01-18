package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

import javax.xml.soap.Text;

public class FileTest1 {

	public static final String FILE1 = File.separator + "Users" + File.separator + "EvaZis/test2.txt";
	private static FileTest1 fileHander;
	
	public static FileTest1 getFileHander(){
		if (fileHander == null) {
			FileTest1 f1 = new FileTest1();
			fileHander = f1;
			return fileHander;
		} else {
			return fileHander;
		}
	}
	
	
	/**
	 * 将终端输入信息输出到文件
	 * 
	 * @param pathname
	 * @throws IOException
	 */
	public void writeFileWithInput(String pathname) throws IOException {

		File file = new File(pathname);
		Writer out = new FileWriter(file);

		try (Scanner in = new Scanner(System.in);) {
			String text = in.nextLine();
			out.write(text);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}

	/**
	 * 读取字符数据
	 * 
	 * @param pathname
	 */
	public void readFile(String pathname) {
		File file = new File(pathname);
		try {

			// reader1的方法和reader等价
			// BufferedReader reader1 = new BufferedReader(new
			// InputStreamReader(new FileInputStream(file)));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String text = null;
			while ((text = reader.readLine()) != null) {
				System.out.println(text);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建文件
	 */
	public void createFile() {
		// File.pathSeparator 在mac下是:
		// File.separator 在mac下是\
		// /Users/EvaZis
		String filename = File.separator + "Users" + File.separator + "EvaZis/test2.txt";
		File f = new File(filename);
		try {
			f.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除文件
	 */
	public void delFile() {
		String filename = File.separator + "Users" + File.separator + "EvaZis/test2.txt";
		File f = new File(filename);
		if (f.exists()) {
			f.delete();
		} else {
			System.err.println("文件不存在");
		}
	}

	/**
	 * 复制文件 复制到的文件如果不存在，会创建
	 * 
	 */
	public void copyFile() {

		String filename1 = File.separator + "Users" + File.separator + "EvaZis/test2.txt";
		String filename2 = File.separator + "Users" + File.separator + "EvaZis/test3.txt";

		try (InputStream inputStream = new FileInputStream(new File(filename1));
				OutputStream outputStream = new FileOutputStream(new File(filename2));) {

			if (inputStream != null && outputStream != null) {
				int temp = 0;
				while ((temp = inputStream.read()) != -1) {
					outputStream.write(temp);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向文件写入字符串，用的是字节流，无缓存，速度可能慢点
	 */
	public void writeStrToFile_Byte(String content) {
		String str = "";
		File f = new File(FILE1);
		try (OutputStream outputStream = new FileOutputStream(f);) {
			if (content == null) {
				str = "ABC哈哈";
			}else{
				str=content;
			}
			byte[] b = str.getBytes();
			outputStream.write(b);
			byte[] c= new byte[]{-27, -109, -120};
			System.out.println(new String(c));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 向文件写入字符串，用字符流，有缓存，速度快
	 */
	public void writeStrToFile_buffer(String content) {
		String str = "";
		File f = new File(FILE1);
		try (BufferedWriter out = new BufferedWriter(new FileWriter(f));) {
			if (content == null) {
				str = "ABC哈哈";
			}else{
				str=content;
			}
			out.write(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String pathname = "/Users/EvaZis/Documents/NewBird^^/Missions/bugs/1111.txt";
		FileTest1 f1 = new FileTest1();
		// f1.readFile(pathname);
		// f1.createFile();
		// f1.delFile();
		// f1.copyFile();
//		f1.writeStrToFile_Byte(null);
		f1.writeStrToFile_buffer("用缓存了!");

	}

}
