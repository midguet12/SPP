package dataaccess;

import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.Assert.*;
import org.junit.Test;

public class DataBaseConnectionTest {
    private final DataBaseConnection dbc;
    
    public DataBaseConnectionTest() {
        dbc = new DataBaseConnection();
    }
    @Test
    public void testStartConnection() {
        Connection connection = dbc.getConnection();

        assertNotNull(connection);
    }

    @Test
    public void testCloseConnection() throws SQLException {
        Connection connection = dbc.getConnection();
        dbc.closeConnection();
        assertTrue(connection.isClosed());
    }
    
}
