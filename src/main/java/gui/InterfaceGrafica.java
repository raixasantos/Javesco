package gui;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import cliente.Cliente;
import emprestimo.TipoEmprestimo;
import gerenciador.emprestimo.GerenciadorEmprestimo;
import emprestimo.Emprestimo;

public class InterfaceGrafica {

    private static Integer paginaMenu;
    private static Scanner scanner = new Scanner(System.in);
    private static String escolha;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    InterfaceGrafica() {
    }

    public static void limparConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * @return
     */
    public static Cliente buildCliente() {
        String nome;
        Double valorRenda;
        Integer idade;
        Double score;

        limparConsole();
        System.out.print("Digite seu nome: ");
        nome = scanner.nextLine();

        limparConsole();
        System.out.print("Digite sua renda: ");
        try {
            valorRenda = scanner.nextDouble();
        } catch (java.util.InputMismatchException e) {
            limparConsole();
            System.out.println("Formato da entrada de 'renda' invalido!");
            return null;
        }

        limparConsole();
        System.out.print("Digite sua idade: ");
        try {
            idade = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            limparConsole();
            System.out.println("Formato da entrada de 'idade' invalido!");
            return null;
        }

        limparConsole();
        System.out.print("Digite seu score: ");
        try {
            score = scanner.nextDouble();
        } catch (java.util.InputMismatchException e) {
            limparConsole();
            System.out.println("Formato da entrada de 'score' invalido!");
            return null;
        }

        limparConsole();

        return new Cliente(nome, valorRenda, idade, score);
    }

    /**
     * @param cliente
     * @param tipo
     */
    public static void simularFinanciamento(Cliente cliente, TipoEmprestimo tipo) {
        System.out.print("Digite o valor do emprestimo desejado: ");
        Double capital = scanner.nextDouble();
        Emprestimo emprestimoSolicitado = new Emprestimo(capital, tipo);
        limparConsole();

        List<Emprestimo> intervalo = GerenciadorEmprestimo.validarCredito(emprestimoSolicitado, cliente);

        if (!intervalo.isEmpty()) {
            System.out.print("Parabéns " + cliente.getNome() + "! Você foi aprovado em seu crédito de R$" + df.format(capital) + "!");
            System.out.println(" (" + tipo.getTipoFinanciamento() + " com taxa de " + Math.round(tipo.getTaxa()*100) + "%)");
            System.out.println("Suas opções de parcelamento são:");
            intervalo.forEach(juros -> {
                System.out.println("        -" + juros.getPrazoMeses() + " parcelas de R$" + df.format(juros.getParcela()) + ". Total de R$" + df.format(juros.getMontante()) + ".");
            });
            scanner.nextLine();// GAMBIARRA
            System.out.println("[Aperte a tecla enter para voltar ao menu]");
            scanner.nextLine();// GAMBIARRA
            limparConsole();
        } else
            System.out.println(tipo.getTipoFinanciamento() + " negado!");
    }

    /**
     *
     */
    public static void printAssinatura() {
        System.out.println("=============================");
        System.out.println("        Banco Javesco        ");
        System.out.println("=============================");
    }

    /**
     *
     */
    public static void printDespedida() {
        scanner.close();
        System.out.println("Obrigado e até a próxima!");
        System.out.println("Javesco, Sempre à frente.");
        System.exit(0);
    }

    /**
     *
     */
    public static void printOpcoesMenu() {
        switch (paginaMenu) {
            case 0:
                System.out.println("1 - Inserir dados de Cliente");
                break;
            case 1:
                System.out.println("1 - Financiamento veicular");
                System.out.println("2 - Financiamento imobiliário");
                System.out.println("3 - Empréstimo pessoal");
                break;
        }
        System.out.println("0 - Sair");
        System.out.print("Selecione uma opção: ");
    }

    /**
     *
     */
    public static void menu() {
        Cliente cliente = new Cliente();
        paginaMenu = 0;

        while (true) {
            printAssinatura();
            printOpcoesMenu();
            escolha = scanner.nextLine();

            limparConsole();

            switch (paginaMenu) {
                case 0:
                    switch (escolha) {
                        case "1":
                            cliente = buildCliente();
                            scanner.nextLine(); // GAMBIARRA
                            if (cliente == null)
                                break;
                            System.out.println("Dados inseridos com sucesso.");
                            paginaMenu++;
                            break;
                        case "0":
                            printDespedida();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;
                case 1:
                    switch (escolha) {
                        case "1":
                            simularFinanciamento(cliente, TipoEmprestimo.VEICULO);
                            break;
                        case "2":
                            simularFinanciamento(cliente, TipoEmprestimo.IMOVEL);
                            break;
                        case "3":
                            simularFinanciamento(cliente, TipoEmprestimo.CREDITO);
                            break;
                        case "0":
                            printDespedida();
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;
            }
        }
    }
}