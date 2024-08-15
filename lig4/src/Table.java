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
      for ( int i = 0; i <6; i++){ row_m.add("_") ;}

    }
  }


  public void play(Integer column, String tipo){
    List<String> befor_row = new ArrayList<>();
    for (List<String> row: matrix){
      if (!row.get(column).equals("_")){
        befor_row.set(column, tipo); // <- tem alguma coisa que talvez esteja errada aqui
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
    return "";
  }
}

