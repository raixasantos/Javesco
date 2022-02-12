package emprestimo;

public class Emprestimo {
    private Integer prazoMeses;
    private Double capital;
    private Double taxaJuros;
    private TipoEmprestimo tipo;

    public Emprestimo(Double capital, TipoEmprestimo tipo) {
        this.capital = capital;
        this.tipo = tipo;
    }

    public Emprestimo(Double capital, Double taxaJuros, Integer prazoMeses) {
        this.capital = capital;
        this.taxaJuros = taxaJuros;
        this.prazoMeses = prazoMeses;
    }

    public Double getMontante() {
        return capital * Math.pow((1 + taxaJuros), Math.round(prazoMeses / 12));
    }

    public Double getCapital() {
        return capital;
    }

    public Double getParcela() {
        return getMontante() / prazoMeses;
    }

    public Integer getPrazoMeses() {
        return prazoMeses;
    }

    public Double getTaxaJuros() { return tipo.getTaxa(); }
}
