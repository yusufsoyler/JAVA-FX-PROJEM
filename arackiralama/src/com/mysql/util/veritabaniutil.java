package com.mysql.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class veritabaniutil {
	static Connection conn=null;
	
	public static Connection Baglan() {
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/arackiralama","root","");
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
			return null;
		}
	}

}
