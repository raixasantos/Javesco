package cliente;

public class Cliente {
    private String nome;
    private Integer idade;
    private Double score;
    private Double valorRenda;

    public Cliente() {
    }

    public Cliente(String nome, Double valorRenda, Integer idade, Double score) {
        this.nome = nome;
        this.valorRenda = valorRenda;
        this.idade = idade;
        this.score = score;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Double getScore() {
        return score;
    }

    public Double getValorRenda() {
        return valorRenda;
    }
}