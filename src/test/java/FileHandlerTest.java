import Program.Database;
import Program.FileHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileHandlerTest {
    @BeforeEach
    public void beforeEach(){
        FileHandler fileHandler = new FileHandler();
    }


    @Test
    public void testLoadNoChange(){
        //Test that the Database.changeIsMade stays false after load() has been called

        //Arrange
        Database database = new Database();
        boolean isChangeMadeExpected = false;
        //Act
        boolean isChangeMadeActual = database.isChangeMade();
        //Assert
        assertEquals(isChangeMadeExpected,isChangeMadeActual);
    }
}
