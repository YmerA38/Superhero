import javax.lang.model.type.NullType;
import java.util.Scanner;

public class Main {

    public static void main(String[] Args){

        Database heroes = new Database();
        Scanner userInput = new Scanner(System.in);


        int menu;
        do {
            System.out.println("Opret superhelt = 1, Afslut = 0");
            menu = userInput.nextInt();
            if(menu==1) {
                userInput.nextLine();//efter en ny nextInt bug
                System.out.println("What is superheros suprhero name?");
                String superheroName = userInput.nextLine();
                System.out.println("What is superheros personal name?");
                String name = userInput.nextLine();
                System.out.println("What is superheros origin year ?");
                int originYear = userInput.nextInt();
                System.out.println("What is superheros a human   ?");
                boolean isHuman = userInput.nextBoolean();
                heroes.createSuperhero(superheroName, name, originYear, isHuman);
                heroes.saveHeroToDatabase();

            }

        }while(menu != 0);

        //System.out.println(heroes);
        int i = 0;
        do{
            System.out.println("Superhelt: " + heroes.getSuperhero(i).getSuperheroName());
            System.out.println("Virkelige navn: " + heroes.getSuperhero(i).getName());
            System.out.println("Oprindelsesår: " + heroes.getSuperhero(i).getOriginYear());
            i++;
        }while(i<10);//while(heroes.getSuperhero(i).getName() != null);

    }
}
