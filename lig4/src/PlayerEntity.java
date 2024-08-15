public class PlayerEntity {
  private String name;
  private String gamePiece;

  public  PlayerEntity(String name, String gamePiece){
    this.name = name;
    this.gamePiece = gamePiece;
  }

  public String gamePiece(){
    return this.gamePiece;
  }

  public String getName(){
    return this.name;
  }
}
