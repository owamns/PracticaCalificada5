import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLIntegrationTestBase {
    private FacturaDao facturaDao = new FacturaDao();

    public void openConnectionAndCleanup() throws SQLException {
        Connection connection = new Conexion().restablecerConexion();
        String sql = "DELETE FROM factura";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        connection.close();
    }

    public FacturaDao getFacturaDao() {
        return facturaDao;
    }
}
