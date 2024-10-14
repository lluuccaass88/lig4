public class TesteTable {

  public static void main(String[] args){
    validaWinDiagonalDireitaUp();
    validaWinDiagonalEquerdaUp();
    validaWinHorizontal();
  }

  public static void validaWinDiagonalDireitaUp(){
    Table table = new Table();

    PlayerEntity p1 = new PlayerEntity("p1", "o") ;
    PlayerEntity p2 = new PlayerEntity("p2", "x") ;

    table.play(0, p1);
    table.play(1, p2);
    table.play(1, p1);
    table.play(2, p2);
    table.play(2, p2);
    table.play(2, p1);
    table.play(3, p1);
    table.play(3, p2);
    table.play(3, p2);
    Boolean win = table.play(3, p1);
    System.out.println("Teste Diagonal Direita: " + win);


  }

  public static void validaWinDiagonalEquerdaUp(){
    Table table = new Table();

    PlayerEntity p1 = new PlayerEntity("p1", "o") ;
    PlayerEntity p2 = new PlayerEntity("p2", "x") ;


    table.play(5, p1);
    table.play(4, p2);
    table.play(4, p1);
    table.play(3, p2);
    table.play(3, p2);
    table.play(3, p1);
    table.play(2, p1);
    table.play(2, p2);
    table.play(2, p2);
    Boolean win = table.play(2, p1);
    System.out.println("Teste Diagonal Esquerda: " + win);


  }

  public static void validaWinHorizontal(){
    Table table = new Table();

    PlayerEntity p1 = new PlayerEntity("p1", "o") ;
    PlayerEntity p2 = new PlayerEntity("p2", "x") ;
    //teste

    table.play(0, p1);
    table.play(1, p1);
    table.play(2, p1);
    Boolean win = table.play(3, p1);

    table.play(0, p2);
    table.play(1, p2);
    table.play(2, p2);

    Boolean winRowUp = table.play(3, p2);

    System.out.println("Teste Horizontal ultima linha: " + win +
                     "\nTeste Outras Linhas: " + winRowUp);
  }

}

//TODO: Fazer a jogada ir pro tabuleiro
//TODO: Validação pós jogada, para verificar se venceu - Regra para ver se venceu
// Pensar em um lógica de empate
// Criar um erro caso a pessoa queira colocar uma peça em uma coluna que já esta cheia