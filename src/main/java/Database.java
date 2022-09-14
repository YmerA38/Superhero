import java.util.ArrayList;

public class Database {


    public Database(){
    }

    public void createSuperhero(String superheroName,String name,int originYear, boolean isHuman ){
        Superhero hero = new Superhero();
        hero.setSuperheroName(superheroName);
        hero.setName(name);
        hero.setOriginYear(originYear);
        hero.setIsHuman(isHuman);
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

    //public Superhero getSuperheros(int i){

       // return allX[i];
    //}
    public ArrayList getSuperheroList(){
        return allHeroeList;
    }
    public Superhero getSuperhero(int i){

        return allHeroeList.get(i);
    }

    public Superhero seachSuperhero(String search){
        for(Superhero hero : allHeroeList){

        }

        return null;
    }


}
