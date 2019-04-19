package br.com.matheus.machado.shorturl.service.specification;

import br.com.matheus.machado.shorturl.entity.Url;
import br.com.matheus.machado.shorturl.entity.Url_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public abstract class UrlSpecification {

    public static Specification<Url> byAlias(String alias) {
        return (Root<Url> root, CriteriaQuery<?> cq, CriteriaBuilder cb) -> {
            return cb.equal(root.get(Url_.alias), alias);
        };
    }

}
