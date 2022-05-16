import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserServiceImplTest {
    //dummy class
    User user = Mockito.mock(User.class);

    //mock object
    UserDAO userDAO = Mockito.mock(UserDAO.class);
    SecurityService securityService = Mockito.mock(SecurityService.class);

    @Test
    public void testPassword() throws Exception {
        //prepare SUT
        UserServiceImpl sut = new UserServiceImpl(userDAO, securityService);
        //mock password
        String passwordMd5 = securityService.md5(user.getPassword());
        Mockito.when(securityService.md5(user.getPassword())).thenReturn("test123");
        user.setPassword(passwordMd5);
        System.out.println();

        //test act
        sut.assignPassword(user);

        //verify
        //hasil sama:
        Mockito.verify(user).setPassword("test123");
        //hasil beda
        //Mockito.verify(user).setPassword("test12345");
    }

    @Test
    public void testUpdate(){
        UserServiceImpl sut = new UserServiceImpl(userDAO, securityService);
        //check method update sudah terpanggil dengan benar?
        userDAO.updateUser(user);
        Mockito.verify(userDAO).updateUser(user);
    }
}
