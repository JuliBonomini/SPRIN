package ar.com.onready.tuto.service;


import ar.com.onready.tuto.TutoApplicationTests;
import ar.com.onready.tuto.vo.MeliSite;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@AutoConfigureMockRestServiceServer
public class MeLiTests extends TutoApplicationTests {

    @Autowired
    private MeLiService meLiService;

    @Autowired
    private MockRestServiceServer server;


    @Test
    public void buscarSites_conApiPublica_respondeSites() {
        server.expect(requestTo("https://api.mercadolibre.com/sites")).andExpect(method(HttpMethod.GET)).andRespond(withSuccess("[{\"id\": 1,\"nombre\":\"julian\"},{\"id\": 2, \"nombre\":\"julian\"}]", MediaType.APPLICATION_JSON));
        List<MeliSite> sites = meLiService.getSites();
        server.verify();

        assertEquals(2, sites.size());

    }

}
