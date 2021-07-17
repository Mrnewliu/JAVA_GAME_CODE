package com.hjc.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		run();
	}

	public static void run(){
		int servPort = 4700;
		//创建服务端socket
		ServerSocket servSocket = null;
		int recvMsgSize = 0;
		//接受字节缓冲数组
		byte[] receivBuf = new byte[32];
		try {
			servSocket = new ServerSocket(servPort);
			
			while(true){
				//等待客户端连接
				System.out.println("服务端已启动，绑定端口:"+servPort);
				Socket clientSocket = servSocket.accept();
				SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();
				System.out.println("收到客户端连接" + clientAddress );
				InputStream in = clientSocket.getInputStream();
				OutputStream out = clientSocket.getOutputStream();
				
				while( (recvMsgSize = in.read( receivBuf) ) != -1 ){
					String receivedData = new String( receivBuf.toString() );
					System.out.println(receivedData);
					out.write(receivBuf, 0, recvMsgSize ); 
				}
				clientSocket.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
