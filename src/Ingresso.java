public class Ingresso {
    private Filme filme; // Atributo privado para encapsulamento
    private String tipoIngresso; // Inteira ou Meia
    protected String sessao; // Acessível para subclasses
    protected int quantidade;

    public Ingresso(Filme filme, String tipoIngresso, String sessao, int quantidade) {
        if (filme != null && !filme.validarFilmeParaIngresso(this)) {
            throw new IllegalArgumentException("Filme inválido para o tipo de ingresso.");
        }
        this.filme = filme;
        this.tipoIngresso = tipoIngresso;
        this.sessao = sessao;
        this.quantidade = quantidade;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        if (filme != null && !filme.validarFilmeParaIngresso(this)) {
            System.out.println("Filme não permitido para este tipo de ingresso.");
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
        System.out.println("Quantidade: " + quantidade);
        System.out.printf("Total a pagar: R$ %.2f\n", total);
    }
}
