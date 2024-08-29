public class TesteTable {

  public static void main2(String[] args){
    var table = new Table();

    PlayerEntity p1 = new PlayerEntity("p1", "o") ;
    PlayerEntity p2 = new PlayerEntity("p2", "x") ;
    //teste
    table.play(0, p1);

    System.out.println(table);

    table.play(0, p2);
    System.out.println(table);
    table.play(0, p1);
    System.out.println(table);
    table.play(0, p2);
    table.play(0, p1);
    table.play(0, p2);
    table.play(1, p1);
    table.play(2, p1);
    table.play(3, p1);
    table.play(1, p2);
    System.out.println(table);

  }

  public static void main(String[] args){
    var table = new Table();

    PlayerEntity p1 = new PlayerEntity("p1", "o") ;
    PlayerEntity p2 = new PlayerEntity("p2", "x") ;
    //teste
    table.play(0, p1);
    table.play(1, p1);
    table.play(2, p1);
    table.play(3, p1);
    table.play(4, p1);


    System.out.println(table.validateHorizontalWin(5, 2, "o"));


  }


}

//TODO: Fazer a jogada ir pro tabuleiro
//TODO: Validação pós jogada, para verificar se venceu - Regra para ver se venceu
// Pensar em um lógica de empate
// Criar um erro caso a pessoa queira colocar uma peça em uma coluna que já esta cheia