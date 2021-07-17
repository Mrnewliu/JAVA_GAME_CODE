package com.hjc.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SocketClientDemo {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		String host = "localhost";
		int port = 4700;
		String msg = "send data from client";
		
		
		connect(host,port,msg.getBytes());
		
	}

	public static void connect(String serverIP,int servPort, byte[] data ) {
		
		Socket socket = null;
		try {
			socket = new Socket(serverIP,servPort);
			System.out.println("连接服务器并发送数据...");
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			out.write(data);
			
			//接受数据，目前收到的总字节数长度
			int totalBytesRcvd = 0;
			//最后一次读取的字节长度
			int bytesRcvd;
			//将服务器返回消息读到data字节数组中
			while( totalBytesRcvd < data.length){
				bytesRcvd = in.read(data,totalBytesRcvd,data.length - totalBytesRcvd);
				if( bytesRcvd == -1){
					throw new SocketException("连接中断......");
					
				}
				totalBytesRcvd += bytesRcvd;
			}
			System.out.println("接受的数据: "+ new String(data));
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(socket != null){
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}	
	}
	
}
