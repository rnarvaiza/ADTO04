import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Rafa Narvaiza
 * Connector aiming to own server.
 */

public class Connector {

    private static final String URL ="jdbc:postgresql://161.35.134.66:5432/rnarvaiza";
    private static final String USER="rnarvaiza";
    private static final String PASSWORD="032699";

    public Connection initConn(){
        Connection conn= null;
        String url = "";
        Properties props = new Properties();
        props.setProperty("user",USER);
        props.setProperty("password",PASSWORD);
        try {
            conn = DriverManager.getConnection(URL, props);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return conn;
    }
}
