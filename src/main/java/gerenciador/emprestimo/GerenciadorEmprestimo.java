package gerenciador.emprestimo;

import java.util.ArrayList;
import java.util.List;

import cliente.Cliente;
import emprestimo.Emprestimo;

/**
 * Implementação do gerenciador de empréstimos.
 */
public class GerenciadorEmprestimo {
    private static final Integer valorMaximoDeMeses = 120;
    private static final Double porcentagemRendaPermitida = 0.3;

    /**
     * Verifica se a idade do cliente está dentro do padrão estabelecido.
     *
     * @param cliente cliente que a idade será validada.
     * @return caso a idade esteja no intervalo, retorna true. Cc, retorna false.
     */
    public static boolean validarIdade(Cliente cliente) {
        return (cliente.getIdade() >= 18 && cliente.getIdade() <= 65);
    }

    /**
     * Verifica se o score do cliente está dentro do padrão estabelecido.
     *
     * @param cliente cliente que o score será validado.
     * @return caso o score esteja no intervalo, retorna true. Cc, retorna false.
     */
    public static boolean validarScore(Cliente cliente) {
        return (cliente.getScore() >= 600);
    }

    /**
     *  Faz a validação do crédito para poder liberar o valor que o cliente solicita
     *
     * @param emprestimo informações da classe Empréstimo que são usadas na validação
     * @param cliente informações pessoais do cliente para validar o crédito
     * @return uma lista de empréstimos
     */
    public static List<Emprestimo> validarCredito(Emprestimo emprestimo, Cliente cliente) {
        List<Emprestimo> intervalo = new ArrayList<>();
        boolean boolIdade = validarIdade(cliente);
        boolean boolScore = validarScore(cliente);
        if (boolIdade && boolScore)
            intervalo = calcularIntervaloParcelas(emprestimo, cliente);
        return intervalo;
    }

    /**
     * Calcula os empréstimos em tempos diferentes para o cliente poder escolher o melhor prazo e valor de parcela
     *
     * @param emprestimoSolicitado valor solicitado pelo cliente
     * @param cliente informações pessoais do cliente
     * @return lista de empréstimos que representa as opções de pagamento
     */
    public static List<Emprestimo> calcularIntervaloParcelas(Emprestimo emprestimoSolicitado, Cliente cliente) {
        List<Emprestimo> intervalo = new ArrayList<>();
        Double parcelaAnterior = 0.0;
        for (int prazo = 1; prazo <= valorMaximoDeMeses / 12; prazo++) {
            Emprestimo emprestimo = new Emprestimo(emprestimoSolicitado.getCapital(), emprestimoSolicitado.getTaxaJuros(), prazo * 12);
            if (prazo > 1) {
                if (emprestimo.getParcela() >= parcelaAnterior)
                    break;
            }
            if (emprestimo.getParcela() <= (cliente.getValorRenda() * porcentagemRendaPermitida)) {
                intervalo.add(emprestimo);
                parcelaAnterior = emprestimo.getParcela();
            }
        }
        return intervalo;
    }
}