package example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Value;



public class JDBCConnection {
    @Value("${mysql.username}")
    private String userName;

    @Value("${mysql.password}")
    private String password;

    @Value("${mysql.url}")
    private String url;

    @Value("${mysql.driver}")
    private String driver;

    public void display() {
        System.out.println(userName + " " + url + " " + password + " " + driver);
    }

    public void getJDBCConnection() throws Exception {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, userName, password);
        System.out.println("Connection succesful: " + con);
        PreparedStatement ps = con.prepareStatement("SHOW TABLES");
        ResultSet set = ps.executeQuery();
        while (set.next()) {
            System.out.println(set.getString(1));
        }
        con.close();
    }
}
