public class Superhero {
    private String name;
    private String superheroName;
    private int originYear;
    private boolean isHuman;

    public Superhero(String name,String superheroName,int originYear,boolean isHuman ){
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

    public void setName(String Name){
        this.name = name;
    }
}
