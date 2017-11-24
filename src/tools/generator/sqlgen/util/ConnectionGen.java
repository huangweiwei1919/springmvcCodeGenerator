package sqlgen.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ConnectionGen {
	
	
	public static Connection getConection() throws SQLException, IOException, ClassNotFoundException{
		Properties res = new Properties();
		InputStream in = ConnectionGen.class.getClassLoader().getResourceAsStream("init.properties");
		res.load(in);
		in.close();
//		System.out.println(res.getProperty("jdbc.driverClassName")); 
//		System.out.println(res.getProperty("jdbc.url")); 
//		System.out.println(res.getProperty("jdbc.username")); 
//		System.out.println(res.getProperty("jdbc.password")); 
		
		Class.forName(res.getProperty("jdbc.driverClassName"));
		return DriverManager.getConnection(res.getProperty("jdbc.url"), res.getProperty("jdbc.username"), res.getProperty("jdbc.password"));
		
//		return dataSource.getConnection();
//		return  null;
	}

}
