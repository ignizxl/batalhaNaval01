import java.util.Scanner;

public class Jogador {

    //Atributos da Classe Jogador
    private int tamanho = 8;
    String nome;


    //tabuleiro 8x8
    char[][] tabuleiro;

    public Jogador(String nome){
        this.nome = nome;
        //O atributo tabuleiro está recebendo um metódo especíco para criar o tabuleiro
        this.tabuleiro = criaTabuleiro();
    }

    // Adicionando armas (3 submarinos, 2 cruzadores e 1 porta avião)
    public void preencheTabuleiro() {
        Scanner input = new Scanner(System.in);
        // Adicionando três submarino
        System.out.println("Jogador " + this.nome + " preencha seu tabuleiro! ");
        for (int i = 0; i < 3; i++) {
            System.out.println("Informe a posição de um submarino: ");
            int x = input.nextInt();
            int y = input.nextInt();

            if (!this.insereNoTabuleiro(x, y, 'S')) {
                System.out.println("Cordenadas inválidas. Informe novamente! ");
                i--;
            }
        }
        // Adicionando dois cruzadores
        for (int i = 0; i < 2; i++) {
            System.out.println("Informe a posição de um cruzador: ");
            int x = input.nextInt();
            int y = input.nextInt();
            if (!this.insereNoTabuleiro(x, y, 'C')) {
                System.out.println("Cordenadas inválidas. Informe novamente! ");
                i--;
            }
        }
        // Adicionando um porta avião
        for (int i = 0; i < 1; i++) {
            System.out.println("Informe a posição de um porta avião ");
            int x = input.nextInt();
            int y = input.nextInt();
            if (!this.insereNoTabuleiro(x, y, 'P')) {
                System.out.println("Cordenadas inválidas. Informe novamente! ");
                i--;
            }
        }
    }

    //Verica se as cordenadas que foram passadas são válidas. Para uma cordenada ser válida ela não pode exceder os limites do meu tabuleiro (8x8)
    //e não posso adicionar armas nas mesma posições.
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

    //Metódo para atirar.
    //nesse metódo, cada jogador deverá passar as suas cordenadas que irão representar o lugar que ele deseja efutuar
    //o disparo.

    public void atirar(char[][] tabuleiroAdversario){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        //verifica se as cordenadas passadas acima apontam para um caractere 0 no tabuleiro, se for igual a 0, o tiro foi na água
        if (tabuleiroAdversario[x][y] == '0') {
            System.out.println("Tiro foi na água!");
        } else {
            System.out.println("Acertou algo!");
        }
        //'riscando' um 'X' no tabuleiro do adversário de acordo com as cordenadas que foram passadas logo acima
        tabuleiroAdversario[x][y] = 'X';
        this.escreveTabuleiroParaAdversario(tabuleiroAdversario);
    }

    //Metódo VerificaTabuleiro
    //Esse metódo é o metódo utilizado para dizer se existe alguma arma no tabuleiro.
    //Pra resumir, esse metódo vai 'varrer' cada elemento do tabuleiro e vai fazer a verificação se o elemento
    //do tabuleiro é diferente de 'X' e de '0', se for diferente, é sinal que ainda existe alguma(s) arma(s) para ser destruída


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

    //Metódo CriaTabuleiro
    //Criando o tabuleiro 8x8 e preenchendo cada posição com o caractere '0'.
    // OBS: A água do tabuleiro é representada por 0
    public char[][] criaTabuleiro(){
        char[][] array = new char[this.tamanho][this.tamanho];
        for (int i = 0; i < this.tamanho; i++) {
            for (int j = 0; j < this.tamanho; j++) {
                array[j][i] = '0';
            }
        }
        return array;
    }

    //Metódo EscreveTabuleiro
    //esse metódo vai exibir o tabuleiro na tela depois que os jogadores passaram suas cordenadas
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