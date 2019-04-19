package br.com.matheus.machado.shorturl.service;

import br.com.matheus.machado.shorturl.entity.Url;
import java.util.Optional;

public interface UrlService {

    public Optional<Url> findById(Long id);

    public Optional<Url> findByAlias(String alias);

    public Url save(Url url);

}
