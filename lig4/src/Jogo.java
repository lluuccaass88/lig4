import java.util.Scanner;

public class Jogo {
  private Integer columns;

  private String gamePiece;
  private String name;
  private Boolean winner = false;
  Scanner scanner = new Scanner(System.in);

  PlayerEntity player1;
  PlayerEntity player2;

  public void match(){
    menu();

    while(!winner){
      round();
    }
  }

    private void menu(){
    System.out.println("========= Bem Vindo =========");

    System.out.println("Digite o nome do jogador 1: ");
    this.name = scanner.next();
    System.out.println(this.name + ", escolha a peça que você deseja jogar: ");
    this.gamePiece = scanner.next();
    player1 = new PlayerEntity(name, gamePiece);

    System.out.println("Digite o nome do jogador 2: ");
    this.name = scanner.next();
    System.out.println(this.name + ", escolha a peça que você deseja jogar: ");
    this.gamePiece = scanner.next();
    player2 = new PlayerEntity(name, gamePiece);


  }

  public void round(){

    System.out.println("Digite a coluna: ");
    this.columns = scanner.nextInt();

    System.out.println(columns);

  }




}
