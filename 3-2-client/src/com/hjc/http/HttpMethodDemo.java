package com.hjc.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HttpMethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "http://localhost:8080/3-2-server//HttpServer";
		String reslut = "";
		try {
			reslut = httpPost(path);
			System.out.println(reslut);
			reslut = httpGet(path);
			System.out.println(reslut);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	/**
	 * GET方法demo
	 * @param path
	 * @return
	 * @throws IOException
	 * 
	 * */
	public static String httpGet(String path) throws IOException  {
		URL url = new URL(path + "?param1=hjc1&param2=hjc2");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sBuffer = new StringBuffer();
		String line = "";
		while(  (line = reader.readLine() ) != null) {
			sBuffer.append(line).append("\r\n");
			
			
		}
		reader.close();
		return sBuffer.toString();
		
		
	}
	
	/*
	 * 
	 * POST方法demo
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String httpPost(String path) throws IOException  {
		URL url = new URL(path);
		HttpURLConnection conn =(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		
		conn.setDoOutput(true);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		
		writer.write("param1=hjc1&param2=hjc2");
		writer.close();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sBuffer = new StringBuffer();
		String line = "";
		while( (line = reader.readLine() ) != null ) {
			
			sBuffer.append(line).append("\r\n");
		}
		reader.close();
		
		
		return sBuffer.toString();
		
	}
	
	
}
