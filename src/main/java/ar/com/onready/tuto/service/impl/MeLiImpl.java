package ar.com.onready.tuto.service.impl;

import ar.com.onready.tuto.repository.MeLiRepository;
import ar.com.onready.tuto.service.MeLiService;
import ar.com.onready.tuto.vo.MeliSite;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MeLiImpl implements MeLiService {

    private MeLiRepository meLiRepository;

    public MeLiImpl(MeLiRepository meLiRepository) {
        this.meLiRepository = meLiRepository;
    }

    @Override
    public List<MeliSite> getSites() {
        return meLiRepository.getSites();
    }
}
