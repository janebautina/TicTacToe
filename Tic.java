import java.util.ArrayList;
import java.util.Set;

public class Tic
{
   protected char[] board;
   protected char userMarker;
   protected char computerMarker;
   protected char winner;
   protected char currentMarker;

   public Tic(char playerToken, char computerToken)
   {
      this.userMarker = playerToken;
      this.computerMarker = computerToken;
      this.winner = '-';
      this.board = setBoard();
   }

   public void myPlayer(int i)
   {
      if (i == 0)
         currentMarker = userMarker;
      else
         currentMarker = computerMarker;
   }

   public void setPlayer()
   {
      int randomNumber = (int) Math.random() * 2;
      if (randomNumber == 0)
         currentMarker = userMarker;
      else
         currentMarker = computerMarker;
   }

   public int randomSpotSet(Set<Integer> st)
   {
      ArrayList<Integer> list = new ArrayList<Integer>();
      for (int i = 0; i < board.length; i++)
      {
         if (!st.contains(i + 1))
         {
            list.add(i + 1);
         }
      }
      return randomSpot(list.toArray(new Integer[list.size()]));
   }

   public int randomSpot(Object[] a)
   {
      int size = a.length;
      int index = (int) Math.random() * (size - 1);
      return (int) a[index];
   }

   private char[] setBoard()
   {
      char[] board = new char[9];
      for (int i = 0; i < board.length; i++)
      {
         board[i] = '-';
      }
      return board;
   }

   public boolean playTurn(int spot)
   {
      boolean isValid = withinRange(spot) && !isSpotTaken(spot);
      if (isValid)
      {
         board[spot - 1] = currentMarker;
         currentMarker = (currentMarker == userMarker) ? computerMarker
               : userMarker;
      }
      return isValid;
   }

   public char getBoardChar(int spot)
   {
      return board[spot - 1];
   }

   public char getCurrent()
   {
      return this.currentMarker;
   }

   private boolean withinRange(int spot)
   {
      return spot > 0 && spot < board.length + 1;
   }

   public boolean isSpotTaken(int number)
   {
      return board[number - 1] != '-';
   }

   public void printBoard()
   {
      System.out.println();
      for (int i = 0; i < board.length; i++)
      {
         if ((i % 3 == 0) && (i != 0))
         {
            System.out.println();
            System.out.println("--------------");
         }
         System.out.print(" | " + board[i]);
      }
      System.out.println();
   }

   public void printIndexBoard()
   {
      System.out.println();
      for (int i = 0; i < board.length; i++)
      {
         if ((i % 3 == 0) && (i != 0))
         {
            System.out.println();
            System.out.println("--------------");
         }
         System.out.print(" | " + (i + 1));
      }
      System.out.println();
   }

   public boolean isThereAWinner()
   {
      return (rightDi() || leftDi() || middleRow() || firstRow() || thirdRow()
            || secondCol() || firstCol() || thirdCol() && board[4] != '-');
   }

   private boolean rightDi()
   {
      return (board[0] == board[4] && board[4] == board[8]);
   }

   private boolean leftDi()
   {
      return (board[2] == board[4] && board[4] == board[7]);
   }

   private boolean middleRow()
   {
      return (board[3] == board[4] && board[4] == board[5]);
   }

   private boolean secondCol()
   {
      return (board[1] == board[4] && board[4] == board[8]);
   }

   private boolean firstCol()
   {
      return (board[0] == board[3] && board[3] == board[6]);
   }

   private boolean thirdCol()
   {
      return (board[2] == board[5] && board[5] == board[8]);
   }

   private boolean firstRow()
   {
      return (board[0] == board[1] && board[1] == board[2]);
   }

   private boolean thirdRow()
   {
      return (board[6] == board[7] && board[7] == board[8]);
   }

   public boolean isBoardFull()
   {
      for (int i = 0; i < board.length; i++)
         if (board[i] == '-')
            return false;
      return true;
   }
}
