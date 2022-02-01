package Emprestimo;

public class Juros {
    private Integer prazoMeses;
    private Double montante;
    private Double taxaJuros;
    private Double taxaImposto;

    public Juros(Integer prazoMeses, Double montante, Double taxaJuros, Double taxaImposto){
        this.prazoMeses = prazoMeses;
        this.montante = montante;
        this.taxaJuros = taxaJuros;
        this.taxaImposto = taxaImposto;
    }

    public Integer getPrazoMeses(){
        return prazoMeses;
    }
    public Double getMontante(){
        return montante;
    }
    public Double getTaxaJuros(){
        return taxaJuros;
    }
    public Double getTaxaImposto(){
        return taxaImposto;
    }
    
    public void setPrazoMeses(Integer prazoMeses){
        this.prazoMeses = prazoMeses;
    }
    public void setMontante(Double montante){
        this.montante = montante;
    }
    public void setTaxaJuros(Double taxaJuros){
        this.taxaJuros = taxaJuros;
    }
    public void setTaxaImposto(Double taxaImposto){
        this.taxaImposto = taxaImposto;
    }
}
