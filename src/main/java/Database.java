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
        return x.getSuperheroName()+" "+x.getName()+" "+ x.getIsHuman() +" "+ x.getOriginYear();

    }
}
