public class Numero {
    private int codigo;
    private String numero;
    private Tipo tipo;

    public Numero() {
        tipo = new Tipo();
    }

    public Numero(int codigo, String numero, Tipo tipo) {
        this.codigo = codigo;
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
}
