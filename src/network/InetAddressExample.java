package network;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class InetAddressExample {

	public static void main(String[] args) throws IOException {

		try {
			//返回包含了该主机每一个接口所对应的 NetworkInterface 类实例
			Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
			
			// 即使主机没有任何网络连接，也会有回环接口:127.0.0.1
			if (interfaceList == null) {
				System.err.println("--No interfaces found--");
			} else {
				while (interfaceList.hasMoreElements()) {
					NetworkInterface networkInterface = interfaceList.nextElement();
					System.out.println("Interface " + networkInterface.getName());
					Enumeration<InetAddress> addrList = networkInterface.getInetAddresses();
					if (!addrList.hasMoreElements()) {
						System.err.println("(No addresses for this interface)");
					}
					
					// 判断每个地址类型
					while (addrList.hasMoreElements()) {
						InetAddress inetAddress = addrList.nextElement();
						System.out.print("Address " + ((inetAddress instanceof Inet4Address ? "(V4)"
								: (inetAddress instanceof Inet6Address ? "(V6)" : "(?)"))));
						System.out.println(": " + inetAddress.getHostAddress());
					}
				}
			}

		} catch (SocketException e) {
			System.err.println("Error getting network interfaces:" + e.getMessage());
		}
		
		String[] hostArgs = {"www.163.com", "www.abc123.com","127.0.0.1"};
		for (String host : hostArgs) {
			try {
				System.out.println(host + ":");
				InetAddress[] addressList = InetAddress.getAllByName(host);
				for (InetAddress address : addressList) {
					if (address.isReachable(2000)) {
						System.out.println(address.getHostName() + " is reachable");
						System.out.println(address.toString() + " is reachable");
						System.out.println(address.getCanonicalHostName() + " is reachable");
						System.out.println(address.getHostName() + "/" + address.getHostAddress());
					}else{
						System.err.println("cannot reach "+address.getHostName());
					}

				}
			} catch (UnknownHostException e) {
				System.err.println("Unable to find address for " + host);
			}

		}

	}

}
