public class Main {
    public static void main(String[] args) {
        GerenciadorContas gerenciador = new GerenciadorContas(3);

        ContaBancaria conta1 = new ContaBancaria("pedro", 297.30, "corrente");
        ContaBancaria conta2 = new ContaBancaria("julia", 256.20, "corrente");
        ContaBancaria conta3 = new ContaBancaria("pablo", 400.20, "poupança");

        gerenciador.adicionarConta(0, conta1);
        gerenciador.adicionarConta(1, conta2);
        gerenciador.adicionarConta(2, conta3);

        System.out.println("Contas do tipo poupança terão um rendimento de 6,75%");

        for (int i = 0; i < gerenciador.tamanho(); i++) {
            ContaBancaria conta = gerenciador.obterConta(i);
            if (conta.tipoConta.equals("poupança")) {
                double saldoAntes = conta.saldo;
                conta.depositarValor(saldoAntes * 0.0675); 
                System.out.println("Rendimento adicionado à conta de " + conta.nome);
                System.out.println("Saldo antes: " + saldoAntes + " Saldo depois: " + conta.saldo);
            }
        }
    }
//------------------------------------------------------------------------------------
    public static class ContaBancaria {
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

        public void pix(int origem, int destino, double valor, GerenciadorContas gerenciador) {
            ContaBancaria contaOrigem = gerenciador.obterConta(origem);
            ContaBancaria contaDestino = gerenciador.obterConta(destino);

            if (contaOrigem == null || contaDestino == null) {
                System.out.println("Conta de origem ou destino inválida.");
                return;
            }
            if (contaOrigem.saldo < valor) {
                System.out.println("Saldo insuficiente na conta de origem.");
                return;
            }
            contaOrigem.sacarValor(valor);
            contaDestino.depositarValor(valor);
            System.out.println("Transferência de " + valor + " realizada com sucesso de " + contaOrigem.nome + " para " + contaDestino.nome);
        }
    }
//----------------------------------------------------------------
    static class GerenciadorContas {
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
    }
}
