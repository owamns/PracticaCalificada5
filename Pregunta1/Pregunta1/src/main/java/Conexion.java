import java.sql.*;
public class Conexion {
    private String url = "jdbc:mysql://localhost:3306/EMPRESA";
    private Connection connection = null;
    public Connection restablecerConexion(){
        try {
            connection = DriverManager.getConnection(url, "root", "Fernandezfa.1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
