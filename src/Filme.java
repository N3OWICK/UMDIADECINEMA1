import java.util.List;

public class Filme {
    private String nome;
    private String diretor;
    private String descricao;
    private String genero;
    private int duracao;
    private List<String> sessoes; // Sessões disponíveis para cada filme
    private boolean filme3D;

    // Construtor que inclui a informação sobre filme 3D
    public Filme(String nome, String diretor, String descricao, String genero, int duracao, List<String> sessoes, boolean filme3D) {
        this.nome = nome;
        this.diretor = diretor;
        this.descricao = descricao;
        this.genero = genero;
        this.duracao = duracao;
        this.sessoes = sessoes;
        this.filme3D = filme3D;
    }


    public Filme(String nome, String diretor, String descricao, String genero, int duracao, List<String> sessoes) {
        this(nome, diretor, descricao, genero, duracao, sessoes, false); // Define filme3D como falso por padrão
    }


    public boolean isFilme3D() {
        return filme3D;
    }

    public void setFilme3D(boolean filme3D) {
        this.filme3D = filme3D;
    }

    // Getters para outros atributos
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
                "Descrição: " + descricao + " \n" +
                "Gênero: " + genero + "\n" +
                "Duração: " + duracao + " minutos\n" +
                "Sessões: " + String.join(", ", sessoes) +
                (filme3D ? "\n[Filme 3D]" : "");
    }
}
