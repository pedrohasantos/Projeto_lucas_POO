import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorContas gerenciador = new GerenciadorContas(10);

        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar Conta");
            System.out.println("2. Depositar Valor");
            System.out.println("3. Sacar Valor");
            System.out.println("4. Transferir Valor");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
    // Exibe o menu com as opções de entrada para o usuario
            switch (opcao) {
                case 1:
                    adicionarConta(gerenciador, scanner);
                    break;
                case 2:
                    depositarValor(gerenciador, scanner);
                    break;
                case 3:
                    sacarValor(gerenciador, scanner);
                    break;
                case 4:
                    transferirValor(gerenciador, scanner);
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
    // Função para adicionar uma nova conta bancária ao gerenciador de contas
    public static void adicionarConta(GerenciadorContas gerenciador, Scanner scanner) {
        System.out.println("\n--- Adicionar Conta ---");
        System.out.println("Informe o nome: ");
        String nome = scanner.next();
        System.out.println("Informe o saldo: ");
        double saldo = scanner.nextDouble();
        System.out.println("Informe o tipo da conta: ");
        String tipoConta = scanner.next();
        ContaBancaria conta = new ContaBancaria(nome, saldo, tipoConta);
        gerenciador.adicionarConta(conta);
        System.out.println("Conta adicionada com sucesso!");
    }
    // Função para depositar um valor em uma conta bancária específica
    public static void depositarValor(GerenciadorContas gerenciador, Scanner scanner) {
        System.out.println("\n--- Depositar Valor ---");
        System.out.println("Informe o índice da conta: ");
        int indice = scanner.nextInt();
        System.out.println("Informe o valor a ser depositado:");
        double valor = scanner.nextDouble();
        gerenciador.depositarValor(indice, valor);
    }
    // Função para sacar um valor de uma conta bancária específica
    public static void sacarValor(GerenciadorContas gerenciador, Scanner scanner) {
        System.out.println("\n--- Sacar Valor ---");
        System.out.println("Informe o índice da conta:");
        int indice = scanner.nextInt();
        System.out.println("Informe o valor a ser sacado:");
        double valor = scanner.nextDouble();
        gerenciador.sacarValor(indice, valor);
    }
    // Função para transferir um valor entre duas contas bancárias
    public static void transferirValor(GerenciadorContas gerenciador, Scanner scanner) {
        System.out.println("\n--- Transferir Valor ---");
        System.out.println("Informe o índice da conta de origem:");
        int origem = scanner.nextInt();
        System.out.println("Informe o índice da conta de destino:");
        int destino = scanner.nextInt();
        System.out.println("Informe o valor a ser transferido:");
        double valor = scanner.nextDouble();
        gerenciador.transferirValor(origem, destino, valor);
    }
}
