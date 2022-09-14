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

            }

        }while(menu != 0);

        //System.out.println(heroes);
        int i = 0;
        do{
            System.out.println("Superhelt: " + heroes.getSuperhero(i).getSuperheroName());
            System.out.println("Virkelige navn: " + heroes.getSuperhero(i).getName());
            System.out.println("Oprindelsesår: " + heroes.getSuperhero(i).getOriginYear() + "\n =============");
            i++;
        }while(i< heroes.getSuperheroList().size());//Database-object.metode der returnerer liste. metode på liste

        System.out.println("Vil du søge efter superhelt tast 5, afslut tast 0");
        menu = userInput.nextInt();
        if(menu == 5){
            i=0;
            System.out.println("Indtast søgeord");
            String search = userInput.nextLine();
            while(search != heroes.getSuperhero(i).getSuperheroName()){
                i++;
            }
        }




        // next()charAt(0)
        // seach.equals(.....) er to strenge ens
        // .getNam().contais(search)
        // .getNam().toLowerCase.contais(search.toLowerCase)
    }
}
