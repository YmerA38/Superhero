import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner userInput = new Scanner(System.in);
    private Database heroesDatabase; // erklærer en instans

    public UserInterface(){
    }

    public void startUserInterface(){
        heroesDatabase = new Database(); // assigner instansen
        heroesDatabase.createTestList(); //TODO husk at slette, kun til  testbrug
        menu();
    }

    public void menu(){

        int menu;
        do {
            menu = askUserInput();
            if(menu==1) {
                userDefinedSuperhero();
            }
            if(menu == 2){
                searchDatabase();
            }
            if(menu == 3){
                printAll();
            }
            if(menu == 4){
                editHero();
            }

        }while(menu != 0);
    }
    private int askUserInput(){
        System.out.println("Opret superhelt = 1, søg = 2, print = 3, edit = 4, Afslut = 0");
        return userInput.nextInt();
    }
    private void userDefinedSuperhero(){
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
        userInput.nextLine();//efter en ny nextInt bug
        char isHumanChar = userInput.nextLine().charAt(0);
        boolean isHuman;
        if(isHumanChar=='j'||isHumanChar=='J'){
            isHuman = true;
        }else{ isHuman = false;}
        System.out.println("What is superheros strength (time a normal human)?");
        double strength = userInput.nextDouble();
        heroesDatabase.createSuperhero(superheroName,name,superPower,originYear,isHuman,strength);
    }
    private void searchDatabase(){
        System.out.println("Indtast søgeord");
        userInput.nextLine();//efter en ny nextInt bug
        String search = userInput.nextLine();
        if(heroesDatabase.searchSuperhero(search) != null){
            int i = 0;
            do {
                printObject(heroesDatabase.searchSuperhero(search).get(i));
                i++;
            }while (i<heroesDatabase.searchSuperhero(search).size());
        }else{
            System.out.println("No search match!!");
        }

    }
    private void printAll(){
        int i = 0;
        do{
            System.out.println("Nr: " + (i+1));
            System.out.println("Superhelt: " + heroesDatabase.getSuperhero(i).getSuperheroName());
            System.out.println("Virkelige navn: " + heroesDatabase.getSuperhero(i).getName());
            System.out.println("Superkraft: "+ heroesDatabase.getSuperhero(i).getSuperPower());
            System.out.println("Oprindelsesår: " + heroesDatabase.getSuperhero(i).getOriginYear() + "\n"+
                    "Styrketal: "+heroesDatabase.getSuperhero(i).getStrength()+"\n=====================");
            i++;
        }while(i < heroesDatabase.getSuperheroList().size());
    }
    private void printObject(Superhero hero){
        System.out.println("Superhelt: " + hero.getSuperheroName()+"\n"+ "Virkelige navn: " + hero.getName()+"\n"+
                "Superkraft: "+ hero.getSuperPower()+"\n"+ "Oprindelsesår: " + hero.getOriginYear() );
        if(hero.getIsHuman()==true){
            System.out.println("Art: Menneske");
        }else{
            System.out.println("Art: Ikke menneske");

        }
        System.out.println("Styrketal: "+hero.getStrength()+"\n=====================");
    }
    /*private void editHero(){
        for(Superhero hero : heroesDatabase.getSuperheroList()){
        }*/
    private void editHero(){
        ArrayList<Superhero> list = heroesDatabase.getSuperheroList();
        int i = 1;
        for(Superhero hero : list ) {
            System.out.printf("Nr. %4d....%s\n", i, hero.getSuperheroName());
            i++;
        }

        userInput.nextLine();//bugfix
        int chooseHero = 0;
        boolean entryError = false; //Ttil at fange indtastningsfejl
        do{
            System.out.println("Vælg Nr på den helt du gerne vil rette");
            String chooseHeroString = userInput.nextLine();
            try {
                chooseHero = Integer.parseInt(chooseHeroString);
                entryError = false;
            } catch (NumberFormatException ex) {
                System.out.println("fel i indtsastning");
                entryError = true;
            }
        }while(entryError == true);

        Superhero selectedHero = heroesDatabase.getSuperhero(chooseHero-1);
        System.out.println("Indtast din ændring, eller tast enter for at skippe");

        System.out.println("Superhelt: "+selectedHero.getSuperheroName());
        if(!userInput.nextLine().isEmpty()){
        selectedHero.setSuperheroName(userInput.nextLine());}
        System.out.println("Navn: "+selectedHero.getName());
        if(!userInput.nextLine().isEmpty()){
        selectedHero.setName(userInput.nextLine());}
        System.out.println("Superkraft: "+selectedHero.getSuperPower());
        if(!userInput.nextLine().isEmpty()){
        selectedHero.setSuperPower(userInput.nextLine());}
        System.out.println("oprindelsesår: "+selectedHero.getOriginYear());
        if(!userInput.nextLine().isEmpty()) {
            do {
                if (userInput.hasNextInt())
                    selectedHero.setOriginYear(userInput.nextInt());
                else System.out.println("Fejl i indtastning!! \nprøv igen");
            }while (!userInput.hasNextInt());
        }
        System.out.println("Er menneske [j/n]: "+selectedHero.getIsHuman());
        if(!userInput.nextLine().isEmpty()) {
            if (userInput.nextLine().toLowerCase().contains("j")) {
                heroesDatabase.getSuperhero(chooseHero).setIsHuman(true);
            } else {
                heroesDatabase.getSuperhero(chooseHero).setIsHuman(false);
            }
        }
        System.out.println("Styrke: "+selectedHero.getStrength());
        if(!userInput.nextLine().isEmpty()){
            if(userInput.hasNextDouble()) {
                heroesDatabase.getSuperhero(chooseHero).setStrength(userInput.nextDouble());
            }
        }


    }


}
