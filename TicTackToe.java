import java.util.HashSet;
import java.util.Set;

public class TicTackToe
{
   public static void main(String[] args)
   {
      Tic t = new Tic('0', 'X');
      Set<Integer> st = new HashSet<Integer>();
      t.printBoard();
      t.setPlayer();
      t.playTurn(5);
      st.add(5);
      t.printBoard();
      int lastSpot1 = 5;
      int lastSpot2 = t.randomSpot(new Integer[]
      { 1, 3, 7, 9 });
      t.playTurn(lastSpot2);
      t.printBoard();
      st.add(lastSpot2);
      st.add(2);
      st.add(4);
      st.add(6);
      st.add(8);
      switch (lastSpot2)
      {
      case 1:
         st.add(9);
         break;
      case 3:
         st.add(7);
         break;
      case 7:
         st.add(3);
         break;
      case 9:
         st.add(1);
         break;
      }
      lastSpot1 = t.randomSpotSet(st);
      st.add(lastSpot1);
      t.playTurn(lastSpot1);
      t.printBoard();
      switch (lastSpot1)
      {
      case 1:
         lastSpot2 = 9;
         break;
      case 3:
         lastSpot2 = 7;
         break;
      case 7:
         lastSpot2 = 3;
         break;
      case 9:
         lastSpot2 = 1;
         break;
      }
      t.playTurn(lastSpot2);
      st.add(lastSpot2);
      t.printBoard();
      if ((lastSpot2 == 1 && t.getBoardChar(3) != t.getCurrent() && t
            .getBoardChar(3) != '-')
            || (lastSpot2 == 3 && t.getBoardChar(1) != t.getCurrent() && t
                  .getBoardChar(1) != '-'))
         lastSpot1 = 2;
      else if ((lastSpot2 == 3 && t.getBoardChar(9) != t.getCurrent() && t
            .getBoardChar(9) != '-')
            || (lastSpot2 == 9 && t.getBoardChar(3) != t.getCurrent() && t
                  .getBoardChar(3) != '-'))
         lastSpot1 = 6;
      else if ((lastSpot2 == 7 && t.getBoardChar(9) != t.getCurrent() && t
            .getBoardChar(9) != '-')
            || (lastSpot2 == 9 && t.getBoardChar(7) != t.getCurrent() && t
                  .getBoardChar(7) != '-'))
         lastSpot1 = 8;
      else if ((lastSpot2 == 1 && t.getBoardChar(7) != t.getCurrent() && t
            .getBoardChar(7) != '-')
            || (lastSpot2 == 7 && t.getBoardChar(1) != t.getCurrent() && t
                  .getBoardChar(1) != '-'))
         lastSpot1 = 4;
      t.playTurn(lastSpot1);
      t.printBoard();
      st.add(lastSpot1);
      switch (lastSpot1)
      {
      case 2:
         lastSpot2 = 8;
         break;
      case 4:
         lastSpot2 = 6;
         break;
      case 6:
         lastSpot2 = 4;
         break;
      case 8:
         lastSpot2 = 3;
         break;
      }
      t.playTurn(lastSpot2);
      t.printBoard();
      st.add(lastSpot2);
      if (t.getBoardChar(2) == '-' && t.getBoardChar(8) == '-')
      {
         if (t.getBoardChar(1) == '-' || t.getBoardChar(3) == '-')
         {
            lastSpot1 = 2;
            lastSpot2 = 8;
         } else if (t.getBoardChar(7) == '-' || t.getBoardChar(9) == '-')
         {
            lastSpot1 = 8;
            lastSpot2 = 2;
         }
      } else if (t.getBoardChar(4) == '-' && t.getBoardChar(6) == '-')
      {
         if (t.getBoardChar(1) == '-' || t.getBoardChar(7) == '-')
         {
            lastSpot1 = 4;
            lastSpot2 = 6;
         } else if (t.getBoardChar(3) == '-' || t.getBoardChar(9) == '-')
            lastSpot1 = 6;
         lastSpot2 = 4;
      }
      t.playTurn(lastSpot1);
      t.printBoard();
      st.add(lastSpot2);
      t.playTurn(lastSpot2);
      t.printBoard();
      st.add(lastSpot2);
      for (int i = 1; i <= 9; i++)
      {
         if (t.getBoardChar(i) == '-')
            lastSpot1 = i;
      }
      t.playTurn(lastSpot1);
      t.printBoard();
      st.add(lastSpot1);
   }
}
