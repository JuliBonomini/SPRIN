package ar.com.onready.tuto.service;


import ar.com.onready.tuto.config.BeanConfig;
import ar.com.onready.tuto.vo.MeliSite;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.RequestMatcher;

import java.util.List;

import static org.junit.Assert.assertEquals
        ;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeLiTests {

    @Autowired
    MeLiService meLiService;

    @Autowired
    BeanConfig beanConfig;

    private MockRestServiceServer server;

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {

        server = MockRestServiceServer.createServer(beanConfig.restTemplate());
        this.server.expect(requestTo("https://api.mercadolibre.com/sites")).andExpect(method(HttpMethod.GET)).andRespond(withSuccess("hola", MediaType.APPLICATION_JSON));
    }


    @Test
    public void buscarSites_conApiPublica_respondeSites() {
        List<MeliSite> sites = meLiService.getSites();
        server.verify();

        assertEquals(20, sites.size());

    }

}
