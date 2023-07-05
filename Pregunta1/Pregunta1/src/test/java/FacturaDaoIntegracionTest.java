import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class FacturaDaoIntegracionTest {

    @BeforeEach
    public void openConnectionAndCleanup() throws SQLException {
        Connection connection = new Conexion().restablecerConexion();
        String sql = "DELETE FROM factura";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        connection.close();
    }

    @Test
    public void testTodoConAlMenos() throws SQLException {
        FacturaDao dao = new FacturaDao();
        Factura factura = new Factura("cliente1", 100.0);
        Factura factura2 = new Factura("cliente2", 200.0);
        dao.guardar(factura);
        dao.guardar(factura2);

        assertEquals(dao.todosConAlMenos(150).get(0), factura2);
    }
    @Test
    public void testGuardar() throws SQLException {

        FacturaDao dao = new FacturaDao();
        Factura factura = new Factura("cliente1", 150.0);
        dao.guardar(factura);

        assertEquals(dao.todo().get(0), factura);
    }

}