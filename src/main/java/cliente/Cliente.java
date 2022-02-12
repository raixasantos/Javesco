package cliente;

/**
 * Implementação da classe Cliente que recebe os dados pessoais do cliente
 */
public class Cliente {
    private String nome;
    private Integer idade;
    private Double score;
    private Double valorRenda;

    public Cliente() {
    }

    /**
     *
     * @param nome representa nome do usuário.
     * @param valorRenda representa a renda do cliente
     * @param idade representa a idade do cliente
     * @param score representa o valor de score do cliente
     */
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