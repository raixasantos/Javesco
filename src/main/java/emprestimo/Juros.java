package emprestimo;

public class Juros {
    private Integer prazoMeses;
    private Double capital;
    private Double taxaJuros;
    private Double taxaImposto;

    public Juros(Double capital, Double taxaJuros, Integer prazoMeses){
        this.capital = capital;
        this.taxaJuros = taxaJuros;
        this.prazoMeses = prazoMeses;
    }

    public Juros(){}

    public Double calcularMontante(){
        // montante = capital * (1 + juros)^meses
        return capital * Math.pow((1 + taxaJuros), Math.round(prazoMeses/12));
    }
    public Double getParcela(){
        return calcularMontante()/prazoMeses;
    }
    public Integer getPrazoMeses(){
        return prazoMeses;
    }
    public Double getTaxaJuros(){
        return taxaJuros;
    }
    public Double getTaxaImposto(){
        return taxaImposto;
    }
    public Double getCapital(){
        return capital;
    }
    
    public void setCapital(Double capital){
        this.capital = capital;
    }

    public void setPrazoMeses(Integer prazoMeses){
        this.prazoMeses = prazoMeses;
    }
    public void setTaxaJuros(Double taxaJuros){
        this.taxaJuros = taxaJuros;
    }
    public void setTaxaImposto(Double taxaImposto){
        this.taxaImposto = taxaImposto;
    }
}
