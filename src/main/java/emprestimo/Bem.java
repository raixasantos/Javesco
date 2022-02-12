package emprestimo;

public enum Bem {
    IMOVEL("imobiliário"),
    VEICULO("veicular");

    protected Double valor;
    protected String tipoFinanciamento;

    Bem(String tipoFinanciamento){
        this.tipoFinanciamento = tipoFinanciamento;
    }

    public String getTipoFinanciamento(){
        return tipoFinanciamento;
    }

    public Double getValor() {
        return valor;
    }

}