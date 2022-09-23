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
            switch (menu) {
                case 1:
                    userDefinedSuperhero();
                    break;
                case 2:
                    searchDatabase();
                    break;
                case 3:
                    printAll();
                    break;
                case 4:
                    editHero();
                    break;
                case 5:
                    deleteHero();
                    break;
                default:
                    break;
            }

        }while(menu != 0);
    }
    private int askUserInput(){
        System.out.println("1...Opret superhelt\n2...Søg efter superhelt\n3...Print alle superhelte\n" +
                "4...Rediger superhelt\n5...Slet superhelt \n0...Afslut program");
        return giveMeInt();
    }
    private void userDefinedSuperhero(){
        System.out.println("What is superheros suprhero name?");
        String superheroName = userInput.nextLine();
        System.out.println("What is superheros personal name?");
        String name = userInput.nextLine();
        System.out.println("What is heroes superpower?");
        String superPower = userInput.nextLine();
        System.out.println("What is superheros origin year?");
        int originYear = giveMeInt();
        System.out.println("What is superheros a human?");
        boolean isHuman = giveMeBoolean(userInput.nextLine());
        System.out.println("What is superheros strength (time a normal human)?");
        double strength = giveMeDouble();
        heroesDatabase.createSuperhero(superheroName,name,superPower,originYear,isHuman,strength);
    }
    private void searchDatabase(){
        System.out.println("Indtast søgeord");
        String searchWord = userInput.nextLine();
        if(heroesDatabase.searchSuperhero(searchWord) != null){
            ArrayList<Superhero> list = heroesDatabase.searchSuperhero(searchWord);
            heronameAndNumberFromList(list);
            int choice;
            do{
                System.out.println("Vælg nr på den du vil se, eller tryk 0 for at fortsætte");
                choice = giveMeInt();
                if(choice>0&&choice<= list.size()){
                    printObject(list.get(choice));
                }else{choice=0;}
            }while(choice!=0);
        }else{
            System.out.println("No searchWord match!!");
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
        if(hero.getIsHuman()){
            System.out.println("Art: Menneske");
        }else{
            System.out.println("Art: Ikke menneske");
        }
        System.out.println("Styrketal: "+hero.getStrength()+"\n=====================");
    }
    private void editHero(){
        String input;
        ArrayList<Superhero> list = heroesDatabase.getSuperheroList();
        heronameAndNumberFromList(list);
        System.out.println("Vælg Nr på den helt du gerne vil rette");
        int chooseHero = giveMeInt();
        Superhero selectedHero = list.get(chooseHero-1);
        System.out.println("Indtast din ændring, eller tast enter for at skippe");
        System.out.println("Superhelt: "+selectedHero.getSuperheroName());
        input = userInput.nextLine();
        if(!input.trim().isEmpty()){
        selectedHero.setSuperheroName(input);
        }
        System.out.println("Navn: "+selectedHero.getName());
        input = userInput.nextLine();
        if(!input.trim().isEmpty()){
        selectedHero.setName(input);
        }
        System.out.println("Superkraft: "+selectedHero.getSuperPower());
        input = userInput.nextLine();
        if(!input.trim().isEmpty()){
        selectedHero.setSuperPower(input);
        }
        System.out.println("oprindelsesår: "+selectedHero.getOriginYear());
        if(!userInput.nextLine().isEmpty()) {
           selectedHero.setOriginYear(giveMeInt());
        }
        System.out.print("Er menneske [j/n]: "+selectedHero.getIsHuman());
        if(selectedHero.getIsHuman()){
            System.out.println("Ja");
        }else{
            System.out.println("Nej");
        }
        input = userInput.nextLine();
        if(!input.isEmpty()){
            selectedHero.setIsHuman(giveMeBoolean(input));
        }
        System.out.println("Styrke: "+selectedHero.getStrength());
        if(!userInput.nextLine().isEmpty()){
            selectedHero.setStrength(giveMeDouble());
        }
    }
    public void deleteHero(){
        System.out.println("Indtast søgeord for den superhelt du vil slette");
        ArrayList<Superhero> resultList = heroesDatabase.searchSuperhero(userInput.nextLine().trim());
        System.out.println(heronameAndNumberFromList(resultList));
        System.out.println("Indtast Nr på den du ønsker at slette");
        int i = giveMeInt();
        Superhero heroToDelete = resultList.get(i-1);
        boolean success = heroesDatabase.deleteSuperhero(heroToDelete);
        if(success){
            System.out.println(heroToDelete+" blev slettet");
        }else{
            System.out.println("fel!! "+heroToDelete+" blev ikke slettet");
        }
    }
    //TODO
    private int giveMeInt(){
        int intOutput = 0;
        boolean entryError;
        do{
            try {
                intOutput = Integer.parseInt(userInput.nextLine().trim());
                entryError = false;
            } catch (NumberFormatException ex) {
                System.out.println("fel i indtsastning\n prøv igen");
                entryError = true;
            }
        }while(entryError);
        userInput.nextLine();//scanner bugfix
        return intOutput;
    }
    private double giveMeDouble(){
        double intOutput = 0;
        boolean entryError;
        do{
            try {
                intOutput = Double.parseDouble(userInput.nextLine().trim());
                entryError = false;
            } catch (NumberFormatException ex) {
                System.out.println("fel i indtsastning\n prøv igen");
                entryError = true;
            }
        }while(entryError);
        return intOutput;
    }
    public boolean giveMeBoolean(String inputString){
        if(inputString.toLowerCase().trim().charAt(0) == 'j') {
            return true;
        } else {
            return false;
        }
    }
    public String heronameAndNumberFromList(ArrayList<Superhero> list){
        int i = 1;
        String outputString ="";
        for(Superhero hero: list){
            outputString += (i+" "+hero.getSuperheroName()+"\n");
            i++;
        }
        return outputString;
    }

}
