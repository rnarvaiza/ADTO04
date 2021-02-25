import org.sonatype.inject.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {

    Connector conn = new Connector();

    public Statement statements() throws SQLException {
        Statement st;
        st = conn.initConn().createStatement();
        return st;
    }

    public void resultSet(String query) throws SQLException {
        ResultSet rs = statements().executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }
    }

}
