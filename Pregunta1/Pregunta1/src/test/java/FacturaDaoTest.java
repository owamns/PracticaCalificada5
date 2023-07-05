import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FacturaDaoTest extends SQLIntegrationTestBase{

    @Test
    public void testGuardar() throws SQLException {
        openConnectionAndCleanup();
        Factura factura = new Factura("Cliente", 300.0);
        getFacturaDao().guardar(factura);
        assertEquals(getFacturaDao().todo().get(0), factura);
    }

}
