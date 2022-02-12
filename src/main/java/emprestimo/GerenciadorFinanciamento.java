package emprestimo;

import java.util.ArrayList;
import java.util.List;

import emprestimo.Juros;
import cliente.Cliente;

public class GerenciadorFinanciamento {
    private static final Integer valorMaximoDeMeses = 120;
    private static final Double porcentagemRendaPermitida = 0.3;
    private static final Double jurosFinanciamento = 0.1;

    public static boolean validarFinanciamento(Integer valorFinanciamento, Cliente cliente) {
        boolean boolIdade = validarIdade(cliente);
        boolean boolScore = validarScore(cliente);
        boolean boolRenda = validarRenda(valorFinanciamento, cliente);
        if (!boolIdade || !boolScore || !boolRenda)
            return false;
        return true;
    }

    public static boolean validarIdade(Cliente cliente) {
        return (cliente.getIdade() >= 18 && cliente.getIdade() <= 65);
    }

    public static boolean validarScore(Cliente cliente) {
        return (cliente.getScore() >= 600);
    }

    public static boolean validarRenda(Integer valorFinanciamento, Cliente cliente) {
        return calcularParcelaMinima(valorFinanciamento, cliente)
                .getParcela() < (cliente.getValorRenda() * porcentagemRendaPermitida);
    }

    public static List<Juros> calcularIntervaloParcelas(Integer valorFinanciamento, Cliente cliente) {
        List<Juros> intervalo = new ArrayList<Juros>();

        for(int prazo = valorMaximoDeMeses / 12; prazo > 0; prazo--) {
            Juros juros = new Juros(valorFinanciamento.doubleValue(), jurosFinanciamento, prazo*12);
            
            if (juros.getParcela() > (cliente.getValorRenda() * porcentagemRendaPermitida))
                break;
            intervalo.add(juros);
        }
    
        return intervalo;
    }

    public static Juros calcularParcelaMinima(Integer valorFinanciamento, Cliente cliente) {
        Juros juros = new Juros();
        juros.setTaxaJuros(jurosFinanciamento);
        juros.setCapital(valorFinanciamento.doubleValue());
        juros.setPrazoMeses(valorMaximoDeMeses);

        return juros;
    }
}