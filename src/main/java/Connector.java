import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {

    private static final String URL ="jdbc:postgresql://161.35.134.66:5432/rnarvaiza";
    private static final String USER="rnarvaiza";
    private static final String PASSWORD="032699";
    private static final String ADD_VALUES_COMERCIAL_1="\n" + "+ \"'{{\\\"pedidos 8:30\\\",\\\"lineal 11:30\\\"},\"\n" + " + \"{\\\"proveedores 14:30\\\", \\\"RRHH 18:30\\\"}}')";
    private static final String ADD_VALUES_COMERCIAL_2="\"'{{\\\"debrief 8:30\\\",\\\"comida 15:30\\\"},\"\n" + " + \"{\\\"visita madrid 10:30\\\", \\\"firmar contratos 16:30\\\"}}')";

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
