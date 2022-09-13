import java.util.ArrayList;

public class Database {

    public Database(){
    }
    Superhero x = new Superhero();
    public void createSuperhero(String superheroName,String name,int originYear, boolean isHuman ){
        x.setSuperheroName(superheroName);
        x.setName(name);
        x.setOriginYear(originYear);
        x.setIsHuman(isHuman);
    }
    public String toString(){
        String list = "";
        for(Superhero hero : allX) {
            list = list + hero.getSuperheroName() + " " + hero.getName() + " " + hero.getIsHuman() + " " + hero.getOriginYear()+"\n";
        }
        return list;
    }
    //Superhero[] allX = new Superhero[100];
    ArrayList<Superhero> allX = new ArrayList<>();
    public void saveHeroToDatabase(){
        allX.add(x);
    }
    //public Superhero getSuperheros(int i){

       // return allX[i];
    //}
    public ArrayList getSuperheroList(){
        return allX;
    }
    public Superhero getSuperhero(int i){
        return allX.get(i);
    }


}
