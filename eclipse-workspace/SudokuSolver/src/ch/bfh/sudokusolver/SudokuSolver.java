package ch.bfh.sudokusolver;

public class SudokuSolver {
  
  private static final int UNASSIGNED = 0;
  
  private static final int ROWS = 9;
  private static final int COLS = 9;
  
  private int[][] _sudoku = new int[ROWS][COLS];
  
  //current unassigned field coordinates
  private int _row = 0;
  private int _col = 0;
  
  // initialize solver. Convert int array into two-dimensional array
  public SudokuSolver(int[] sudokuValues){
    int row = 0;
    
    for(int i = 0; i<ROWS; i++){
      for(int j=0; j<COLS; j++){
        _sudoku[i][j] = sudokuValues[row+j];
//        System.out.printf("%5d ", _sudoku[i][j]);
      } 
      row += 9;
//      System.out.println();
    }
  }
  
  public boolean solve(){
    
    // check for emtpy fields and store coordinates in _row and _col
    if(!hasEmptyField()){
      return true; // all fields successfully assigned
    }
    
    // for all possibilities try
    for (int num = 1; num <= 9; num++) {    // possible values = 0-9
      if (isValidChoice(_row, _col, num)) { // if num looks good
        _sudoku[_row][_col] = num;          // try assign num
        
        if (solve()) { return true; }       // try solving with this assert (reccursive)
        _sudoku[_row][_col] = UNASSIGNED;   // undo and try with other value
      }
    }
    
    return false; // returns false if not solvable
  }
  
  private boolean hasEmptyField(){
    
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        
        if(_sudoku[i][j] == 0){
          _row = i;
          _col = j;
          return true;
        }
      }
    }
    
    return false;
  }
  
  private boolean isValidChoice(int row, int col, int num){
//    boolean rowOK = true;
//    boolean colOK = true;
//    boolean squareOK = true;
    
    //check row
    for (int i = 0; i < COLS; i++) {
      if(_sudoku[row][i] == num){
        return false;
      }
    }
    
    //check col
    for (int i = 0; i < ROWS; i++) {
      if(_sudoku[i][col] == num){
        return false;
      }
    }
    
    //check square
    
    int diffRow = row%3;
    int diffCol = col%3;
    
    int sqrRow = row - diffRow;
    int sqrCol = col - diffCol;
    
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if(_sudoku[sqrRow+i][sqrCol+j] == num){
          return false;
        }
      }
    }
    
    return false;
  }
  
  public String getString(){
    return "";    
  }
  
}