import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class UmdiadeCinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de filmes (alguns com suporte a 3D)
        Filme[] filmes = {
                new Filme("Nem Que a Vaca Tussa", "Will Finn",
                        "A fazenda Caminho do Paraíso está em pânico, pois uma ação de despejo ameaça acabar com o local...",
                        "Aventura, Animação, Comédia", 76, Arrays.asList("10:00", "14:00", "18:00"), false),

                new Filme("Matrix", "Lana Wachowski, Lilly Wachowski",
                        "Em um futuro próximo, Thomas Anderson (Keanu Reeves), um jovem programador...",
                        "Ação, Ficção científica", 136, Arrays.asList("11:00", "15:00", "19:00"), true),

                new Filme("A Nova Onda do Imperador", "Mark Dindal",
                        "Em um reino mítico e rodeado de montanhas, o jovem e arrogante Imperador Kuzco...",
                        "Aventura, Animação, Comédia", 78, Arrays.asList("12:00", "16:00", "20:00"), false)
        };

        // Preços dos ingressos
        double precoInteiroComum = 32.00;
        double precoMeiaComum = 16.00;
        double precoInteiroVip = 48.00; // Dobro do comum
        double precoMeiaVip = 24.00;    // Dobro do comum

        // Exibir filmes disponíveis com descrição e tempo
        System.out.println("Escolha um filme:");
        for (int i = 0; i < filmes.length; i++) {
            Filme filme = filmes[i];
            System.out.printf("%d. %s (Duração: %d minutos)\n   Descrição: %s\n%s\n",
                    (i + 1),
                    filme.getNome(),
                    filme.getDuracao(),
                    filme.getDescricao(),
                    filme.isFilme3D() ? "   [3D]" : "");
        }

        System.out.print("\nDigite o número do filme escolhido: ");
        int filmeEscolhido = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha

        // Validação da escolha do filme
        if (filmeEscolhido < 1 || filmeEscolhido > filmes.length) {
            System.out.println("Opção inválida.");
            return;
        }

        Filme filme = filmes[filmeEscolhido - 1];

        // Exibir sessões disponíveis
        System.out.println("\nEscolha uma sessão para o filme '" + filme.getNome() + "':");
        for (int i = 0; i < filme.getSessoes().size(); i++) {
            System.out.println((i + 1) + ". " + filme.getSessoes().get(i));
        }

        System.out.print("Digite o número da sessão escolhida: ");
        int sessaoEscolhida = scanner.nextInt();

        // Validação da escolha da sessão
        if (sessaoEscolhida < 1 || sessaoEscolhida > filme.getSessoes().size()) {
            System.out.println("Opção inválida.");
            return;
        }

        String sessao = filme.getSessoes().get(sessaoEscolhida - 1);

        // Escolher tipo de ingresso
        System.out.println("\nEscolha o tipo de ingresso:");
        System.out.println("1. Comum");
        System.out.println("2. VIP");
        System.out.print("Digite a opção desejada: ");
        int tipoIngresso = scanner.nextInt();

        if (tipoIngresso < 1 || tipoIngresso > 2) {
            System.out.println("Opção inválida.");
            return;
        }

        System.out.print("\nDigite a quantidade de ingressos inteiros: ");
        int ingressosInteiros = scanner.nextInt();
        System.out.print("Digite a quantidade de ingressos meia entrada: ");
        int meiaEntrada = scanner.nextInt();

        // Calcular o valor total
        double total = 0;
        if (tipoIngresso == 1) { // Comum
            if (filme.isFilme3D()) {
                System.out.println("Ingressos comuns não podem ser comprados para filmes 3D. Escolha um VIP.");
                return;
            }
            total = (ingressosInteiros * precoInteiroComum) + (meiaEntrada * precoMeiaComum);
        } else { // VIP
            total = (ingressosInteiros * precoInteiroVip) + (meiaEntrada * precoMeiaVip);
        }

        // Exibir resumo e total
        System.out.println("\nResumo da Compra:");
        System.out.println("Filme: " + filme.getNome());
        System.out.println("Sessão: " + sessao);
        System.out.println("Tipo de ingresso: " + (tipoIngresso == 1 ? "Comum" : "VIP"));
        System.out.println("Ingressos inteiros: " + ingressosInteiros);
        System.out.println("Ingressos meia entrada: " + meiaEntrada);
        System.out.printf("Total a pagar: R$ %.2f\n", total);

        // Mensagem sobre a lanchonete
        if (tipoIngresso == 2 || filme.isFilme3D()) {
            System.out.println("Lanchonete do cinema liberada.");
        }

        scanner.close();
    }
}
