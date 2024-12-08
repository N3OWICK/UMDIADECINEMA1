public class IngressoVip extends Ingresso {

    public IngressoVip(Filme filme, String tipoIngresso, String sessao, int quantidade) {
        super(filme, tipoIngresso, sessao, quantidade);
    }

    @Override
    public void setFilme(Filme filme) {
        // Ingressos VIP aceitam apenas filmes 3D
        if (!filme.isFilme3D()) {
            System.out.println("Ingressos VIPs só podem ser vinculados a filmes 3D.");
        } else {
            super.setFilme(filme);
        }
    }

    @Override
    public double calcularTotal() {
        double precoBase = super.calcularTotal();
        return precoBase * 2; // Preço dobrado para VIP
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
        System.out.println("Sessão: " + getFilme());
        System.out.println("Tipo de ingresso: VIP");
        System.out.println("Total a pagar: R$ " + total);
    }
}
