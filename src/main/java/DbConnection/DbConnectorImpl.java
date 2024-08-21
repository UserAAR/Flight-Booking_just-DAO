package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectorImpl implements DbConnector {
    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;
    private Connection connection;

    public DbConnectorImpl(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    @Override
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                return true;
            } else {
                System.out.println("connection is null");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
