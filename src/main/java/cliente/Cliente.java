package cliente;

public class Cliente {
    private String nome;
    private Integer idade;
    private Double score;
    private Integer pontos;
    private Double valorRenda;
    private boolean negativado;

    public Cliente(String nome, Double valorRenda, Integer idade, Double score) {
        this.nome = nome;
        this.valorRenda = valorRenda;
        this.idade = idade;
        this.score = score;
    }

    public Cliente() {}

    public void setPontos(Integer pontos) { this.pontos = pontos; }

    public void setNegativado(boolean negativado) { this.negativado = negativado; }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Integer getPontos() {
        return pontos;
    }

    public Double getValorRenda() {
        return valorRenda;
    }

    public Double getScore() {
        return score;
    }

    public boolean getNegativado() {
        return negativado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setValorRenda(Double valorRenda) {
        this.valorRenda = valorRenda;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}