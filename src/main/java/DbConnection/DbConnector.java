package DbConnection;

import java.sql.Connection;

public interface DbConnector {
    Connection getConnection();
    boolean closeConnection();
}
