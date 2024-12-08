public class Ingresso {
    private Filme filme;
    private String tipoIngresso; // Inteira ou Meia
    private String sessao;
    private int quantidade;

    public Ingresso(Filme filme, String tipoIngresso, String sessao, int quantidade) {
        setFilme(filme); // Aplica a regra de filme comum aqui
        this.tipoIngresso = tipoIngresso;
        this.sessao = sessao;
        this.quantidade = quantidade;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        if (filme.isFilme3D()) {
            System.out.println("Ingressos comuns não podem ser vinculados a filmes 3D.");
        } else {
            this.filme = filme;
        }
    }

    public double calcularTotal() {
        double preco = tipoIngresso.equalsIgnoreCase("inteira") ? 24.0 : 12.0;
        return preco * quantidade;
    }

    public void acessoLanchonete() {
        System.out.println("Compre um ingresso VIP para acesso à lanchonete.");
    }

    public void exibirResultado() {
        double total = calcularTotal();
        System.out.println("=== Resumo da Compra ===");
        System.out.println("Filme: " + (filme != null ? filme.getNome() : "Nenhum filme selecionado"));
        System.out.println("Sessão: " + sessao);
        System.out.println("Tipo de ingresso: " + tipoIngresso);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Total a pagar: R$ " + total);
    }
}

