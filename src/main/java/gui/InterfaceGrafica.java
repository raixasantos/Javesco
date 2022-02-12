package gui;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import cliente.Cliente;
import emprestimo.Bem;
import emprestimo.GerenciadorFinanciamento;
import emprestimo.Juros;

// import emprestimo.Financiamento;
// import Emprestimo.GerenciarEmprestimo;

public class InterfaceGrafica {

    private static Integer paginaMenu = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static String escolha;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    InterfaceGrafica() {
    }
    
    /**
     * @throws IOException
     * 
     */
    public static void limparConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * 
     * @return
     */
    public static Cliente buildCliente() {
        Cliente cliente = new Cliente();

        limparConsole();
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        cliente.setNome(nome);

        limparConsole();
        System.out.print("Digite sua renda: ");
        try {
            Double valorRenda = scanner.nextDouble();
            cliente.setValorRenda(valorRenda);
        } catch (java.util.InputMismatchException e) {
            limparConsole();
            System.out.println("Formato da entrada de 'renda' invalido!");
            return null;
        }

        limparConsole();
        System.out.print("Digite sua idade: ");
        try {
            Integer idade = scanner.nextInt();
            cliente.setIdade(idade);
        } catch (java.util.InputMismatchException e) {
            limparConsole();
            System.out.println("Formato da entrada de 'idade' invalido!");
            return null;
        }

        limparConsole();
        System.out.print("Digite seu score: ");
        try {
            Double score = scanner.nextDouble();
            cliente.setScore(score);
        } catch (java.util.InputMismatchException e) {
            limparConsole();
            System.out.println("Formato da entrada de 'score' invalido!");
            return null;
        }

        limparConsole();

        return cliente;
    }

    /**
     * 
     * @param cliente
     * @param tipoBem
     */
    public static void simularFinanciamento(Cliente cliente, Bem tipoBem) {
        System.out.print("Digite o valor do emprestimo desejado: ");
        Integer valorFinanciamento = scanner.nextInt();
        limparConsole();

        if(GerenciadorFinanciamento.validarFinanciamento(valorFinanciamento, cliente)) {
            List<Juros> intervalo = GerenciadorFinanciamento.calcularIntervaloParcelas(valorFinanciamento, cliente);
            System.out.println("Parabens voce foi aprovado em seu financiameto de "+valorFinanciamento+"! ("+tipoBem.name()+")");
            System.out.println("As sua opções de parcelamento são:");
            intervalo.forEach(juros -> {
                System.out.println(juros.getPrazoMeses()+"x de R$"+df.format(juros.getParcela())+ ". Total: "+df.format(juros.calcularMontante()));
            });
            scanner.nextLine();// GAMBIARRA
            System.out.println("[Aperte qualquer tecla para voltar ao menu.]");
            scanner.nextLine();// GAMBIARRA
            limparConsole();
        }else
            System.out.println("Emprestimo negado!");
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
                            System.out.println("Opção invalida!");
                    }
                    break;
                case 1:
                    switch (escolha) {
                        case "1":
                            simularFinanciamento(cliente, Bem.VEICULAR);
                            break;
                        case "2":
                            simularFinanciamento(cliente, Bem.IMOVEL);
                            break;
                        case "0":
                            printDespedida();
                            break;
                        default:
                            System.out.println("Opção invalida!");
                    }
                    break;
            }
        }
    }
}

/*
 * TO DO
 * Javadoc
 * exception de preenchimento de dados do cliente/financiamento
 */