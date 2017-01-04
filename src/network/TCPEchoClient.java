package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPEchoClient {

	/**
	 * 
	 * @param args
	 * java TCPEchoClient server.example.com "Echo this"
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		if ((args.length < 2) || (args.length > 3)) {
			throw new IllegalArgumentException("IllegalArgumentException Parameter(s)");
		}

		String server = args[0]; // 服务器名字或ip地址
		
		byte[] data = args[1].getBytes(); // 用默认码制将字符串转换为bytes类型
		
		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
		
		Socket socket = new Socket(server, servPort);
		
		System.out.println("Connected to server...sending echo string");
		
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		
		out.write(data); // 发送反馈的字符串到服务器
		
		
		
		
		
		

	}

}
