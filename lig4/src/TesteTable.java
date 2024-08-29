public class TesteTable {

  public static void main(String[] args){
    var table = new Table();

    PlayerEntity p1 = new PlayerEntity("p1", "o") ;
    PlayerEntity p2 = new PlayerEntity("p2", "x") ;

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
    System.out.println(table);

  }


}
