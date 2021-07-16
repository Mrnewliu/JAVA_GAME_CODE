package com.hjc.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hello");
		
		
		try {
			String des = "http://www.baidu.com";
			URL url = new URL(des);
			//打开链接
			HttpURLConnection conn =(HttpURLConnection)url.openConnection();
			//获取输入流，并用BufferedReader惊醒封装
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sBuffer = new StringBuffer();
			String line = "";
			//读取返回流中的内容
			while( (line = reader.readLine() ) != null ) {
				sBuffer.append(line).append("\r\n");
				
			
			}
			//打印状态码
			System.out.println("http response code =======>"+conn.getResponseCode());
			//打印内容
			System.out.println("http response=====>"+sBuffer);
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
		
		
		
		
		
		
	}

}
