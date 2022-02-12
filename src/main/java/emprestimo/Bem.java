package emprestimo;

public enum Bem {
    IMOVEL,
    VEICULAR;

    protected Double valor;

    public Double getValor() {
        return valor;
    }
}