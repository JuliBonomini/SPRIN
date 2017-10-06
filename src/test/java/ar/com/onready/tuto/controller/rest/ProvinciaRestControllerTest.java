package ar.com.onready.tuto.controller.rest;

import ar.com.onready.tuto.TutoApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class ProvinciaRestControllerTest extends TutoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProvincias_devuelveJsonProvincias() throws Exception {
        mockMvc.perform(get("/api/provincias"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"nombre\":\"Buenos Aires\",\"paisId\":1},{\"id\":2,\"nombre\":\"Mendoza\",\"paisId\":1},{\"id\":5,\"nombre\":\"San Luis\",\"paisId\":1}]"))
        ;
    }

}
