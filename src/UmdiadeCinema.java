import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UmdiadeCinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de filmes e sessões
        Filme[] filmes = {
                new Filme("Nem Que a Vaca Tussa", "Will Finn",
                        "A fazenda Caminho do Paraíso está em pânico, pois uma ação de despejo ameaça acabar com o local. Temendo ir para o matadouro, os animais da fazenda decidem ajudar a dona a conseguir a quantia necessária para pagar a hipoteca. O alvo escolhido pelo grupo é o perigoso bandido Alameda Slim, que tem uma grande recompensa reservada para quem capturá-lo.",
                        "Aventura, Animação, Comédia, Família, Musical, Faroeste", 76, Arrays.asList("10:00", "14:00", "18:00")),

                new Filme("Matrix", "Lana Wachowski, Lilly Wachowski",
                        "Em um futuro próximo, Thomas Anderson (Keanu Reeves), um jovem programador de computador que mora em um cubículo escuro, é atormentado por estranhos pesadelos nos quais encontra-se conectado por cabos e contra sua vontade, em um imenso sistema de computadores do futuro. Em todas essas ocasiões, acorda gritando no exato momento em que os eletrodos estão para penetrar em seu cérebro. À medida que o sonho se repete, Anderson começa a ter dúvidas sobre a realidade. Por meio do encontro com os misteriosos Morpheus (Laurence Fishburne) e Trinity (Carrie-Anne Moss), Thomas descobre que é, assim como outras pessoas, vítima do Matrix, um sistema inteligente e artificial que manipula a mente das pessoas, criando a ilusão de um mundo real enquanto usa os cérebros e corpos dos indivíduos para produzir energia. Morpheus, entretanto, está convencido de que Thomas é Neo, o aguardado messias capaz de enfrentar o Matrix e conduzir as pessoas de volta à realidade e à liberdade.",
                        "Ação, Ficção científica", 136, Arrays.asList("11:00", "15:00", "19:00")),

                new Filme("A Nova Onda do Imperador", "Mark Dindal",
                        "Em um reino mítico e rodeado de montanhas, o jovem e arrogante Imperador Kuzco transformado em uma lhama por sua conselheira, a poderosa bruxa Yzma. Perdido na floresta, a única chance de Kuzco recuperar seu trono é contando com a ajuda de Pacha, um simplório camponês.",
                        "Aventura, Animação, Comédia", 78, Arrays.asList("12:00", "16:00", "20:00"))
        };

        // Sessões disponíveis
        String[] sessoes = {"11:00", "21:30", "23:30"};

        // Preço dos ingressos
        double precoInteiro = 32.00;
        double precoMeia = 16.00;

        // Exibir filmes
        System.out.println("Escolha um filme:");
        for (int i = 0; i < filmes.length; i++) {
            System.out.println((i + 1) + ". " + filmes[i].toString());
        }

        System.out.println("Informe o número do filme escolhido:");
        int filmeEscolhido = scanner.nextInt();
        scanner.nextLine(); // Consumir a linha de quebra de linha

        // Validar a escolha do filme
        if (filmeEscolhido < 1 || filmeEscolhido > filmes.length) {
            System.out.println("Opção inválida.");
            return;
        }

        // Exibir sessões do filme escolhido
        Filme filme = filmes[filmeEscolhido - 1];
        System.out.println("\nEscolha a sessão para o filme " + filme.getNome() + ":");
        for (int i = 0; i < filme.getSessoes().size(); i++) {
            System.out.println((i + 1) + ". " + filme.getSessoes().get(i));
        }

        System.out.print("Digite o número da sessão escolhida: ");
        int sessaoEscolhida = scanner.nextInt();

        // Validar a escolha da sessão
        if (sessaoEscolhida < 1 || sessaoEscolhida > filme.getSessoes().size()) {
            System.out.println("Opção inválida.");
            return;
        }

        // Solicitar quantidade de ingressos
        System.out.print("\nDigite a quantidade de ingressos inteiros + meia entrada: ");
        int ingressosInteiros = scanner.nextInt();
        int meiaentrada = scanner.nextInt();

        // Calcular total a pagar
        double total = (ingressosInteiros * precoInteiro + (meiaentrada * precoMeia));

        // Exibir resumo e total
        System.out.println("\nResumo da Compra:");
        System.out.println("Filme: " + filme.getNome());
        System.out.println("Sessão: " + filme.getSessoes().get(sessaoEscolhida - 1));
        System.out.println("Ingressos inteiros: " + ingressosInteiros);
        System.out.println("Ingressos meia entrada: " + meiaentrada);
        System.out.println("Total a pagar: R$ " + total);

        scanner.close();
    }
}
