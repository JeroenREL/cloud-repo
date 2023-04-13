package src;

import java.util.ArrayList;

public class Library {    
    //In this class methods are defined to support the BowlingGame.java code
   
    public static boolean secondTurnAllowed = false;
    public static boolean spareDoubleScoresActive = false;
    public static boolean strikeDoubleScoresActive = false;

    public static int FirstTurnInputValidation(String InputString) {
        int resultForFirstTurn = 0;
        if (InputString.equals("0") || InputString.equals("1") || InputString.equals("2") || InputString.equals("3") || InputString.equals("4") || InputString.equals("5") || InputString.equals("6") || InputString.equals("7") || InputString.equals("8") || InputString.equals("9")) {
            resultForFirstTurn = FirstTurnNoStrikeActions(InputString);
            secondTurnAllowed = true;
          }
          else {
            if (InputString.equals("X")){
                resultForFirstTurn = StrikeActions(InputString);
            }
            else {
                System.out.println("Error: invalid input");
                }    
            }
            return resultForFirstTurn;
    }
    
    public static int FirstTurnNoStrikeActions(String InputString) {
        int number = 0;
        // Convert InputString to integer
        number = Integer.valueOf(InputString);
        return number;
    }

    public static int SecondTurnInputValidation(String InputString) {
        int resultForTurn = 0;
        if (InputString.equals("0") || InputString.equals("1") || InputString.equals("2") || InputString.equals("3") || InputString.equals("4") || InputString.equals("5") || InputString.equals("6") || InputString.equals("7") || InputString.equals("8") || InputString.equals("9")) {
            resultForTurn = SecondTurnNoSpareActions(InputString);
            spareDoubleScoresActive = false;
          }
          else {
            if (InputString.equals("/")){
                resultForTurn = SpareActions(InputString);
                //add double score for next turn
                }
                else {
                    System.out.println("Error: invalid input");
                }
            }
            return resultForTurn;
    }

    public static int SecondTurnNoSpareActions(String InputString) {
        int number = 0;
        // Convert InputString to integer
        number = Integer.valueOf(InputString);
        return number;
    }

    public static int SpareActions(String InputString) {
        int number = 0;
        //if input was spare, convert InputString "/" to integer 10
        number = 10;
        //count score for next turn double
        spareDoubleScoresActive = true;
        return number;        
    }

    public static int StrikeActions(String InputString) {
        int number = 0;
        //if input was strike, convert InputString 'X' to integer 10
        number = 10;
        //count scores for next two turns double
        strikeDoubleScoresActive = true;
        return number;

        //if input was strike in 10th frame, add two more turns

    }


     
}    