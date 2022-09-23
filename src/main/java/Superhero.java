public class Superhero {
    private String superheroName;
    private String name;
    private String superPower;
    private int originYear;
    private boolean isHuman;
    private double strength;



    public Superhero(String superheroName,String name,String superPower,int originYear,boolean isHuman, double strength ) {
        this.name = name;
        this.superheroName = superheroName;
        this.superPower = superPower;
        this.originYear = originYear;
        this.isHuman = isHuman;
        this.strength = strength;
    }


    public String getName(){
        return name;
    }
    public String getSuperheroName(){
        return superheroName;
    }
    public String getSuperPower(){
        return superPower;
    }
    public int getOriginYear(){
        return originYear;
    }
    public boolean getIsHuman(){
        return isHuman;
    }
    public double getStrength(){
        return strength;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSuperheroName(String superheroName){
        this.superheroName = superheroName;
    }
    public void setSuperPower(String superPower){
        this.superPower = superPower;
    }
    public void  setOriginYear(int originYear){
        this.originYear = originYear;
    }
    public void  setIsHuman(boolean isHuman){
        this.isHuman = isHuman;
    }
    public void setStrength(double strength){
        this.strength = strength;
    }
    public String toString(){
       return "Superhero " + superheroName + "\nName " + name + "\nSuperpower: " + superPower+ "\nYear: "+ originYear+
               "\nStrength: " + strength +"\n==========================";
    }
}
