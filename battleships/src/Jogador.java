import java.util.Scanner;

public class Jogador {
    private int tamanho = 8;
    String nome;
    char[][] tabuleiro;

    public Jogador(String nome){
        this.nome = nome;
        this.tabuleiro = criaTabuleiro();
    }

    public void preencheTabuleiro() {
        Scanner input = new Scanner(System.in);
        // Recebe três submarino
        System.out.println("Jogador " + this.nome + " preencha seu tabuleiro!");
        for (int i = 0; i < 3; i++) {
            System.out.println("Informe a posição de um submarino");
            int x = input.nextInt();
            int y = input.nextInt();

            if (!this.insereNoTabuleiro(x, y, 'S')) {
                System.out.println("Informe novamente!");
                i--;
            }
        }
        // Recebe dois cruzadores
        for (int i = 0; i < 2; i++) {
            System.out.println("Informe a posição de um cruzador");
            int x = input.nextInt();
            int y = input.nextInt();
            if (!this.insereNoTabuleiro(x, y, 'C')) {
                System.out.println("Informe novamente!");
                i--;
            }
        }
        // Recebe um porta avião
        for (int i = 0; i < 1; i++) {
            System.out.println("Informe a posição de um porta avião");
            int x = input.nextInt();
            int y = input.nextInt();
            if (!this.insereNoTabuleiro(x, y, 'P')) {
                System.out.println("Informe novamente!");
                i--;
            }
        }
    }

    public boolean insereNoTabuleiro(int x, int y, char valor) {
        if (x < 0 || x >= this.tamanho) {
            return false;
        }
        if (y < 0 || y >= this.tamanho) {
            return false;
        }
        if (this.tabuleiro[x][y] != '0') {
            return false;
        }
        this.tabuleiro[x][y] = valor;
        return true;
    }

    public void atirar(char[][] tabuleiroAdversario){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        if (tabuleiroAdversario[x][y] == '0') {
            System.out.println("Tiro foi na água!");
        } else {
            System.out.println("Acertou algo!");
        }
        tabuleiroAdversario[x][y] = 'X';
        this.escreveTabuleiroParaAdversario(tabuleiroAdversario);
    }

    public boolean verificaTabuleiro() {
        boolean resposta = false;
        for (int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < this.tamanho; j++) {
                if (this.tabuleiro[i][j] != 'X' && this.tabuleiro[i][j] != '0') {
                    resposta = true;
                    break;
                }
            }
        }
        return resposta;
    }

    public char[][] criaTabuleiro(){
        char[][] array = new char[this.tamanho][this.tamanho];
        for (int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < this.tamanho; j++) {
                array[i][j] = '0';
            }
        }
        return array;
    }

    public void escreveTabuleiro() {
        for (int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < this.tamanho; j++) {
                System.out.print(this.tabuleiro[i][j]);
            }
            System.out.println("");
        }
    }

    public void escreveTabuleiroParaAdversario(char[][] tabuleiro){
        System.out.print("  ");
        for (int i = 0; i < this.tamanho; i++) {
            System.out.print(" " + i );
        }
        System.out.println("");
        for (int i = 0; i < this.tamanho; i++) {
            System.out.printf(i+": ");
            for (int j = 0; j < this.tamanho; j++) {
                if (tabuleiro[i][j] != 'X'){
                    System.out.print("0 ");
                } else {
                    System.out.print("X ");
                }

            }
            System.out.println("");
        }
    }

}