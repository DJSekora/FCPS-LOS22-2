public class MinimaxExample
{
  public static int X_LOSS = 0;
  public static int TIE = 1;
  public static int X_WIN = 2;
  public static int NO_RESULT_YET = -1;
  
  public static int BOARD_SIZE = 3;
  
  public static char X_SYMBOL = 'x';
  public static char O_SYMBOL = 'x';
  public static char EMPTY_SYMBOL = 0;
  
  public int gameResult(char[][] boardState)
  {
    // TODO: Write code in here to check if the current board state is a win, loss, or tie
    
  
    return NO_RESULT_YET; // don't remove this
  }
  
  /* Returns an array containing the x and y coordinates of the move
   */
  public int[] minimax(char[][] boardState)
  {
    int bestResult = -1;
    int bestX = -1;
    int bestY = -1;
    
    int tempResult;
    
    for(int x = 0; x < BOARD_SIZE; x++)
    {
      for(int y = 0; y < BOARD_SIZE; y++)
      {
        if(boardState[x][y] == EMPTY_SYMBOL)
        {
          boardState[x][y] = X_SYMBOL;
          
          tempResult = evaluateBoard(boardState, O_SYMBOL);
          if(tempResult > bestResult)
          {
            bestResult = tempResult;
            bestX = x;
            bestY = y;
          }
          
          boardState[x][y] = EMPTY_SYMBOL;
        }
      }
    }
    
    return new int[]{bestX, bestY};
  }
  
  /* Returns the result the game will have if both players play perfectly from
     this point onwards.
     Possible return values: X_LOSS, Y_LOSS, TIE  (see top of file for definitions)*/
  public int evaluateBoard(char[][] boardState, char turn)
  {
    int result = gameResult(boardState);
    int temp;
    if(result == NO_RESULT_YET)
    {
      // for each slot on the board
      for(int x = 0; x < BOARD_SIZE; x++)
      {
        for(int y = 0; y < BOARD_SIZE; y++)
        {
          // If this square is empty, try moving there
          if(boardState[x][y] == EMPTY_SYMBOL)
          {
            boardState[x][y] = turn;
            if(turn == X_SYMBOL)
            {
              temp = evaluateBoard(boardState, O_SYMBOL);
              if(temp > result) // if we found a better move
              {
                result = temp;
              }
            }
            else
            {
              temp = evaluateBoard(boardState, X_SYMBOL);
              if(result < 0 || temp < result) // opponent is minimizing, so we check < not >
              {
                result = temp;
              }
            }
            // reset board state to initial posiiton 
            boardState[x][y] = EMPTY_SYMBOL;
          }
        }
      }
    }
    return result;
  }
}
