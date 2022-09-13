import java.util.Scanner;

public class Main {

    public static void main(String[] Args){

        Database heroes = new Database();
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is superheros suprhero name?");
        String superheroName = userInput.next();
        System.out.println("What is superheros personal name?");
        String name = userInput.next();
        System.out.println("What is superheros origin year ?");
        int originYear = userInput.nextInt();
        System.out.println("What is superheros a human  ?");
        boolean isHuman = userInput.nextBoolean();


        heroes.createSuperhero(superheroName,name,originYear,isHuman);

        System.out.println(heroes);

    }
}
