import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class FacturaDaoIntegracionTest {

    @Test
    public void testGuardar() throws SQLException {

        Connection connection = new Conexion().restablecerConexion();
        String sql = "DELETE FROM factura";
        Statement statement = connection.createStatement();
        statement.execute(sql);

        statement.close();
        connection.close();

        FacturaDao dao = new FacturaDao();
        Factura factura = new Factura("cliente1", 150.0);
        dao.guardar(factura);

        assertEquals(dao.todo().get(0), factura);

    }
}