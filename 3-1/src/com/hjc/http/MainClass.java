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
			//������
			HttpURLConnection conn =(HttpURLConnection)url.openConnection();
			//��ȡ������������BufferedReader���ѷ�װ
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sBuffer = new StringBuffer();
			String line = "";
			//��ȡ�������е�����
			while( (line = reader.readLine() ) != null ) {
				sBuffer.append(line).append("\r\n");
				
			
			}
			//��ӡ״̬��
			System.out.println("http response code =======>"+conn.getResponseCode());
			//��ӡ����
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
