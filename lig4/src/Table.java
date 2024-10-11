import java.util.ArrayList;
import java.util.List;

public class Table {
  private List<List<String>> matrix;

  public Table() {
    matrix = new ArrayList<List<String>>();
    this.matrix.add(new ArrayList<String>());
    this.matrix.add(new ArrayList<String>());
    this.matrix.add(new ArrayList<String>());
    this.matrix.add(new ArrayList<String>());
    this.matrix.add(new ArrayList<String>());
    this.matrix.add(new ArrayList<String>());

    for (List<String> row_m : this.matrix) {
      for (int i = 0; i < 7; i++) {
        row_m.add("_");
      }

    }
  }

  public Boolean validaPlay(Integer column){
    var firstRow = matrix.get(0);
    if(column < 0 ){
      return false;
    }
    if(column > firstRow.size() -1 ) {
      return false;
    }
    if(!firstRow.get(column).equals("_")){
      return Boolean.FALSE;
    }
    return true;
  }
  public Boolean play(Integer column, PlayerEntity player) {
    String piece = player.gamePiece();
    List<String> beforRow = new ArrayList<>();

    var lastRow = matrix.get(5);


    for (List<String> row : matrix) {

      if (row == lastRow && row.get(column).equals("_")) { //valida se é a ultima linha e se a coluna esta vazia
        row.set(column, piece);
        return valideteWin(matrix.indexOf(row), column, piece);
      }
      if (!row.get(column).equals("_")) {
        beforRow.set(column, piece);
        return valideteWin(matrix.indexOf(beforRow), column, piece);
      }
      beforRow = row;
    }

    return null;
  }

  public Boolean valideteIlegalState(int row, int coluna, String piece) {
    try {
      return matrix.get(row).get(coluna).equals(piece);
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  public Boolean validateWinDiagonalLeftUpToRigthDown(Integer row, Integer column, String piece) {
    int countWin = 0;
    for (int left = 1, rigth = 1, up = 1, down = 1, count = 0; count != 3; count++) {
      if (valideteIlegalState(row - up, column - left, piece)) {
        countWin++;
        left++;
        up++;
      }
      if (valideteIlegalState(row + down, column + rigth, piece)) {
        countWin++;
        rigth++;
        down++;
      }
    }

    if (countWin >= 3) {
      return true;
    }
    return false;
  }

  public Boolean validateWinDiagonalRigthUpToLeftDown(Integer row, Integer column, String piece) {
    int countWin = 0;
    for (int left = 1, rigth = 1, up = 1, down = 1, count = 0; count != 3; count++) {
      if (valideteIlegalState(row + down, column - left, piece)) {
        countWin++;
        left++;
        down++;
      }
      if (valideteIlegalState(row - up, column + rigth, piece)) {
        countWin++;
        rigth++;
        up++;
      }
    }

    if (countWin >= 3) {
      return true;
    }
    return false;
  }

  public Boolean validateHorizontalWin(Integer row, Integer column, String piece) {
    int countWin = 0;
    for (int left = 1, rigth = 1, count = 0; count != 3; count++) {
      if (valideteIlegalState(row, column - left, piece)) {
        countWin++;
        left++;
      }
      if (valideteIlegalState(row, column + rigth, piece)) {
        countWin++;
        rigth++;
      }
    }

    if (countWin >= 3) {
      return true;
    }
    return false;
  }

  private Boolean validateVerticalWin(Integer row, Integer column, String piece) {

    for (int down = 1; down != 4; down++) {
      if (!valideteIlegalState(row + down, column, piece)) {
        return false;
      }
    }

    return true;
  }

  private Boolean valideteWin(Integer row, Integer column, String piece) {

    if (validateHorizontalWin(row, column, piece) || validateVerticalWin(row, column, piece) ||
            validateWinDiagonalRigthUpToLeftDown(row, column, piece) || validateWinDiagonalLeftUpToRigthDown(row, column, piece)) {
      return  true;
    }
    return false;
  }


  @Override
  public String toString() {
    for (List<String> row : matrix) {
      StringBuilder rowString = new StringBuilder();
      for (String value : row) {
        rowString.append(" | " + value + " |");
      }
      System.out.println("-".repeat(40));
      System.out.println(rowString);

    }
    System.out.println("=".repeat(40));
    return "";
  }
}

