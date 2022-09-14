import javax.lang.model.type.NullType;
import java.util.Scanner;

public class Main {

    public static void main(String[] Args){

        Database heroesDatabase = new Database();
        Scanner userInput = new Scanner(System.in);

        heroesDatabase.createTestList(); //husk at slette, kun ti testbrug
        int menu;
        do {
            System.out.println("Opret superhelt = 1, søg = 2, print = 3, Afslut = 0");
            menu = userInput.nextInt();
            if(menu==1) {
                userInput.nextLine();//efter en ny nextInt bug
                System.out.println("What is superheros suprhero name?");
                String superheroName = userInput.nextLine();
                System.out.println("What is superheros personal name?");
                String name = userInput.nextLine();
                System.out.println("What is heroes superpower?");
                String superPower = userInput.next();
                System.out.println("What is superheros origin year?");
                int originYear = userInput.nextInt();
                System.out.println("What is superheros a human?");
                boolean isHuman = userInput.nextBoolean();
                System.out.println("What is superheros strength (time a normal human)?");
                double strength = userInput.nextDouble();

                heroesDatabase.createSuperhero(superheroName,name,superPower,originYear,isHuman,strength);
            }
            if(menu == 2){
                System.out.println("Indtast søgeord");
                userInput.nextLine();//efter en ny nextInt bug
                String search = userInput.nextLine();

                System.out.println(heroesDatabase.searchSuperhero(search));
            }
            if(menu == 3){
                int i = 0;
                do{
                    System.out.println("Superhelt: " + heroesDatabase.getSuperhero(i).getSuperheroName());
                    System.out.println("Virkelige navn: " + heroesDatabase.getSuperhero(i).getName());
                    System.out.println("Superkraft: "+ heroesDatabase.getSuperhero(i).getSuperPower());
                    System.out.println("Oprindelsesår: " + heroesDatabase.getSuperhero(i).getOriginYear() + "\n"+
                            "Styrketal: "+heroesDatabase.getSuperhero(i).getStrength()+"\n=====================");
                    i++;
                }while(i< heroesDatabase.getSuperheroList().size());
            }

        }while(menu != 0);







        // next()charAt(0)
        // seach.equals(.....) er to strenge ens
        // .getNam().contais(search)
        // .getNam().toLowerCase.contais(search.toLowerCase)
    }
}
