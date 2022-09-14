import java.util.ArrayList;

public class Database {


    public Database(){
    }

    public void createSuperhero(String superheroName,String name,int originYear, boolean isHuman ){
        Superhero hero = new Superhero(superheroName,name,originYear,isHuman);

        allHeroeList.add(hero);
    }
    public String toString(){
        String list = "";
        for(Superhero hero : allHeroeList) {
            list = list + hero.getSuperheroName() + " " + hero.getName() + " " + hero.getIsHuman() + " " + hero.getOriginYear()+"\n";
        }
        return list;
    }
    //
    private ArrayList<Superhero> allHeroeList = new ArrayList<>();


    public ArrayList getSuperheroList(){
        return allHeroeList;
    }
    public Superhero getSuperhero(int i){

        return allHeroeList.get(i);
    }

    public Superhero searchSuperhero(String search){
        for(Superhero hero : allHeroeList){
            if(hero.getSuperheroName().toLowerCase().contains(search.toLowerCase())){
                return hero;
            }

        }
        return null;


    }


}
