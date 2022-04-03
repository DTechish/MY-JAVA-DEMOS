/********************************************************************
 Author         ->  Daniel Glover - Akpey
 Date           ->  10th October 2020
 Instagram      ->  @dtechish
 Twitter        ->  @dtechish
 IDE            ->  IntelliJ IDEA Community Edition 2020.2.3
 JDK Version    ->  JDK-14.0.2
 *********************************************************************/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hcf {
    private final List<Integer> listOfNumber = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        hcf hcfObject = new hcf();
        int numOfUsersInput = hcfObject.getNumOfInput();
        hcfObject.getUseInput(numOfUsersInput);

        System.out.println("The HCF is: " + hcfObject.calculateHCF());
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

    int GCD(int firstNumber, int secondNumber)
    {
        return ((firstNumber == 0) ? secondNumber : GCD(secondNumber % firstNumber, firstNumber));
    }

    public int calculateHCF(){
        int hcf = listOfNumber.get(0);

        for(int iterator = 1; iterator < listOfNumber.size(); ++iterator){
            hcf = GCD(listOfNumber.get(iterator), hcf);

            if(hcf == 1){
                return 1;
            }
        }
        return hcf;
    }
}
