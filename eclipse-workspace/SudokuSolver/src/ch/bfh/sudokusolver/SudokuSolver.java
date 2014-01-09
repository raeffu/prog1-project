package ch.bfh.sudokusolver;

public class SudokuSolver {
  
  private static final int UNASSIGNED = 0;
  
  private static final int ROWS = 9;
  private static final int COLS = 9;
  
  private int[][] _sudoku = new int[ROWS][COLS];
  
  // initialize solver. Convert int array into two-dimensional array
  public SudokuSolver(int[] sudokuValues){
    int offset = 0;
    
    for(int i = 0; i<ROWS; i++){
      for(int j=0; j<COLS; j++){
        _sudoku[i][j] = sudokuValues[offset+j];
        System.out.printf("%5d ", _sudoku[i][j]);
      } 
      offset += 9;
      System.out.println();
    }
  }
  
  public boolean solve(){
    
    //current unassigned field position
    int row = 0;
    int col = 0;
    
    // check for emtpy fields and store coordinates in row and col
    if(findEmptyField()){
      int[] pos = setPosition();
      row = pos[0];
      col = pos[1];
    }
    else {
      return true; // all fields successfully assigned
    }
    
    // for all possibilities try
    for (int num = 1; num <= 9; num++) {
      if (isValidChoice(row, col, num)) { // if num looks good
        _sudoku[row][col] = num;          // try assign num
        
        if (solve()){
          return true;                    // try solving with this assert (reccursive)
        }
        _sudoku[row][col] = UNASSIGNED;   // undo and try with other value
      }
    }
    return false; // returns false if not solvable
  }
  
  private boolean findEmptyField(){
    
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        
        if(_sudoku[i][j] == UNASSIGNED){
          return true;
        }
      }
    }
    
    return false;
  }
  
  private int[] setPosition() {
    int[] pos = new int[2];
    
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        
        if(_sudoku[i][j] == UNASSIGNED){
          pos[0] = i;
          pos[1] = j;
        }
      }
    }
    return pos;
  }
  
  private boolean isValidChoice(int row, int col, int num){
    
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
    
    return true;
  }
  
  public String getString(){
    String result = " ";
    
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        if(i==0 && j==0) result += _sudoku[i][j];
        else result += "," + _sudoku[i][j];
      }
      result += System.getProperty("line.separator");
    }
    return result;    
  }
  
}
