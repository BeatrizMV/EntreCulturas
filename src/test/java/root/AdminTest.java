package root;
import enums.Rol;
import org.junit.jupiter.api.Test;

import root.Admin;

import static org.junit.jupiter.api.Assertions.*;

import javax.xml.bind.JAXBException;

class AdminTest {
    @Test
    public void adminInitialization() throws JAXBException {
        Rol firstUserType = Rol.ADMIN;
        Rol secondUserType = Rol.USER;
        Admin firstAdmin = new Admin(firstUserType);
        Admin secondAdmin = new Admin(secondUserType);

        assertEquals(Rol.ADMIN, firstAdmin.getUserType());
        assertEquals(Rol.USER, secondAdmin.getUserType());
    }
}