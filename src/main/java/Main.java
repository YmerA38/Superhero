import java.util.Scanner;

public class Main {

    public static void Main(String[] Args){
        Database database = new Database();
        Scanner userInput = new Scanner(System.in);
        Superhero[] x = new Superhero[100];

        for(Superhero mySuperhero : x) {

            System.out.println("What is superheros suprhero name?");
            mySuperhero.setSuperheroName(userInput.next());
            System.out.println("What is superheros personal name?");
            mySuperhero.setName(userInput.next());
            System.out.println("What is superheros origin year ?");
            int originYear = userInput.nextInt();
            System.out.println("What is superheros a human  ?");
            boolean isHuman = userInput.nextBoolean();


        }
    }
}
