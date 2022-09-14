public class Superhero {
    private String name;
    private String superheroName;
    private int originYear;
    private boolean isHuman;

    public Superhero(){}

    public Superhero(String superheroName,String name,int originYear,boolean isHuman ) {
        this.name = name;
        this.superheroName = superheroName;
        this.originYear = originYear;
        this.isHuman = isHuman;
    }


    public String getName(){
        return name;
    }
    public String getSuperheroName(){
        return superheroName;
    }
    public int getOriginYear(){
        return originYear;
    }
    public boolean getIsHuman(){
        return isHuman;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSuperheroName(String superheroName){
        this.superheroName = superheroName;
    }
    public void  setOriginYear(int originYear){
        this.originYear = originYear;
    }
    public void  setIsHuman(boolean isHuman){
        this.isHuman = isHuman;
    }
}
