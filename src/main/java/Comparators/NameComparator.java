package Comparators;
import Program.Superhero;

import java.util.Comparator;

public class NameComparator extends AllComparator implements Comparator<Superhero> {
    public int compare(Superhero s1,Superhero s2){
        return s1.getName().compareTo(s2.getName());
    }
}
