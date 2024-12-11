import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    private static final Filme[] filmes = new Filme[]{
            new Filme("Nem Que a Vaca Tussa", "Will Finn", "A fazenda Caminho do Paraíso está em pânico...",
                    "Aventura, Animação, Comédia, Família, Musical, Faroeste", 76, Arrays.asList("10:00", "14:00", "18:00"), false),
            new Filme("Matrix", "Lana Wachowski, Lilly Wachowski", "Em um futuro próximo, Thomas Anderson...",
                    "Ação, Ficção científica", 136, Arrays.asList("11:00", "15:00", "19:00"), true), // Filme 3D
            new Filme("A Nova Onda do Imperador", "Mark Dindal", "Em um reino mítico, o jovem e arrogante Imperador Kuzco...",
                    "Aventura, Animação, Comédia", 78, Arrays.asList("12:00", "16:00", "20:00"), false)
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
        while (true) {
            try {
                System.out.print("Digite o número do filme desejado: ");
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao >= 1 && opcao <= filmes.length) {
                    return opcao - 1;
                }
                System.out.println("Opção inválida! Tente novamente.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }

    public String selecionarSessao(Filme filme) {
        List<String> sessoes = filme.getSessoes();
        while (true) {
            try {
                System.out.println("Escolha uma sessão para o filme '" + filme.getNome() + "':");
                for (int i = 0; i < sessoes.size(); i++) {
                    System.out.println((i + 1) + ". " + sessoes.get(i));
                }
                System.out.print("Digite o número da sessão desejada: ");
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao >= 1 && opcao <= sessoes.size()) {
                    return sessoes.get(opcao - 1);
                }
                System.out.println("Opção inválida! Tente novamente.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }

    public String selecionarTipoIngresso() {
        while (true) {
            try {
                System.out.println("Escolha o tipo de ingresso:");
                System.out.println("1. Inteira");
                System.out.println("2. Meia");
                System.out.print("Digite a opção desejada: ");
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao == 1 || opcao == 2) {
                    return (opcao == 1) ? "inteira" : "meia";
                }
                System.out.println("Opção inválida! Tente novamente.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }

    public int selecionarQuantidadeIngressos() {
        while (true) {
            try {
                System.out.print("Digite a quantidade de ingressos: ");
                int quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade > 0) {
                    return quantidade;
                }
                System.out.println("A quantidade deve ser maior que zero.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }

    public boolean selecionarTipoIngressoVip() {
        while (true) {
            try {
                System.out.println("Escolha o tipo de ingresso:");
                System.out.println("1. Comum");
                System.out.println("2. VIP");
                System.out.print("Digite a opção desejada: ");
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao == 1 || opcao == 2) {
                    return opcao == 2;
                }
                System.out.println("Opção inválida! Tente novamente.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
            }
        }
    }

    public void iniciarCompra() {
        boolean continuar = true;
        while (continuar) {
            exibirMenu();
            int indiceFilme = selecionarFilme();
            Filme filmeEscolhido = filmes[indiceFilme];
            String sessaoEscolhida = selecionarSessao(filmeEscolhido);
            boolean isVip = selecionarTipoIngressoVip();
            String tipoIngresso = selecionarTipoIngresso();
            int quantidade = selecionarQuantidadeIngressos();

            Ingresso ingresso;
            if (isVip) {
                ingresso = new IngressoVip(filmeEscolhido, tipoIngresso, sessaoEscolhida, quantidade);
            } else {
                ingresso = new Ingresso(filmeEscolhido, tipoIngresso, sessaoEscolhida, quantidade);
            }

            ingresso.exibirResultado();

            System.out.println("Deseja realizar outra compra? (1. Sim / 2. Não)");
            int opcao = Integer.parseInt(scanner.nextLine());
            continuar = (opcao == 1);
        }
        System.out.println("Obrigado por usar o sistema de compra de ingressos!");
        scanner.close();
    }
}
