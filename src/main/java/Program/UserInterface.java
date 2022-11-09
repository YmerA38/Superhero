package Program;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Scanner userInput = new Scanner(System.in);

    private Controler controler;

    public UserInterface(){
    }

    public void startUserInterface(){
        controler = new Controler();
        //controler.createTestList(); //TODO husk at slette, kun til  testbrug
        try {
            if (controler.load()) {
                System.out.println("file has been loaded");
            }
        }catch(FileNotFoundException x){
            System.out.println("file not found, program ends");
        }
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
                case 6:
                    save();
                    break;
                case 7:
                    load();
                    break;
                case 8:
                    sort();
                    break;
                case 0:
                    endProgram();
                default:
                    break;
            }

        }while(menu != 0);
    }

    public void sort(){
        System.out.println(" 1...Sort by name\n 2...Sort by other criteria\n 3...Sort by two criteria");
        int choice = giveMeInt();
        switch (choice){
            case 1 -> controler.sort();
            case 2 ->{
                System.out.println("Chose a criteria you want to sort by\n" +
                        " 1...Superhero Name\n 2...Real Name\n 3...Is Human\n 4...Super Power\n" +
                        " 5...Strength\n 6...Origin Year");

                controler.sort(giveMeHeroAtribute(giveMeInt()));
            }
            case 3 ->{
                System.out.println("Chose primary criteria: \n" +
                        " 1...Superhero Name\n 2...Real Name\n 3...Is Human\n 4...Super Power\n" +
                        " 5...Strength\n 6...Origin Year");
            int first = giveMeInt();
                System.out.println("Chose secondary criteria: \n" +
                        " 1...Superhero Name\n 2...Real Name\n 3...Is Human\n 4...Super Power\n" +
                        " 5...Strength\n 6...Origin Year");
            int second = giveMeInt();

            controler.sort(giveMeHeroAtribute(first),giveMeHeroAtribute(second));

            }
        }
    }

    private void load() {
        try {
            if (controler.load()) {
                System.out.println("file has been loaded");
            }
        }catch(FileNotFoundException x){
            System.out.println("file not found, program ends");
        }
    }

    private void endProgram() {
        System.out.println("do you want to save [y/n]");
        if(giveMeBoolean(userInput.nextLine())){
            save();
        }else{
            //TODO End program
        }
    }

    private void save() {
        boolean isSaved = false;
        try{
           isSaved = controler.save();
        }catch(FileNotFoundException x){
            System.out.println("not successful");
        }
        if (isSaved) {
            System.out.println("Saved successfully");
        } else {
            System.out.println("No changes has been made, and nothing was therefor saved");
        }

    }

    private int askUserInput(){
        System.out.println("\n     --MENU--\n1...Add new superhero\n2...Search for superhero\n3...Printout all superheroes\n" +
                "4...Edit super hero\n5...Delete superhero\n6...Save\n7...Load from last save\n8...Sorter superheroes \n0...End program");
        return giveMeInt();
    }
    private void userDefinedSuperhero(){
        System.out.println("What is superheros superhero name?");
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
        controler.createSuperhero(superheroName,name,superPower,originYear,isHuman,strength);
    }
    private void searchDatabase(){
        System.out.println("Indtast søgeord");
        String searchWord = userInput.nextLine();
        if(controler.searchSuperhero(searchWord) != null){
            ArrayList<Superhero> list = controler.searchSuperhero(searchWord);
            System.out.println(heroNameAndNumberFromList(list));
            int choice;
            do{
                System.out.println("Vælg nr på den du vil se, eller tryk 0 for at fortsætte");
                choice = giveMeInt();
                if(choice>0&&choice<= list.size()){
                    printObject(list.get(choice-1));
                }else{choice=0;}
            }while(choice!=0);
        }else{
            System.out.println("No searchWord match!!");
        }

    }
    private void printAll(){
        int i = 0;
        while(i < controler.getSuperheroList().size()){
            System.out.println("Nr: " + (i+1));
            System.out.println("Superhelt: " + controler.getSuperhero(i).getSuperheroName());
            System.out.println("Virkelige navn: " + controler.getSuperhero(i).getName());
            System.out.println("Er menneske?: "+ controler.getSuperhero(i).getIsHuman());
            System.out.println("Superkraft: "+ controler.getSuperhero(i).getSuperPower());
            System.out.println("Oprindelsesår: " + controler.getSuperhero(i).getOriginYear() + "\n"+
                    "Styrketal: "+controler.getSuperhero(i).getStrength()+"\n=====================");
            i++;
        }
        if(controler.getSuperheroList().isEmpty())
            System.out.println("No Superheroes in list");
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
        ArrayList<Superhero> list = controler.getSuperheroList();
        System.out.println(heroNameAndNumberFromList(list));
        System.out.println("Vælg Nr på den helt du gerne vil rette");
        int chooseHero = giveMeInt();
        Superhero selectedHero = list.get(chooseHero-1);
        System.out.println("Indtast din ændring, eller tast enter for at skippe");
        System.out.println("Superhelt: "+selectedHero.getSuperheroName());
        input = userInput.nextLine();
        if(!input.trim().isEmpty()){
            selectedHero.setSuperheroName(input);
            controler.changesMade();
        }
        System.out.println("Navn: "+selectedHero.getName());
        input = userInput.nextLine();
        if(!input.trim().isEmpty()){
            selectedHero.setName(input);
            controler.changesMade();
        }
        System.out.println("Superkraft: "+selectedHero.getSuperPower());
        input = userInput.nextLine();
        if(!input.trim().isEmpty()){
            selectedHero.setSuperPower(input);
            controler.changesMade();
        }
        System.out.println("oprindelsesår: "+selectedHero.getOriginYear());
        input = userInput.nextLine();
        if(!input.isEmpty()) {
           selectedHero.setOriginYear(giveMeInt(input));
           controler.changesMade();
        }
        System.out.print("Er menneske [j/n]: ");
        if(selectedHero.getIsHuman()){
            System.out.println("Ja");
        }else{
            System.out.println("Nej");
        }
        input = userInput.nextLine();
        if(!input.isEmpty()){
            selectedHero.setIsHuman(giveMeBoolean(input));
            controler.changesMade();
        }
        System.out.println("Styrke: "+selectedHero.getStrength());
        input = userInput.nextLine();
        if(!input.isEmpty()){
            selectedHero.setStrength(giveMeDouble(input));
            controler.changesMade();
        }
    }
    public void deleteHero(){
        System.out.println("Indtast søgeord for den superhelt du vil slette");
        ArrayList<Superhero> resultList = controler.searchSuperhero(userInput.nextLine().trim());
        System.out.println(heroNameAndNumberFromList(resultList));

        System.out.println("Indtast Nr på den du ønsker at slette");
        int i = giveMeInt();
        if(i>0&&i<=resultList.size()){
            Superhero heroToDelete = resultList.get(i-1);
            String deletedHero = heroToDelete.getSuperheroName();
            boolean success = controler.deleteSuperhero(heroToDelete);
            if(success){
                System.out.println(deletedHero+" blev slettet");
            }else {
                System.out.println("fel!! " + deletedHero + " blev ikke slettet");
            }
        }
    }

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
        return intOutput;
    }
    private int giveMeInt(String input){ //overdrive
        int intOutput = 0;
        boolean entryError;
        try{
            intOutput = Integer.parseInt(input);
        }catch (NumberFormatException ex1){
            System.out.println("fel i indtsastning\n prøv igen");
            do {
                try {
                    intOutput = Integer.parseInt(userInput.nextLine().trim());
                    entryError = false;
                } catch (NumberFormatException ex2) {
                    System.out.println("fel i indtsastning\n prøv igen");
                    entryError = true;
                }
            } while (entryError);
        }

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
    private double giveMeDouble(String input){ //overdrive
        double intOutput = 0;
        boolean entryError;
        try{
            intOutput = Double.parseDouble(input);
        }catch (NumberFormatException ex1){
            System.out.println("fel i indtsastning\n prøv igen");
            do {
                try {
                    intOutput = Double.parseDouble(userInput.nextLine().trim());
                    entryError = false;
                } catch (NumberFormatException ex2) {
                    System.out.println("fel i indtsastning\n prøv igen");
                    entryError = true;
                }
            } while (entryError);
        }

        return intOutput;
    }
    public boolean giveMeBoolean(String inputString){
        char firsChar = inputString.toLowerCase().trim().charAt(0);
        if(firsChar == 'j'||firsChar == 'y'||firsChar == 't') {
            return true;
        } else {
            return false;
        }
    }

    public HeroAttribute giveMeHeroAtribute(int input){
        switch (input){
            case 1 ->{return HeroAttribute.SUPERHERO_NAME;}
            case 2 ->{return HeroAttribute.NAME;}
            case 3 ->{return HeroAttribute.IS_HUMAN;}
            case 4 ->{return HeroAttribute.SUPER_POWER;}
            case 5 ->{return HeroAttribute.STRENGTH;}
            case 6 ->{return HeroAttribute.ORIGIN_YEAR;}
            default -> {return null;}
        }
    }

    public String heroNameAndNumberFromList(ArrayList<Superhero> list){
        int i = 1;
        String outputString ="";
        for(Superhero hero: list){
            outputString += (i+" "+hero.getSuperheroName()+"\n");
            i++;
        }
        return outputString;
    }


}
