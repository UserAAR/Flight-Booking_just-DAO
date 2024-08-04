package DbConnection;

import java.sql.Connection;

public interface Dbconnector {
    Connection getConnection();
    boolean closeConnection();
}
