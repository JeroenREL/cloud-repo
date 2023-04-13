import java.util.Scanner;
import java.util.ArrayList;

import src.Library;
 
public class BowlingGame {
 
 public static void main(String[] args) {

  int i;

  Scanner in = new Scanner(System.in);
  
  System.out.println("Score input should be number between 0 and 9 or '/' for spare or 'X' for strike");

  ArrayList<Integer> scoreList = new ArrayList<>();

  for (i=1; i <= 10; i++) {
    //Input for each first turn for frame i is asked
    System.out.print("Input score for frame "+i+", turn 1: ");
    String stringFirstTurn = in.next();
    //Validation for score input and resulting actions are defined in method FirstTurnInputValidation from class Library
    int scoreFirstTurn = Library.FirstTurnInputValidation(stringFirstTurn);
    scoreList.add(scoreFirstTurn);
    if (Library.spareDoubleScoresActive == true || Library.strikeDoubleScoresActive == true) {
      scoreList.add(scoreFirstTurn);
    }
    //If no strike is thrown in first turn, then actions for the second turn are defined
    if (Library.secondTurnAllowed == true) {
      //Input for each second turn for frame i is asked
      System.out.print("Input score for frame "+i+", turn 2: ");
      String stringSecondTurn = in.next();
      //Validation for score input and resulting actions are defined in method SecondTurnInputValidation from class Library
      int scoreSecondTurn = Library.SecondTurnInputValidation(stringSecondTurn);
      scoreList.add(scoreSecondTurn);
      if (Library.strikeDoubleScoresActive == true) {
        scoreList.add(scoreSecondTurn);
      }
      Library.secondTurnAllowed = false;
    }

  }
   
	int sum = 0;
	for (int j = 0; j < scoreList.size(); j++) {
		sum += scoreList.get(j);
    }
  
  System.out.println("The total score is = " +sum);
 }
}