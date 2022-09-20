import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> allHeroList;

    public Database(){
        allHeroList = new ArrayList<>();
    }

    public void createSuperhero(String superheroName,String name, String superPower,int originYear, boolean isHuman,double strength ){
        Superhero hero = new Superhero(superheroName,name,superPower,originYear,isHuman,strength);

        allHeroList.add(hero);
    }

    public void createTestList(){
        allHeroList.add(new Superhero("BoligMand","Bo","at sæle dig en bolig",1975,true,1));
        allHeroList.add(new Superhero("GåIkioskenMand","John","At gå i kiosken efter smøger",1945,true,0.85));
        allHeroList.add(new Superhero("Lotte","Lotte","at blive usynlig",1982,true,0.5));
        allHeroList.add(new Superhero("VandMand","Intet navn","at ligge i vandet",2022,false,0.0001));
        allHeroList.add(new Superhero("FranskMand","Piare","at være arrogant",1968,true,1));
        allHeroList.add(new Superhero("HeMan","Hermand"," at være et dårlig forbillede for drengebørn",1982,true,2));
    }
    public String toString(){
        String list = "";
        for(Superhero hero : allHeroList) {
            list = list + hero.getSuperheroName() + " " + hero.getName() + " " + hero.getIsHuman() + " " + hero.getOriginYear()+"\n";
        }
        return list;
    }

    public ArrayList getSuperheroList(){
        return allHeroList;
    }
    public Superhero getSuperhero(int i){

        return allHeroList.get(i);
    }


    public ArrayList<Superhero> searchSuperhero(String search){
        ArrayList<Superhero> searchResultList = new ArrayList<>();
        for(Superhero hero : allHeroList){
            if(hero.getSuperheroName().toLowerCase().contains(search.toLowerCase())){
                searchResultList.add(hero);

            }

        }
        if(searchResultList.size()>0){
            return searchResultList;
        }else{
            return null;
        }

    }

}
