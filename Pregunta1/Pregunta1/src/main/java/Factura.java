import java.util.Objects;
public class Factura {
    private final String cliente;
    private final double valor;
    public Factura(String cliente, double valor) {
        this.cliente = cliente;
        this.valor = valor;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return valor == factura.valor &&
                cliente.equals(factura.cliente);
    }
    @Override
    public int hashCode() {
        return Objects.hash(cliente, valor);
    }
    @Override
    public String toString() {
        return "Factura{" +
                "cliente='" + cliente + '\'' +
                ", valor=" + valor +
                '}';
    }
    public double obtenerValor() {
        return valor;
    }

    public String obtenerCLiente(){
        return cliente;
    }
}