import java.sql.*;
import java.util.ArrayList;

public class FacturaDao {

    public void guardar(Factura factura) throws SQLException {
        Connection connection = new Conexion().restablecerConexion();

        String sql = "INSERT INTO factura (nombre, valor) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, factura.obtenerCLiente());
        statement.setDouble(2, factura.obtenerValor());

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    private ArrayList<Factura> facturasConsulta(String sql) throws SQLException {
        ArrayList<Factura> facturas = new ArrayList<>();
        Connection connection = new Conexion().restablecerConexion();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            facturas.add(new Factura(resultSet.getString("nombre"), resultSet.getDouble("valor")));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return facturas;
    }

    public ArrayList<Factura> todo() throws SQLException {
        return facturasConsulta("SELECT * FROM factura");
    }

    public ArrayList<Factura> todosConAlMenos(double valor) throws SQLException {
        return facturasConsulta("SELECT * FROM factura WHERE valor>="+valor);
    }

    public static void main(String[] args) {

        FacturaDao dao = new FacturaDao();
        try {
            for (Factura factura : dao.todosConAlMenos(130)){
                System.out.println(factura.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

