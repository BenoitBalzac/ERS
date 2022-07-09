package ConnectionFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLconnectionFactory {
	
	public final static Properties properties = new Properties();
	
	static {
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/datasource.properties");
			properties.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static {
		
		try {
			Class.forName(properties.getProperty("datasource.driver-class"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
    public static Connection getLoginConnection() throws SQLException {
        // step-2: create db-connection
        String url = properties.getProperty("datasource1.url");
        String username = properties.getProperty("datasource.username");
        String password = properties.getProperty("datasource.password");
        return DriverManager.getConnection(url, username, password);
    }
    
    public static Connection getReimbursementConnection() throws SQLException {
        // step-2: create db-connection
        String url = properties.getProperty("datasource2.url");
        String username = properties.getProperty("datasource.username");
        String password = properties.getProperty("datasource.password");
        return DriverManager.getConnection(url, username, password);
    }

}
