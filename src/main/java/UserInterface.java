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

        }while(menu != 0);
    }
    private int askUserInput(){
        System.out.println("Opret superhelt = 1, søg = 2, print = 3, Afslut = 0");
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
            System.out.println("Nr: " + i +1);
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
    private void editHeroInterface(){
        for(int i=0; i< heroesDatabase.getSuperheroList().size();i++){
            System.out.printf("Nr. %4d....%s\n", i+1, heroesDatabase.getSuperhero(i).getSuperheroName() );
        }
        System.out.println("Vælg Nr på den helt du gerne vil rette");
        int valg = userInput.nextInt();
        //heroesDatabase.editHero(valg);
    }

}
