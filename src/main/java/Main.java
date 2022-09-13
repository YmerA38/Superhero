import java.util.Scanner;

public class Main {

    public static void main(String[] Args){

        Database heroes = new Database();
        Scanner userInput = new Scanner(System.in);

        int i =0;
        do {


            System.out.println("What is superheros suprhero name?");
            String superheroName = userInput.next();
            System.out.println("What is superheros personal name?");
            String name = userInput.next();
            System.out.println("What is superheros origin year ?");
            int originYear = userInput.nextInt();
            System.out.println("What is superheros a human  ?");
            boolean isHuman = userInput.nextBoolean();
            heroes.createSuperhero(superheroName, name, originYear, isHuman);
            heroes.saveHeroToDatabase(i);
            i++;

        }while(i<100);

        System.out.println(heroes);

    }
}
