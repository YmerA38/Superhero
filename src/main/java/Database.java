import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> allHeroeList = new ArrayList<>();

    public Database(){
        allHeroeList = new ArrayList<>();
    }

    public void createSuperhero(String superheroName,String name, String superPower,int originYear, boolean isHuman,double strength ){
        Superhero hero = new Superhero(superheroName,name,superPower,originYear,isHuman,strength);

        allHeroeList.add(hero);
    }

    public void createTestList(){
        allHeroeList.add(new Superhero("BoligMand","Bo","at sæle dig en bolig",1975,true,1));
        allHeroeList.add(new Superhero("GåIkioskenMand","John","At gå i kiosken efter smøger",1945,true,0.85));
        allHeroeList.add(new Superhero("Lotte","Lotte","at blive usynlig",1982,true,0.5));
        allHeroeList.add(new Superhero("VandMand","Intet navn","at ligge i vandet",2022,false,0.0001));
        allHeroeList.add(new Superhero("FranskMand","Piare","at være arrogant",1968,true,1));
        allHeroeList.add(new Superhero("HeMan","Hermand"," at være et dårlig forbillede for drengebørn",1982,true,2));
    }
    public String toString(){
        String list = "";
        for(Superhero hero : allHeroeList) {
            list = list + hero.getSuperheroName() + " " + hero.getName() + " " + hero.getIsHuman() + " " + hero.getOriginYear()+"\n";
        }
        return list;
    }

    public ArrayList getSuperheroList(){
        return allHeroeList;
    }
    public Superhero getSuperhero(int i){

        return allHeroeList.get(i);
    }


    public ArrayList<Superhero> searchSuperhero(String search){
        ArrayList<Superhero> seachResultList = new ArrayList<>();
        for(Superhero hero : allHeroeList){
            if(hero.getSuperheroName().toLowerCase().contains(search.toLowerCase())){
                seachResultList.add(hero);

            }

        }
        if(seachResultList.size()>0){
            return seachResultList;
        }else{
            return null;
        }

    }
    public void editHero(int index){ //TODO skal jeg lave denne metode
        getSuperhero(index);

    }



}
