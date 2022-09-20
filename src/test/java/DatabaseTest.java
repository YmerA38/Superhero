import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    @Test
    //Arrange
    public void testSize() {
        Database database = new Database();
        int expected = 5;
        //Act
        int actual = database.searchSuperhero("mand").size();
        //Assert
        assertEquals(expected,actual);
    }
}