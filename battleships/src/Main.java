import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o nome do primeiro jogador!");
        Jogador jogador1 = new Jogador(input.next());
        jogador1.preencheTabuleiro();
        jogador1.escreveTabuleiro();
        System.out.println("Informe o nome do segundo jogador!");
        Jogador jogador2 = new Jogador(input.next());
        jogador2.preencheTabuleiro();
        jogador2.escreveTabuleiro();

        while (true) {
            System.out.println("Vez do jogador: " + jogador1.nome);
            jogador1.atirar(jogador2.tabuleiro);
            jogador1.atirar(jogador2.tabuleiro);

            System.out.println("Vez do jogador: " + jogador2.nome);
            jogador2.atirar(jogador1.tabuleiro);
            jogador2.atirar(jogador1.tabuleiro);

            if (!jogador1.verificaTabuleiro()) {
                System.out.println("Jogador " +jogador2.nome+ " venceu!");
                break;
            } else if(!jogador2.verificaTabuleiro()) {
                System.out.println("Jogador " + jogador1.nome + " venceu!");
                break;
            }
        }

    }
}