import java.util.ArrayList;
import java.util.List;

public class Table {
  private List<List<String>> matrix;

  public Table(){
    matrix = new ArrayList<List<String>>();
    this.matrix.add(new ArrayList<String>() );
    this.matrix.add(new ArrayList<String>() );
    this.matrix.add(new ArrayList<String>() );
    this.matrix.add(new ArrayList<String>() );
    this.matrix.add(new ArrayList<String>() );
    this.matrix.add(new ArrayList<String>() );

    for(List<String> row_m: this.matrix){
      for ( int i = 0; i <7; i++){ row_m.add("_") ;}

    }
  }


  public void play(Integer column, PlayerEntity player){
    String piece = player.gamePiece();
    // precisa colocar uma validação se ainda tem como colocar nessa coluna.
    List<String> befor_row = new ArrayList<>();
    var last_row = matrix.getLast();
    for (List<String> row: matrix){
      if (row == last_row && row.get(column).equals("_") ){
        row.set(column,piece );
        return;
      }
      if (!row.get(column).equals("_")){
        befor_row.set(column, piece);
        return;
      }
      befor_row = row;
    }

  }
  @Override
  public String toString() {
    for (List<String> row: matrix){
      StringBuilder rowString = new StringBuilder();
      for (String value: row){
        rowString.append(" | " + value +" |");
      }
      System.out.println("-".repeat(40));
      System.out.println(rowString);

    }
    System.out.println("=".repeat(40));
    return "";
  }
}

