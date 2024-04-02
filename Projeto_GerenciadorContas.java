class GerenciadorContas {
    private ContaBancaria[] contas;
    private int tamanhoAtual;

    public GerenciadorContas(int tamanho) {
        contas = new ContaBancaria[tamanho];
        tamanhoAtual = 0;
    }
    // Função para adicionar uma conta bancária ao gerenciador
    public void adicionarConta(ContaBancaria conta) {
        contas[tamanhoAtual] = conta;
        tamanhoAtual++;
    }
    // Função para depositar um valor em uma conta bancária específica
    public void depositarValor(int indice, double valor) {
        if (indice < 0 || indice >= tamanhoAtual) {
            System.out.println("Conta inválida.");
            return;
        }
        contas[indice].depositarValor(valor);
    }
    // Função para sacar um valor de uma conta bancária específica
    public void sacarValor(int indice, double valor) {
        if (indice < 0 || indice >= tamanhoAtual) {
            System.out.println("Conta inválida.");
            return;
        }
        contas[indice].sacarValor(valor);
    }
    // Função para transferir um valor entre duas contas bancárias
    public void transferirValor(int origem, int destino, double valor) {
        if (origem < 0 || origem >= tamanhoAtual || destino < 0 || destino >= tamanhoAtual) {
            System.out.println("Conta de origem ou destino inválida.");
            return;
        }
        contas[origem].transferirValor(contas[destino], valor);
    }
}
