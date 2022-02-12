package emprestimo;

/**
 * Enum que possui os tipos de empréstimo
 */
public enum TipoEmprestimo {
    CREDITO("Empréstimo de crédito", 0.25),
    IMOVEL("Financiamento imobiliário", 0.1),
    VEICULO("Financiamento veicular", 0.12);

    protected Double taxa;
    protected String tipoFinanciamento;

    /**
     *
     * @param tipoFinanciamento Tipo do financiamento escolhido pelo cliente
     * @param taxa Taxa de juro utilizada para calcular o empréstimo solicitado
     */
    TipoEmprestimo(String tipoFinanciamento, Double taxa) {
        this.tipoFinanciamento = tipoFinanciamento;
        this.taxa = taxa;
    }

    /**
     *
     * @return retorna o tipo de financiamento escolhido
     */
    public String getTipoFinanciamento() {
        return tipoFinanciamento;
    }

    /**
     *
     * @return retorna o valor da taxa utilizada no cálculo
     */
    public Double getTaxa() {
        return taxa;
    }

}