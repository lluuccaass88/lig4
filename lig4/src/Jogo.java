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

      winner = round(player);

      if (count == 0) {
        player = player2;
        count++;
      } else {
        player = player1;
        count--;
      }
    }
  }

  private void menu() {
    System.out.println("========= Bem Vindo =========");

    System.out.println("Digite o nome do jogador 1: ");
    this.name = scanner.next();
    System.out.println(this.name + ", escolha a pe�a que voc� deseja jogar: ");
    this.gamePiece = scanner.next();
    player1 = new PlayerEntity(name, gamePiece);

    System.out.println("Digite o nome do jogador 2: ");
    this.name = scanner.next();
    System.out.println(this.name + ", escolha a peça que você deseja jogar: ");
    this.gamePiece = scanner.next();
    player2 = new PlayerEntity(name, gamePiece);

  }

  public Boolean round(PlayerEntity player) {

    System.out.println("Digite a coluna: ");
    this.columns = scanner.nextInt();

    table.play(this.columns, player);

    return false;
  }


}
