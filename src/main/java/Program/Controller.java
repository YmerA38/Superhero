package Program;

import Comparators.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller {
    private Database heroesDatabase;
    private FileHandler fileHandler;

    public Controller(){
        heroesDatabase = new Database();
        fileHandler = new FileHandler();
    }
    public void createTestList() {
        heroesDatabase.createTestList();
    }

    public void createSuperhero(String superheroName, String name, String superPower,
                                int originYear, boolean isHuman, double strength) {
        heroesDatabase.createSuperhero(superheroName,name,superPower,originYear,isHuman,strength);
    }

    public ArrayList<Superhero> searchSuperhero(String searchWord) {
        return searchSuperhero(searchWord);
    }

    public Superhero getSuperhero(int i) {
        return heroesDatabase.getSuperhero(i);
    }

    public ArrayList<Superhero> getSuperheroList() {
        return heroesDatabase.getSuperheroList();
    }

    public boolean deleteSuperhero(Superhero heroToDelete) {
        return heroesDatabase.deleteSuperhero(heroToDelete);
    }

    public boolean save() throws FileNotFoundException {
        if(heroesDatabase.isChangeMade()) {
            fileHandler.save(heroesDatabase.getSuperheroList());
            return true;
        }else {
            return false;
        }
    }

    public boolean load() throws FileNotFoundException {
        return fileHandler.load(heroesDatabase.getSuperheroList());
    }
    public void sort(){
     Collections.sort(getSuperheroList());
    }
    public void sort(HeroAttribute attribute){
        Collections.sort(getSuperheroList(),(Comparator)(giveMeComparator(attribute)));
    }
    public void sort(HeroAttribute attribute1,HeroAttribute attribute2){
        Collections.sort(getSuperheroList(),((Comparator)(giveMeComparator(attribute1))).thenComparing((Comparator)(giveMeComparator(attribute2))));
    }

    public AllComparator giveMeComparator(HeroAttribute attribute){
        switch (attribute){
            case NAME -> {return new NameComparator();}
            case SUPERHERO_NAME -> {return new ShNameComparator();}
            case IS_HUMAN -> {return new IsHumanComparator();}
            case STRENGTH -> {return new StrengthComparator();}
            case ORIGIN_YEAR -> {return new OriginYearComparator();}
            case SUPER_POWER ->  {return new SuperPowerComparator();}
            default -> {return null;}
        }
    }
    public void changesMade(){
        heroesDatabase.changeMade();
    }
}
