package Program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler  {
    private final String FILE_NAME = "Data/save.csv";
    public boolean save(ArrayList<Superhero> superheroList)throws FileNotFoundException {

        //CSV file
        PrintStream toCsvFile = new PrintStream(FILE_NAME);
        for(Superhero superhero: superheroList){
            toCsvFile.println(superhero.getSuperheroName()+";"+superhero.getName()+";"+superhero.getSuperPower()+
                    ";"+superhero.getOriginYear()+";"+superhero.getIsHuman()+";"+superhero.getStrength());

        }
        toCsvFile.flush();
        toCsvFile.close();

        return true; // TODO check om der er blevet skrevet til fil
    }

    public boolean load(ArrayList<Superhero> superheroList)throws FileNotFoundException{

        superheroList.clear();
        Scanner fileScanner = new Scanner(new File(FILE_NAME));
        String line;
        String[] parts;

        do{
            line = fileScanner.nextLine();
            parts = line.split(";");
            if(!line.isEmpty()){
                superheroList.add(new Superhero(parts[0],parts[1],parts[2],Integer.parseInt(parts[3]),
                        Boolean.parseBoolean(parts[4]),Double.parseDouble(parts[5])));
            }

        }while(fileScanner.hasNextLine()&& !line.isEmpty());

        return true;// TODO check om der er blevet loaded fil
    }
}
