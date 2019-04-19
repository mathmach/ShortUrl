package br.com.matheus.machado.shorturl.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UrlDTO {

    private Long id;
    private String alias;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @NotEmpty(message = "Field alias is required")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @NotNull
    @NotEmpty(message = "Field url is required")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
