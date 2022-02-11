package gerenciador.emprestimos;

import cliente.Cliente;

/**
 * Implementação do gerenciador de empréstimos.
 */
public class GerenciadorEmprestimos {
    /**
     * Verifica se o score do cliente está dentro do padrão estabelecido.
     * @param cliente cliente que o score será validado.
     * @return caso o score esteja no intervalo, retorna true. Cc, retorna false.
     */
    public boolean validarScore(Cliente cliente) {
        if(cliente.getScore() >= 650) return true;
        return false;
    }

    /**
     * Verifica se a idade do cliente está dentro do padrão estabelecido.
     * @param cliente cliente que a idade será validada.
     * @return caso a idade esteja no intervalo, retorna true. Cc, retorna false.
     */
    public boolean validarIdade(Cliente cliente) {
        if(cliente.getIdade() < 18 || cliente.getIdade() > 65) return false;
        return true;
    }
}
