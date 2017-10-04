package ar.com.onready.tuto.repository.impl;

import ar.com.onready.tuto.config.BeanConfig;
import ar.com.onready.tuto.repository.MeLiRepository;
import ar.com.onready.tuto.vo.MeliSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class MeLiRepositoryImpl implements MeLiRepository {

    @Autowired
    BeanConfig beanConfig;

    @Override
    public List<MeliSite> getSites() {
        List<MeliSite> sites = beanConfig.restTemplate().getForObject("https://api.mercadolibre.com/sites", List.class);
        return sites;
    }

}
