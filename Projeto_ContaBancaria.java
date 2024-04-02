
class ContaBancaria {
    String nome;
    double saldo;
    String tipoConta;

    public ContaBancaria(String nome, double saldo, String tipoConta) {
        this.nome = nome;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
    }
    // Função para depositar um valor em uma conta bancária, com atualização do rendimento se for uma conta poupança
    public void depositarValor(double valor) {
        saldo += valor;
        if (tipoConta.equals("poupança")) {
            aplicarRendimento();
        }
        System.out.println("Valor depositado com sucesso. Novo saldo: " + saldo);
    }
    // Função para sacar um valor de uma conta bancária
    public void sacarValor(double valor) {
        if (saldo < valor) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            System.out.println("Valor sacado com sucesso. Novo saldo: " + saldo);
        }
    }
    // Função para transferir um valor para outra conta bancária
    public void transferirValor(ContaBancaria destino, double valor) {
        if (saldo < valor) {
            System.out.println("Saldo insuficiente para transferência.");
        } else {
            saldo -= valor;
            destino.depositarValor(valor);
            System.out.println("Transferência realizada com sucesso.");
        }
    }
    // Função privada para aplicar o rendimento de poupança
    private void aplicarRendimento() {
        saldo *= 1.0675;
    }
}
