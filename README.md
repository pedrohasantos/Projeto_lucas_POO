# Projeto_lucas_POO
//Pedro Henrique Afonso dos Santos RA:00000849096
tema escolhido:
Pojeto 3, Sistema Bancário.

//Main, inserev os valores para a classe "ContaBancaria e atualiza o saldo com o rendimento" e exibe o saldo atual;

    public class Main {
        public static void main(String[] args) {
            GerenciadorContas gerenciador = new GerenciadorContas(3);
    
            ContaBancaria conta1 = new ContaBancaria("pedro", 297.30, "corrente");
            ContaBancaria conta2 = new ContaBancaria("julia", 256.20, "corrente");
            ContaBancaria conta3 = new ContaBancaria("pablo", 400.20, "poupança");
    
            gerenciador.adicionarConta(0, conta1);
            gerenciador.adicionarConta(1, conta2);
            gerenciador.adicionarConta(2, conta3);
    
            System.out.println("Contas do tipo poupança terão um rendimento de 6,75%");// adicional escolhido para dar um toque a mais no código e simular uma situação real
    
            for (int i = 0; i < gerenciador.tamanho(); i++) {
                ContaBancaria conta = (ContaBancaria) gerenciador.obterConta(i);
                if (conta.tipoConta.equals("poupança")) {
                    double saldoAntes = conta.saldo;
                    conta.depositarValor(saldoAntes * 0.0675); 
                    System.out.println("Rendimento adicionado à conta de " + conta.nome);
                    System.out.println("Saldo antes: " + saldoAntes + " Saldo depois: " + conta.saldo);
                }
            }
        }
    }
//------------------------------------------------------------------------------------------------------------------------------
//Classe conta bancaria, cria a "struct" com as variaveis nome do cliente, saldo atual e o tipo de conta(corrente ou poupança)

    public class ContaBancaria {
        String nome;
        double saldo;
        String tipoConta;
    
        public ContaBancaria(String nome, double saldo, String tipoConta) {
            this.nome = nome;
            this.saldo = saldo;
            this.tipoConta = tipoConta;
        }
    
        public void depositarValor(double valor) {
            saldo += valor;
            if (tipoConta.equals("poupança")){
                saldo *= 1.0675;
            }
        }
    
        public void sacarValor(double valor) {
            if (saldo - valor < 0) { //Valida se a operação resulta em uma conta negativa
                System.out.println("Saldo insuficiente");
            } else {
                saldo -= valor;
            }
        }
        
    
        public void printar() {
            System.out.println("Nome: " + nome);
            System.out.println("Saldo: " + saldo);
            System.out.println("Tipo de Conta: " + tipoConta);
        }
    }
//--------------------------------------------------------------------------------------------------------------------------------------
//Classe que utiliza um array para armazenar as contas diferentes

    class GerenciadorContas {
        private ContaBancaria[] contas;
        private int tamanhoAtual;
    
        public GerenciadorContas(int tamanho) {
            contas = new ContaBancaria[tamanho];
            tamanhoAtual = 0;
        }
    
        public void adicionarConta(int indice, ContaBancaria conta) {
            contas[indice] = conta;
            tamanhoAtual++;
        }
    
        public ContaBancaria obterConta(int indice) {
            return contas[indice];
        }
    
        public int tamanho() {
            return tamanhoAtual;
        }
