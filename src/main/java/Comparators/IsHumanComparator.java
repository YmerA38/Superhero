package Comparators;

import Program.Superhero;

import java.util.Comparator;

public class IsHumanComparator extends AllComparator implements Comparator<Superhero> {
    public int compare(Superhero s1, Superhero s2){
        if(s1.getIsHuman()==s2.getIsHuman()){
            return 0;
        }else if (s1.getIsHuman() && !s2.getIsHuman()){
            return 1;
        }else{
            return -1;
        }

    }
}
