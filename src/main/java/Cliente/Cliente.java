package Cliente;

import Emprestimo.Financiamento;

public class Cliente {
    private String nome;
    private String CPF;
    private Integer idade;
    private Double score;
    private Integer pontos;
    private Double valorRenda;
    private boolean negativado;
    private Financiamento financiamento;

    Cliente(String nome, Double valorRenda, Integer idade, Double score) {}

    public boolean validarScore(){
        if(score >= 650) {
            return true;
        }
        return false;
    }

    public boolean validarIdade(){
        if(idade < 18 || idade > 65) {
            return false;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome_) {
        nome = nome_;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cpf_) {
        CPF = cpf_;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade_) {
        idade = idade_;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos_) {
        pontos = pontos_;
    }

    public Double getValorRenda() {
        return valorRenda;
    }

    public void setValorRenda(Double valorRenda_) {
        valorRenda = valorRenda_;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score_) {
        score = score_;
    }

    public boolean getNegativado() {
        return negativado;
    }

    public void setNegativado(boolean negativado_) {
        negativado = negativado_;
    }

    public Financiamento getFinanciamento() {
        return financiamento;
    }

    public void setFinanciamento(Financiamento financiamento_) {
        financiamento = financiamento_;
    }



}