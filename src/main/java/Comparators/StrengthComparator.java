package Comparators;

import Program.Superhero;

import java.util.Comparator;

public class StrengthComparator extends AllComparator implements Comparator<Superhero> {

    public int compare(Superhero s1,Superhero s2){
        return (int)(1000*(s1.getStrength() - s2.getStrength()));
    }

}
