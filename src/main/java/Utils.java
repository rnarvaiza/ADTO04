import org.sonatype.inject.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void trimmedResultSet(String query) throws SQLException {
        ResultSet rs = statements().executeQuery(query);
        while(rs.next()){
            String firstString = rs.getString(1);
            String secondString = rs.getString(2);
                int index = secondString.indexOf(':');
                if (secondString != null & secondString.length()>index){
                    System.out.println(firstString + " " + secondString.substring(3, (index + 3)));
                }
        }
    }

    public void updateResult(String query) throws SQLException{
        statements().executeUpdate(query);
    }

}
