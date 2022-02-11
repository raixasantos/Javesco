package Emprestimo;

import java.util.Date;

public class Financiamento extends Emprestimo{
    public enum Bem {
        IMOVEL,
        VEICULAR;
    }

    private Bem bem;

    public Financiamento(Date dataInicio, Date dataFim, Double valorTotal, Juros juros, Bem bem) {
        super(dataInicio, dataFim, valorTotal, juros);
        this.bem = bem;
    }
}
