package emprestimo;

/**
 * Implementação da classe Empréstimo que realiza o cálculo do empréstimo
 */
public class Emprestimo {
    private Integer prazoMeses;
    private Double capital;
    private Double taxaJuros;
    private TipoEmprestimo tipo;

    /**
     *
     * @param capital valor solicitado pelo cliente
     * @param tipo guarda o tipo do empréstimo (crédito ou financiamento(veicular ou imobiliário))
     */
    public Emprestimo(Double capital, TipoEmprestimo tipo) {
        this.capital = capital;
        this.tipo = tipo;
    }

    /**
     *
     * @param capital valor solicitado pelo cliente
     * @param taxaJuros taxa de juros utilizada para calcular o montante
     * @param prazoMeses quantidade de meses em que o pagamento do empréstimo será parcelado
     */
    public Emprestimo(Double capital, Double taxaJuros, Integer prazoMeses) {
        this.capital = capital;
        this.taxaJuros = taxaJuros;
        this.prazoMeses = prazoMeses;
    }

    /**
     *  Calcula o montante
     *
     * @return retorna o valor do montante
     */
    public Double getMontante() {
        return capital * Math.pow((1 + taxaJuros), Math.round(prazoMeses / 12));
    }

    /**
     *
     * @return valor retornado é o valor desejado pelo cliente
     */
    public Double getCapital() {
        return capital;
    }

    /**
     *
     * @return calculado e retornado o valor solicitado com juros dividido pelos meses a serem pagos gerando a parcela
     */
    public Double getParcela() {
        return getMontante() / prazoMeses;
    }

    /**
     *
     * @return prazo em meses
     */
    public Integer getPrazoMeses() {
        return prazoMeses;
    }

    /**
     *
     * @return retorna a taxa de juros usada no cálculo
     */
    public Double getTaxaJuros() { return tipo.getTaxa(); }
}
