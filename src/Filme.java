import java.util.List;

public class Filme {
    private String nome;
    private String diretor;
    private String descricao;
    private String genero;
    private int duracao;
    private List<String> sessoes;  // Sessões disponíveis para cada filme

    public Filme(String nome, String diretor, String descricao, String genero, int duracao, List<String> sessoes) {
        this.nome = nome;
        this.diretor = diretor;
        this.descricao = descricao;
        this.genero = genero;
        this.duracao = duracao;
        this.sessoes = sessoes;
    }

    public String getNome() {
        return nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public List<String> getSessoes() {
        return sessoes;
    }

    // Método toString() para exibir todas as informações do filme
    @Override
    public String toString() {
        return nome + "\n" +
                "Diretor: " + diretor + "\n" +
                "Descrição: " + descricao + "\n" +
                "Gênero: " + genero + "\n" +
                "Duração: " + duracao + " minutos\n" +
                "Sessões: " + String.join(", ", sessoes);
    }
}
