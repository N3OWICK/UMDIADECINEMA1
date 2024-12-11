public class IngressoVip extends Ingresso {
    public IngressoVip(Filme filme, String tipoIngresso, String sessao, int quantidade) {
        super(filme, tipoIngresso, sessao, quantidade);
    }

    @Override
    public double calcularTotal() {
        // Preço VIP é o dobro do ingresso comum
        return super.calcularTotal() * 2;
    }

    @Override
    public void acessoLanchonete() {
        System.out.println("Lanchonete do cinema liberada.");
    }

    @Override
    public void exibirResultado() {
        double total = calcularTotal();
        System.out.println("=== Resumo da Compra VIP ===");
        System.out.println("Filme: " + (getFilme() != null ? getFilme().getNome() : "Nenhum filme selecionado"));
        System.out.println("Sessão: " + sessao);
        System.out.println("Quantidade: " + quantidade);
        System.out.printf("Total a pagar: R$ %.2f\n", total);
    }
}
