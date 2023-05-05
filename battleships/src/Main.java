import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o nome do primeiro jogador!");
        Jogador jogador1 = new Jogador(input.next());
        //chama o método para preencher o tabuleiro, ou seja, adicionar armas S C P
        jogador1.preencheTabuleiro();
        //e chama o método para exibir o tabuleiro na tela já com as armas adicionadas
        jogador1.escreveTabuleiro();
        // e repete a mesma sequência de passos para o jogador 2
        System.out.println("Informe o nome do segundo jogador!");
        Jogador jogador2 = new Jogador(input.next());
        jogador2.preencheTabuleiro();
        jogador2.escreveTabuleiro();

        //criando um laço while pra repetir infinitimante. Pra o while parar de repetir ele precisa fazer duas verificações
        while (true) {
            System.out.println("Vez do jogador: " + jogador1.nome);
            //cada jogador da 2 tiros por vez
            jogador1.atirar(jogador2.tabuleiro);
            jogador1.atirar(jogador2.tabuleiro);

            System.out.println("Vez do jogador: " + jogador2.nome);
            jogador2.atirar(jogador1.tabuleiro);
            jogador2.atirar(jogador1.tabuleiro);

            //chama o metódo verificaTabuleiro para varrer cada elemento do tabuleiro para ver se existe alguma arma no tabuleiro do jogador 1
            //se não existir, mostra uma mensagem dizendo que o jogador 2 venceu e usa o break para encerrar o laço while
            if (!jogador1.verificaTabuleiro()) {
                System.out.println("Jogador " +jogador2.nome+ " venceu!");
                break;
            // e a verificação é feita da mesma forma para o jogador 2
            } else if(!jogador2.verificaTabuleiro()) {
                System.out.println("Jogador " + jogador1.nome + " venceu!");
                break;
            }
        }

    }
}