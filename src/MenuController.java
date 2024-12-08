import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    private static final Filme[] filmes = new Filme[]{
            new Filme("Nem Que a Vaca Tussa", "Will Finn", "A fazenda Caminho do Paraíso está em pânico, pois uma ação de despejo ameaça acabar com o local. Temendo ir para o matadouro, os animais da fazenda decidem ajudar a dona a conseguir a quantia necessária para pagar a hipoteca. O alvo escolhido pelo grupo é o perigoso bandido Alameda Slim, que tem uma grande recompensa reservada para quem capturá-lo.",
                    "Aventura, Animação, Comédia, Família, Musical, Faroeste", 76, Arrays.asList("10:00", "14:00", "18:00")),
            new Filme("Matrix", "Lana Wachowski, Lilly Wachowski", "Em um futuro próximo, Thomas Anderson (Keanu Reeves), um jovem programador de computador que mora em um cubículo escuro, é atormentado por estranhos pesadelos...",
                    "Ação, Ficção científica", 136, Arrays.asList("11:00", "15:00", "19:00")),
            new Filme("A Nova Onda do Imperador", "Mark Dindal", "Em um reino mítico e rodeado de montanhas, o jovem e arrogante Imperador Kuzco transformado em uma lhama por sua conselheira, a poderosa bruxa Yzma...",
                    "Aventura, Animação, Comédia", 78, Arrays.asList("12:00", "16:00", "20:00"))
    };

    private Scanner scanner;

    public MenuController() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("=== Sistema de Compra de Ingressos ===");
        System.out.println("Escolha o filme:");
        for (int i = 0; i < filmes.length; i++) {
            System.out.println((i + 1) + ". " + filmes[i].getNome());
        }
    }

    public int selecionarFilme() {
        System.out.print("Digite o número do filme desejado: ");
        return scanner.nextInt() - 1; // Subtrai 1 para ajustar o índice
    }

    public String selecionarSessao(Filme filme) {
        System.out.println("Escolha uma sessão para o filme '" + filme.getNome() + "':");
        List<String> sessoes = filme.getSessoes();
        for (int i = 0; i < sessoes.size(); i++) {
            System.out.println((i + 1) + ". " + sessoes.get(i));
        }
        System.out.print("Digite o número da sessão desejada: ");
        int opcaoSessao = scanner.nextInt();
        return sessoes.get(opcaoSessao - 1); // Retorna a sessão escolhida
    }

    public String selecionarTipoIngresso() {
        System.out.println("Escolha o tipo de ingresso:");
        System.out.println("1. Inteira");
        System.out.println("2. Meia");
        System.out.print("Digite a opção desejada: ");
        int opcao = scanner.nextInt();
        return (opcao == 1) ? "inteira" : "meia";
    }

    public int selecionarQuantidadeIngressos() {
        System.out.print("Digite a quantidade de ingressos: ");
        return scanner.nextInt();
    }

    public boolean selecionarTipoIngressoVip() {
        System.out.println("Escolha o tipo de ingresso:");
        System.out.println("1. Comum");
        System.out.println("2. VIP");
        System.out.print("Digite a opção desejada: ");
        int opcao = scanner.nextInt();
        return opcao == 2; // Retorna true se for VIP
    }

    public void iniciarCompra() {
        exibirMenu();
        int indiceFilme = selecionarFilme();
        Filme filmeEscolhido = filmes[indiceFilme];
        String sessaoEscolhida = selecionarSessao(filmeEscolhido);
        boolean isVip = selecionarTipoIngressoVip();
        String tipoIngresso = selecionarTipoIngresso();
        int quantidade = selecionarQuantidadeIngressos();

        if (isVip) {
            IngressoVip ingressoVip = new IngressoVip(filmeEscolhido, tipoIngresso, sessaoEscolhida, quantidade);
            ingressoVip.exibirResultado();
        } else {
            Ingresso ingresso = new Ingresso(filmeEscolhido, tipoIngresso, sessaoEscolhida, quantidade);
            ingresso.exibirResultado();
        }
    }
}

