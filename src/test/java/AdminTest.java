import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javax.xml.bind.JAXBException;

class AdminTest {
    @Test
    public void adminInitialization() throws JAXBException {
        int firstUserType = 0;
        int secondUserType = 1;
        Admin firstAdmin = new Admin(firstUserType);
        Admin secondAdmin = new Admin(secondUserType);

        assertEquals(0, firstAdmin.getUserType());
        assertEquals(1, secondAdmin.getUserType());
    }
}