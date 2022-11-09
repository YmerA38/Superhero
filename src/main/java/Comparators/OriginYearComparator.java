package Comparators;
import Program.Superhero;
import java.util.Comparator;

public class OriginYearComparator extends AllComparator implements Comparator<Superhero>{
    public int compare(Superhero s1,Superhero s2){
        return s1.getOriginYear()-s2.getOriginYear();
    }
}
