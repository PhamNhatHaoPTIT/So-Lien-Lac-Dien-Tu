
package database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.util.Properties;


public class Connect {
    public static Connection getConnection() {
        Connection conn = null;
        String str = "jdbc:mysql://localhost:3306/" + "schoolsystem" + "?user=" + "root" + "&password=" + "1234" + "&useUnicode=true&characterEncoding=UTF-8";
        Properties pro = new Properties();
        pro.put("user", "root");
        pro.put("pass", "1234");
        try {
            Driver driver = new Driver();
            conn = (Connection) driver.connect(str, pro);
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
