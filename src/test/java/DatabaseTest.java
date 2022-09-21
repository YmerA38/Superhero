import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    private Database database;

    @BeforeEach
    public void beforeEach(){
        database = new Database();
        database.createTestList();
    }

    @Test
    public void testSizeMand() {
        //Arrange
        Database database = new Database();
        database.createTestList();
        int expected = 4;
        //Act
        int actual = database.searchSuperhero("mand").size();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void testSizeBoligMand() {
        //Arrange
        Database database = new Database();
        database.createTestList();
        int expected = 1;
        //Act
        int actual = database.searchSuperhero("boligmand").size();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void testSizeXxx() {
        //Arrange
        Database database = new Database();
        database.createTestList();
        //ArrayList<Superhero> expected = null;
        //Act
        ArrayList<Superhero> actual = database.searchSuperhero("Xxx");
        //Assert
        assertNull(actual);
    }
    @Test
    public void testSizeEmpty() {
        //Arrange
        Database database = new Database();
        database.createTestList();
        // expected null
        //Act
        ArrayList<Superhero> actual = database.searchSuperhero("");
        //Assert
        assertNull(actual);
    }
    @Test
    public void testSizeSpace() {
        //Arrange
        Database database = new Database();
        database.createTestList();
        // expected null
        //Act
        ArrayList<Superhero> actual = database.searchSuperhero(" ");
        //Assert
        assertNull(actual);
    }
    @Test
    public void isTrueTrue(){
        assertTrue(true);
    }

    //
    @Test
    public void deleteSuperhero(){
        //Bliver opgaven udførdt?
        //Arrange
        ArrayList<Superhero> resultList = database.searchSuperhero("man");
        Superhero heroToDelete = resultList.get(0);
        boolean expected = true;
        //Act
        boolean actual = database.deleteSuperhero(heroToDelete);
        //Assert
        assertEquals(expected,actual);
    //Bliver listen kortere?
        //Arrange
        int expectedSize = resultList.size()-1;
        //Act
        int actualSize = database.searchSuperhero("man").size();
        //Assert
        assertEquals(expectedSize,actualSize);

        //Har vi fjernet "BoligMand"?
        //Arrange
        ArrayList<Superhero> expectedS = null;
        //Act
        ArrayList<Superhero> actualS = database.searchSuperhero("BoligMand");
        //Assert
        assertEquals(expectedS,actualS);
        assertNull(actualS);
    }
}