package br.com.matheus.machado.shorturl.repository;

import br.com.matheus.machado.shorturl.entity.Url;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends CrudRepository<Url, Long>, JpaSpecificationExecutor<Url> {

}
