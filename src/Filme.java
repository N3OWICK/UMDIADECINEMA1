import java.util.List;

public class Filme {
    private String nome;
    private String diretor;
    private String descricao;
    private String genero;
    private int duracao;
    private List<String> sessoes; // Sessões disponíveis
    private boolean filme3D;

    public Filme(String nome, String diretor, String descricao, String genero, int duracao, List<String> sessoes, boolean filme3D) {
        this.nome = nome;
        this.diretor = diretor;
        this.descricao = descricao;
        this.genero = genero;
        this.duracao = duracao;
        this.sessoes = sessoes;
        this.filme3D = filme3D;
    }

    public boolean isFilme3D() {
        return filme3D;
    }

    public void setFilme3D(boolean filme3D) {
        this.filme3D = filme3D;
    }
    public String getGenero() {
        return genero;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getDuracao() {
        return duracao;
    }
    public List<String> getSessoes() {
        return sessoes;
    }

    public boolean verificarSessaoDisponivel(String sessao) {
        return sessoes.contains(sessao);
    }

    public boolean validarFilmeParaIngresso(Ingresso ingresso) {
        if (ingresso instanceof IngressoVip) {
            // VIP pode aceitar qualquer filme
            return true;
        } else {
            // Ingressos comuns não aceitam filmes 3D
            return !isFilme3D();
        }
    }

    @Override
    public String toString() {
        return nome + "\n" +
                "Diretor: " + diretor + "\n" +
                "Descrição: " + descricao + "\n" +
                "Gênero: " + genero + "\n" +
                "Duração: " + duracao + " minutos\n" +
                "Sessões: " + String.join(", ", sessoes) +
                (filme3D ? "\n[Filme 3D]" : "");
    }
}
