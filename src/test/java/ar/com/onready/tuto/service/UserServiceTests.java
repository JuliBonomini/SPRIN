package ar.com.onready.tuto.service;

import ar.com.onready.tuto.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void buscarPorId_conIdValido_devuelveUser() {
        User user = userService.buscarPorId(1);

        assertEquals("Julian", user.getUsername());
        assertEquals("asd123", user.getPassword());
        assertEquals(1, user.getId());
    }

    @Test
    public void buscarPorUsername_conUsernameValido_devuelveUser() {
        User user = userService.buscarPorUsername("Julian");

        assertEquals("Julian", user.getUsername());
        assertEquals("asd123", user.getPassword());
        assertEquals(1, user.getId());
    }

    @Test
    @Transactional
    public void guardarUsuario_conUsuarioValido_devuelveUsuario() {
        User newUser = new User();
        newUser.setId(3);
        newUser.setUsername("Roberto");
        newUser.setPassword("asd123");

        User savedUser = userService.guardarUsuario(newUser);


        assertEquals(newUser.getUsername(), savedUser.getUsername());
        assertEquals(newUser.getPassword(), savedUser.getPassword());
        assertEquals(newUser.getId(), savedUser.getId());
    }

}
