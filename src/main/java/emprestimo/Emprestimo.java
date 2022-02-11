package emprestimo;

import java.util.Date;

public class Emprestimo {
    private Date dataInicio;
    private Date dataFim;
    private Double valorTotal;
    private Juros juros;

    public Emprestimo(Date dataInicio, Date dataFim, Double valorTotal, Juros juros){
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorTotal = valorTotal;
        this.juros = juros;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Juros getJuros() {
        return juros;
    }
}
