package br.com.matheus.machado.shorturl.service.impl;

import br.com.matheus.machado.shorturl.entity.Url;
import br.com.matheus.machado.shorturl.repository.UrlRepository;
import br.com.matheus.machado.shorturl.service.UrlService;
import br.com.matheus.machado.shorturl.service.specification.UrlSpecification;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    UrlRepository repository;

    @Override
    public Optional<Url> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Url> findByAlias(String alias) {
        Specification<Url> spec = UrlSpecification.byAlias(alias);
        return repository.findOne(spec);
    }

    @Override
    public Url save(Url url) {
        return repository.save(url);
    }

}
