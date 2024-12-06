public class Ingresso {
    private Filme filme;
    private String tipoIngresso; // Inteira ou Meia
    private String sessao;
    private int quantidade;

    public Ingresso(Filme filme, String tipoIngresso, String sessao, int quantidade) {
        this.filme = filme;
        this.tipoIngresso = tipoIngresso;
        this.sessao = sessao;
        this.quantidade = quantidade;
    }

    public double calcularTotal() {
        double preco = tipoIngresso.equals("inteira") ? 24.0 : 12.0;
        return preco * quantidade;
    }

    public void exibirResultado() {
        double total = calcularTotal();
        System.out.println("=== Resumo da Compra ===");
        System.out.println("Filme: " + filme.getNome());
        System.out.println("Sessão: " + sessao);
        System.out.println("Tipo de ingresso: " + tipoIngresso);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Total a pagar: R$ " + total);
    }
}
