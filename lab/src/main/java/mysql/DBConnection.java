package main.java.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

import main.resources.config.IPconfig;

public class DBConnection {
	   IPconfig iPconfig =new IPconfig();
		String driver = "com.mysql.jdbc.Driver";
	    String url= "jdbc:mysql://"+iPconfig.IP+":3306/book?useUnicode=true&characterEncoding=utf-8";
	    String user = "root";
	    String password = "root";
	    
	    public Connection conn;

	    public DBConnection() {

	        try {
	            Class.forName(driver);
	            conn = (Connection) DriverManager.getConnection(url, user, password);// 杩炵画鏁版嵁搴�
	            
	            if(!conn.isClosed())
	                System.out.println("Succeeded connecting to the Database!"); 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void close() {
	        try {
	            this.conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
