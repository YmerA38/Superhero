import java.sql.SQLOutput;
import java.util.Scanner;

public class Database {

    public void askForData(){
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is superheros suprhero name?");
        String name = userInput.next();
        System.out.println("What is superheros personal name?");
        String superheroName = userInput.next();
        System.out.println("What is superheros origin year ?");
        int originYear = userInput.nextInt();
        System.out.println("What is superheros a human  ?");
        boolean isHuman = userInput.nextBoolean();


    }






}
