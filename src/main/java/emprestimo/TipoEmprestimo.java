package emprestimo;

public enum TipoEmprestimo {
    CREDITO("Empréstimo de crédito", 0.25),
    IMOVEL("Financiamento imobiliário", 0.1),
    VEICULO("Financiamento veicular", 0.12);

    protected Double taxa;
    protected String tipoFinanciamento;

    TipoEmprestimo(String tipoFinanciamento, Double taxa) {
        this.tipoFinanciamento = tipoFinanciamento;
        this.taxa = taxa;
    }

    public String getTipoFinanciamento() {
        return tipoFinanciamento;
    }

    public Double getTaxa() {
        return taxa;
    }

}