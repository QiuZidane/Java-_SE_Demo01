package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @see TCP服务器
 * @author EvaZis 工作步骤： 1.创建ServerSocket实例并制定本地端口，用于监听指定端口收到的连接 2.重复执行：
 *         a.调用ServerSocket的accept()方法获取下一个客户端连接，基于该连接创建Socket实例。
 *         b.使用上一步中的Socket实例的InputStream和OutputStream与客户端通信
 *         c.通信完成后，使用Socket.close()关闭该客户端的套接字连接
 *
 */
public class TCPEchoServer {

	private static final int BUFSIZE = 32; // 接收缓存器大小

	public static void main(String[] margs) throws IllegalAccessException, IOException {

		String[] args = {"9090"}; 
		
		if (args.length != 1) {
			throw new IllegalAccessException("参数错误");
		}

		int servPort = Integer.parseInt(args[0]);

		ServerSocket serverSocket = new ServerSocket(servPort);

		int recvMsgSize; // 接收信息的大小

		byte[] receiveBuf = new byte[BUFSIZE]; // 接收缓存器

		while (true) { // 长期运行，接收和发送的连接

			// accept()方法会阻塞等待，直到有新的连接请求到来
			// 如果服务端未调用accept()，连接就已经到达，那么连接将排入队列中，这时一调用accept()就会立刻响应了
			Socket clientSocket = serverSocket.accept(); // 获取客户端连接

			SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();

			System.out.println("正在处理客户端地址:" + clientAddress);

			InputStream in = clientSocket.getInputStream();
			OutputStream out = clientSocket.getOutputStream();

			while ((recvMsgSize = in.read(receiveBuf)) != -1) {
				// 读取输入并立刻输出，所以offset都是0
				out.write(receiveBuf, 0, recvMsgSize);
			}

			clientSocket.close();

		}
	}

}
