import java.util.Scanner;

public class Jogo {
  private Integer columns;

  private String gamePiece;
  private String name;
  private Boolean winner = false;
  private Table table;
  Scanner scanner = new Scanner(System.in);

  PlayerEntity player1;
  PlayerEntity player2;

  public void match() {
    menu();

    table = new Table();
    int count = 0;
    PlayerEntity player = this.player1;
    while (!winner) {
      System.out.println(this.table);
      winner = round(player);

      if (count == 0) {
        player = player2;
        count++;
      } else {
        player = player1;
        count--;
      }
    }
    System.out.println(this.table);
    System.out.println("PARABENS AO VENCEDOR");
  }

  private void menu() {
    System.out.println("========= Bem Vindo =========");

    System.out.println("Digite o nome do jogador 1: ");
    this.name = scanner.next();
    do{
    System.out.println(this.name + ", escolha a peca que voce deseja jogar: ");
    this.gamePiece = scanner.next();
    }
    while (!validPiece(this.gamePiece));
    player1 = new PlayerEntity(name, gamePiece);


    System.out.println("Digite o nome do jogador 2: ");
    this.name = scanner.next();
    do {
    System.out.println(this.name + ", escolha a peca que voce deseja jogar: ");
    this.gamePiece = scanner.next();}
    while (!validPiece(this.gamePiece));
    player2 = new PlayerEntity(name, gamePiece);

  }
  private boolean validPiece(String piece){
    if(piece.equals("_")){
      System.out.println("hahaha, engraçadinho, outra -_-");
      return false;}
    return true;
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public Boolean round(PlayerEntity player) {
    clearScreen();

    do {
      System.out.println(player.getName() + " digite a coluna para jogar: ");
      try{
        this.columns = scanner.nextInt();
      }catch (Exception e)
      {
        System.out.println("Digite um numero valido.");
        columns = -1;
        this.scanner = new Scanner(System.in);
      }
    } while (!table.validaPlay(columns));

    return table.play(this.columns, player);
  }


}
