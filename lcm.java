/********************************************************************
 Author         ->  Daniel Glover - Akpey 
 Date           ->  10th October 2020
 Instagram      ->  @codingnewbies
 Twitter        ->  @codingnewbies
 IDE            ->  IntelliJ IDEA Community Edition 2020.2.3
 JDK Version    ->  JDK-14.0.2
 *********************************************************************/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lcm {
    private final List<Integer> listOfNumber = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        lcm lcmObject = new lcm();
        int numOfUserInput = lcmObject.getNumOfInput();
        lcmObject.getUseInput(numOfUserInput);

        System.out.println("The LCM is: " + lcmObject.calculateLCM());
    }

    public int getNumOfInput(){
        System.out.print("How many number do you want to find LCM: ");

        return scanner.nextInt();
    }

    public void getUseInput(int numOfInput){
        for(int counter = 1; counter <= numOfInput; ++counter){
            System.out.print("Enter number #" + counter + ": ");
            int userInput = scanner.nextInt();
            listOfNumber.add(userInput);
        }
    }

    public int GCD(int firstNumber, int secondNumber){
        return ((secondNumber == 0) ? firstNumber : GCD(secondNumber, firstNumber % secondNumber));
    }

    public int calculateLCM(){
        int lcm = listOfNumber.get(0);

        for(int iterator = 1; iterator < listOfNumber.size(); ++iterator){
            lcm = (((listOfNumber.get(iterator) * lcm)) / (GCD(listOfNumber.get(iterator), lcm)));
        }
        return lcm;
    }
}
